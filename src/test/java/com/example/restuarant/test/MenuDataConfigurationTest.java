
package com.example.restuarant.test;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.restuarant.MenuDataConfiguration;
import com.example.restuarant.datasource.impl.DataSourceFactory;
import com.example.restuarant.exception.DataNotFoundException;
import com.example.restuarant.exception.InvalidDatasourceException;

public class MenuDataConfigurationTest {

	private MenuDataConfiguration config = null;

	@Before
	public void setup()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		config = new MenuDataConfiguration();
	}

	@Test
	public void testValidConfiguration() throws DataNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, InvalidDatasourceException {
		Field dsFactoryField = config.getClass().getDeclaredField("dsFactory");
		dsFactoryField.setAccessible(true);
		DataSourceFactory dsf = new DataSourceFactory();
		dsFactoryField.set(config, dsf);
		Assert.assertNotNull(config.menu());
	}
}
