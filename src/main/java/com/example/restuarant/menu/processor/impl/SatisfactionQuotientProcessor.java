package com.example.restuarant.menu.processor.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.restuarant.exception.DataNotFoundException;
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
	public Integer processMenu() throws DataNotFoundException {
		int highSatisfactionNumber = 0;
		if (menu != null) {
			Set<Dish> dishes = menu.getDishes();
			Object[] dishArray = dishes.toArray();
			for (int i = dishArray.length - 1; i >= 0; i--) {
				Dish highTimeDish = (Dish) dishArray[i];
				int dishConsumedTime = highTimeDish.getTimeTakenToConsume();
				if (highTimeDish.getTimeTakenToConsume() == menu.getTotalTime()) {
					highSatisfactionNumber = highTimeDish.getSatisfactionNumber();
					break;
				}
				int satisfactionNumber = highTimeDish.getSatisfactionNumber();
				for (int j = 0; j < dishArray.length; j++) {
					Dish lowTimeDish = (Dish) dishArray[j];
					if (highTimeDish != lowTimeDish) {
						dishConsumedTime += lowTimeDish.getTimeTakenToConsume();
						if (dishConsumedTime < menu.getTotalTime()) {
							satisfactionNumber += lowTimeDish.getSatisfactionNumber();
						} else {
							break;
						}
					}
				}
				if (satisfactionNumber > highSatisfactionNumber) {
					highSatisfactionNumber = satisfactionNumber;
				}
			}
			return highSatisfactionNumber;
		}
		String message = "Invalid menu";
		logger.error(message);
		throw new DataNotFoundException(message);
	}
}
