package com.rfvallina.itemsfeed.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.rfvallina.itemsfeed.service.ItemsFeedSseService;
import com.rfvallina.itemsfeed.sse.SseEngine;


@Controller
@CrossOrigin
public class FeedController {
	
	@Autowired
	SseEngine sseEngine;
	
	@Autowired
	ItemsFeedSseService sseService;

	@GetMapping("/feed")
	public SseEmitter getResults() {
		String eventId = UUID.randomUUID().toString();
		SseEmitter emitter = new SseEmitter(sseEngine.getTimeout());
		sseEngine.getEmitters().put(eventId, emitter);

		// push notifications
		sseService.push(eventId, null);

		return emitter;
	}
}
