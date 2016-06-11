package com.cognizant.weather.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	
	public void error(Class<?> clazz, String msg){
		Logger LOG = LoggerFactory.getLogger(clazz);
		LOG.error(msg);
		
	}
	
	public void info(Class<?> clazz, String msg){
		Logger LOG = LoggerFactory.getLogger(clazz);
		LOG.info(msg);
		
	}

}
