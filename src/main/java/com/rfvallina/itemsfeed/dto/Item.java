package com.rfvallina.itemsfeed.dto;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = -2292329342638710330L;

	String itemId;
	String img;
	String title;
	String description;
	String category;
	String country;
	String condition;
	Integer quantity;
	Double currentPrice;
	Double shipServiceCost;
	long retrievedTime;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}


	public Double getShipServiceCost() {
		return shipServiceCost;
	}

	public void setShipServiceCost(Double shipServiceCost) {
		this.shipServiceCost = shipServiceCost;
	}

	public long getRetrievedTime() {
		return retrievedTime;
	}

	public void setRetrievedTime(long retrievedTime) {
		this.retrievedTime = retrievedTime;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Item && this.getItemId().equals(((Item) o).getItemId());
	}
}
