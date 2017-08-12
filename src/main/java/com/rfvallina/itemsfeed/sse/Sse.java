package com.rfvallina.itemsfeed.sse;

import org.springframework.context.event.EventListener;

import com.rfvallina.itemsfeed.event.AbstractApplicationEvent;

public interface Sse {
	
	/**
	 * Push data to SSE channel associated to an event ID
	 * 
	 * @param eventId
	 * @param data
	 */
	public void push(String eventId, Object data);

	/**
	 * This method does the necessary actions to publish the event with the proper data
	 * 
	 * @param eventData
	 */
	public void handle(SseData eventData);

	/**
	 * This method is listening for new events being published. To restrict the events listened to only a specific group, the event classes in
	 * charge of handle the events published must be specified within the annotation @EventListener
	 * 
	 * @param event
	 */
	@EventListener
	public void onPublish(AbstractApplicationEvent event);
}
