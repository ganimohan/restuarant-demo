package com.example.restuarant.datasource.impl.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.restuarant.datasource.impl.DataSourceFactory;
import com.example.restuarant.datasource.impl.FileInputDataSource;

public class DataSourceFactoryTest {
	
	@Test
	public void getDataSource()
	{
		DataSourceFactory factory = new DataSourceFactory();
		assertEquals(FileInputDataSource.class,factory.getDataSource().getClass());
	}

}
