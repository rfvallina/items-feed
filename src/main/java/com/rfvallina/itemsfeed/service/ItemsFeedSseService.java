package com.rfvallina.itemsfeed.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfvallina.itemsfeed.dto.Item;
import com.rfvallina.itemsfeed.event.AbstractApplicationEvent;
import com.rfvallina.itemsfeed.event.ResultsEvent;
import com.rfvallina.itemsfeed.sse.ResultsSseData;
import com.rfvallina.itemsfeed.sse.Sse;
import com.rfvallina.itemsfeed.sse.SseData;
import com.rfvallina.itemsfeed.sse.SseEngine;

@Service
public class ItemsFeedSseService implements Sse {

	private static Logger logger = LoggerFactory.getLogger(ItemsFeedSseService.class);

	@Autowired
	SseEngine sseEngine;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void push(String eventId, Object data) {
		sseEngine.runInLoop(this, new ResultsSseData(eventId));
	}

	@Override
	public void handle(SseData eventData) {
		ResultsSseData serviceData = (ResultsSseData) eventData;
		List<Item> items = loadItems();
		int nextIndex = serviceData.getLastIndex() + 1;
		if(items != null && nextIndex < items.size()){
			Item item = items.get(nextIndex);
			serviceData.getProcessedItems().add(item);
			serviceData.setLastIndex(nextIndex);
			try {
				// sleep 1 second for the first element, 2 seconds for the second,... 
				Thread.sleep((nextIndex + 1) * 1000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
			
			applicationEventPublisher.publishEvent(new ResultsEvent(this, serviceData.getEventId(), Arrays.asList(item)));
		}
	}

	@Override
	@EventListener(classes = ResultsEvent.class)
	public void onPublish(AbstractApplicationEvent event) {
		ResultsEvent resultsEvent = (ResultsEvent) event;
		SseEmitter emitter = sseEngine.getEmitters().get(event.getEventId());
		try {

			if (!resultsEvent.getItems().isEmpty()) {
				logger.debug("Sending message through emmitter " + emitter.toString());
				emitter.send(resultsEvent.getItems());
			}

		} catch (IOException e) {
			logger.error("Error in emitter " + emitter + " while sending message");
			sseEngine.getEmitters().remove(event.getEventId());
		}

	}
	
	private List<Item> loadItems(){
		List<Item> items = null;
		ObjectMapper om = new ObjectMapper();
		try {
			items = om.readValue(new File("src/main/resources/json/items.json"), new com.fasterxml.jackson.core.type.TypeReference<List<Item>>(){});
		} catch (Exception e) {
			logger.error("Error parsing JSON file - " + e.getMessage());
		}
		return items;
	}

}
