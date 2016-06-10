package com.cognizant.weather;

import java.util.Calendar;
import java.util.Date;

public class RandomDateGenerator {

	private Date dMin = null;
	private Date dMax = null;

	/** Creates a new instance of RandomDateGenerator */
	public RandomDateGenerator(Date min, Date max) {
		dMin = min;
		dMax = max;
	}

	/** method to generate random date */
	public Date generate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dMin);
		Long dMinInMillis = cal.getTimeInMillis();
		cal.setTime(dMax);
		Long dMaxInMillis = cal.getTimeInMillis();
		long randDate = (long) (dMinInMillis + Math.random()
				* (dMaxInMillis - dMinInMillis));
		cal.setTimeInMillis(randDate);

		return cal.getTime();
	}
}