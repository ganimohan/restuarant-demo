package com.example.restuarant.datasource.impl;

import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.core.io.ClassPathResource;

import com.example.restuarant.datasource.DataSource;
import com.example.restuarant.exception.InvalidDatasourceException;
import com.example.restuarant.model.Dish;
import com.example.restuarant.model.Menu;

/**
 * Data source which shall be used to fetch the input data from file resource.
 * This data source uses the file provided as a reference for this application
 * 
 * @author ganesh
 *
 */
public class FileInputDataSource extends DataSource {

	/**
	 * Reference to the input data file. The same can be made configurable in application.properties.
	 */
	private static final String INPUT_DATA = "data.txt";

	/**
	 * Input data file separator.
	 */
	private static final String INPUT_DATA_SEPARATOR = " ";

	@Override
	public Menu getData() throws InvalidDatasourceException {
		ClassPathResource resource = new ClassPathResource(INPUT_DATA);
		boolean menuProcessed = false;
		Scanner scanner = null;
		Menu menu = null;
		try {
			scanner = new Scanner(resource.getInputStream());
			menu = new Menu();
			SortedSet<Dish> dishes = new TreeSet<Dish>();
			menu.setDishes(dishes);
			while (scanner.hasNext()) {
				String dataLine = scanner.nextLine();
				String[] items = dataLine.split(INPUT_DATA_SEPARATOR);
				if (!menuProcessed) {
					menu.setTotalTime(Long.valueOf(items[0]));
					menu.setDischesCount(Long.valueOf(items[1]));
					menuProcessed = true;
				} else {
					Dish dish = new Dish();
					int timeTakenToConsume = Integer.valueOf(items[0]);
					if (timeTakenToConsume <= menu.getTotalTime()) {
						dish.setTimeTakenToConsume(Integer.valueOf(items[0]));
						dish.setSatisfactionNumber(Integer.valueOf(items[1]));
						menu.getDishes().add(dish);
					}
				}
			}
		} catch (IOException e) {
			String message = "Failed to parse the input data file";
			logger.error(message);
			throw new InvalidDatasourceException(message,e);
		} finally {
			scanner.close();
		}
		return menu;
	}

}
