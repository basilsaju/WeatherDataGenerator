package com.cba.weather;

import java.util.Calendar;
import java.util.Date;
/**
 * Class that sets date range and 
 * generate random dates between the dates
 * 
 * */
public class RandomDateGenerator {
	private Date dMin = null;
	private Date dMax = null;
	
	public void setdMin(Date dMin) {
		this.dMin = dMin;
	}

	public void setdMax(Date dMax) {
		this.dMax = dMax;
	}


	/** method to generate random date */
	public Date generate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dMin);
		Long dMinInMillis = cal.getTimeInMillis();
		cal.setTime(dMax);
		Long dMaxInMillis = cal.getTimeInMillis();
		long randDate = (long) (dMinInMillis + Math.random() * (dMaxInMillis - dMinInMillis));
		cal.setTimeInMillis(randDate);

		return cal.getTime();
	}
}