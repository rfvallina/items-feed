package com.rfvallina.itemsfeed.event;

import java.util.List;

import com.rfvallina.itemsfeed.dto.Item;

public class ResultsEvent extends AbstractApplicationEvent{

	private static final long serialVersionUID = 2831716832308882027L;
	protected List<Item> items;
	
	public ResultsEvent(Object source, String eventId, List<Item> items) {
		super(source, eventId);
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
	
}
