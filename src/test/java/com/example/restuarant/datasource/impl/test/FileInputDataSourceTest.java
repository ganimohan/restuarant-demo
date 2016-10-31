package com.example.restuarant.datasource.impl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.restuarant.datasource.impl.FileInputDataSource;
import com.example.restuarant.exception.InvalidDatasourceException;
import com.example.restuarant.model.Menu;

public class FileInputDataSourceTest {
	
	@Test
	public void testFileInputWithValidData() throws InvalidDatasourceException
	{
		FileInputDataSource ds = new FileInputDataSource();
		Menu menu = ds.getData();
		assertEquals(10000,menu.getTotalTime());
		assertEquals(100,menu.getDischesCount());
	}

}
