package com.rfvallina.itemsfeed.sse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rfvallina.itemsfeed.dto.Item;

public class ResultsSseData extends SseData{

	private List<Item> processedItems = new ArrayList<>();
	private int lastIndex;

	public ResultsSseData(String eventId) {
		super();
		setEventId(eventId);
		setStarted(new Date());
		this.setLastIndex(-1);
	}


	public List<Item> getProcessedItems() {
		return processedItems;
	}

	public void setProcessedItems(List<Item> processedItems) {
		this.processedItems = processedItems;
	}


	public int getLastIndex() {
		return lastIndex;
	}


	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	
	
	
}
