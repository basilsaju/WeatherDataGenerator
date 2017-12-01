package com.cba.weather.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Logger class
 * @param classname, message
 * */
public class Log {
	
	/*logs error*/
	public void error(Class<?> clazz, String msg){
		Logger LOG = LoggerFactory.getLogger(clazz);
		LOG.error(msg);
		
	}
	/*logs info*/
	public void info(Class<?> clazz, String msg){
		Logger LOG = LoggerFactory.getLogger(clazz);
		LOG.info(msg);
		
	}

}
