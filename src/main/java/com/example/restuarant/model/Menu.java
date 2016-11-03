package com.example.restuarant.model;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class models the menu
 * 
 * @author ganesh
 *
 */
public class Menu {

	private SortedSet<Dish> dishes;

	private int totalTime;

	private int dischesCount;

	public int getDischesCount() {
		return dischesCount;
	}

	public void setDischesCount(int dischesCount) {
		this.dischesCount = dischesCount;
	}

	public SortedSet<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(SortedSet<Dish> dishes) {
		this.dishes = dishes;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
}
