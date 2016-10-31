package com.example.restuarant.menu.processor.impl.test;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import com.example.restuarant.datasource.impl.FileInputDataSource;
import com.example.restuarant.exception.DataNotFoundException;
import com.example.restuarant.exception.InvalidDatasourceException;
import com.example.restuarant.menu.processor.impl.SatisfactionQuotientProcessor;
import com.example.restuarant.model.Menu;

public class SatisfactionQuotientProcessorTest {

	private Menu menu = null;

	private SatisfactionQuotientProcessor processor;

	@Before
	public void setup()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		FileInputDataSource dataSource = new FileInputDataSource();
		processor = new SatisfactionQuotientProcessor();
		try {
			menu = dataSource.getData();
		} catch (InvalidDatasourceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testProcessorForValidMenuData() throws DataNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Field menuField = processor.getClass().getDeclaredField("menu");
		menuField.setAccessible(true);
		menuField.set(processor, menu);
		int highestQuotientFactor = this.processor.processMenu();
		org.junit.Assert.assertEquals(1829, highestQuotientFactor);
	}

	@Test(expected = DataNotFoundException.class)
	public void testProcessorForNullMenu() throws DataNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		this.processor.processMenu();
	}

}
