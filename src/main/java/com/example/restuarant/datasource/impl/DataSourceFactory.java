package com.example.restuarant.datasource.impl;

import com.example.restuarant.datasource.DataSource;

/**
 * Datasource factory class which shall be used to obtain an appropriate data source to fetch the input
 * data for the restaurant application.
 * 
 * @author ganesh
 *
 */
public class DataSourceFactory {

	public DataSource getDataSource()
	{
		return new FileInputDataSource();
	}
}
