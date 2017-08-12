package com.rfvallina.itemsfeed.sse;

import java.util.Date;

public abstract class SseData {

	protected String eventId;
	protected Date started;
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}
	
}
