package com.example.restuarant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.restuarant.datasource.impl.DataSourceFactory;
import com.example.restuarant.exception.InvalidDatasourceException;
import com.example.restuarant.model.Menu;

/**
 * Configuration class which creates the bean of type Menu.
 * 
 * @author ganesh
 */
@Configuration
public class MenuDataConfiguration {

	@Autowired
	private DataSourceFactory dsFactory;

	@Bean
	public Menu menu() throws InvalidDatasourceException {
		return dsFactory.getDataSource().getData();
	}
}
