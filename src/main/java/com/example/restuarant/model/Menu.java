package com.example.restuarant.model;

import java.util.SortedSet;

/**
 * This class models the menu
 * 
 * @author ganesh
 *
 */
public class Menu {
	
	private SortedSet<Dish> dishes;
	
	private long totalTime;
	
	private long dischesCount;

	public long getDischesCount() {
		return dischesCount;
	}

	public void setDischesCount(long dischesCount) {
		this.dischesCount = dischesCount;
	}

	public SortedSet<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(SortedSet<Dish> dishes) {
		this.dishes = dishes;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	
	

}
