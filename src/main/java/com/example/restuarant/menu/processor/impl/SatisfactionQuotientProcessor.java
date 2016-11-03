package com.example.restuarant.menu.processor.impl;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.restuarant.menu.processor.IMenuProcessor;
import com.example.restuarant.model.Dish;
import com.example.restuarant.model.Menu;

/**
 * Processor class which shall be used to fetch the highest satisfaction value
 * for a given time t defined in the menu
 * 
 * @author ganesh
 *
 */
public class SatisfactionQuotientProcessor implements IMenuProcessor {

	Logger logger = Logger.getLogger(SatisfactionQuotientProcessor.class);

	@Autowired
	private Menu menu;

	@Override
	public Integer processMenu() {

		int menuItems = this.menu.getDishes().size();
		int menuTime = this.menu.getTotalTime();

		Set<Dish> dishes = this.menu.getDishes();
		Iterator<Dish> ite = dishes.iterator();

		Integer[] dishesTime = new Integer[dishes.size()];
		Integer[] satisfactionValue = new Integer[dishes.size()];
		int i = 0;

		while (ite.hasNext()) {
			Dish dish = ite.next();
			dishesTime[i] = dish.getTimeTakenToConsume();
			satisfactionValue[i] = dish.getSatisfactionNumber();
			i++;
		}

		int[][] satisfactionMatrix = new int[menuItems + 1][menuTime + 1];

		for (int col = 0; col <= menuTime; col++) {
			satisfactionMatrix[0][col] = 0;
		}

		for (int row = 0; row <= menuItems; row++) {
			satisfactionMatrix[row][0] = 0;
		}

		for (int item = 1; item <= menuItems; item++) {
			for (int time = 1; time <= menuTime; time++) {
				if (dishesTime[item - 1] <= time) {
					satisfactionMatrix[item][time] = Math.max(
							satisfactionValue[item - 1] + satisfactionMatrix[item - 1][time - dishesTime[item - 1]],
							satisfactionMatrix[item - 1][time]);
				} else {
					satisfactionMatrix[item][time] = satisfactionMatrix[item - 1][time];
				}
			}
		}
		return satisfactionMatrix[menuItems][menuTime];
	}
}
