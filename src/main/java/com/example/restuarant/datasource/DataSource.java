package com.example.restuarant.datasource;

import org.apache.log4j.Logger;

import com.example.restuarant.exception.InvalidDatasourceException;
import com.example.restuarant.model.Menu;

/**
 * Implementation classes will define its own way of obtaining reference to a datasource.
 * 
 * @author ganesh
 *
 */
public abstract class DataSource {

	protected Logger logger = Logger.getLogger(DataSource.class);

	public abstract Menu getData() throws InvalidDatasourceException;

}
