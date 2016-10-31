package com.example.restuarant.menu.processor;

import com.example.restuarant.exception.DataNotFoundException;

/**
 * Implementation classes shall define the specifics to parse and obtain the menu data.
 * 
 * @author ganesh
 *
 * @param <T>
 */
public interface IMenuProcessor<T> {
	
	public T processMenu() throws DataNotFoundException;

}
