package com.cognizant.weather;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import com.cognizant.weather.util.Log;

public class RandomWeatherEventGenerator {
	
	String condition;
	String season;

	Log LOG = new Log();
	/**
	 * Generates the weather readings
	 * */
	public String startSendingWeatherReadings(String city,Map<String, MinMax> map) {
		Random rand = new Random();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -1); // today minus one year
		Date dMin = cal.getTime();
		cal.add(Calendar.YEAR, 2); // today plus 2 years
		Date dMax = cal.getTime();
		RandomDateGenerator rnd = new RandomDateGenerator(dMin, dMax);
		Date date = rnd.generate();
		MinMax minMax = new MinMax(city + "|" + getSeason(date), map);
		int temp = rand.nextInt((minMax.getMaxTemp() - minMax.getMinTemp()) + 1) + minMax.getMinTemp();
		float pressure = rand.nextFloat() * (minMax.getMaxPressure() - minMax.getMinPressure()) + minMax.getMinPressure();
		float humidity = rand.nextFloat() * (minMax.getMaxHumidity() - minMax.getMinHumidity()) + minMax.getMinHumidity();
		condition = getCondition(temp, pressure, humidity);
		WeatherEvent weatherEvent = new WeatherEvent(temp, pressure, humidity, date, condition);
		String weather = weatherEvent.toString();
		LOG.info(RandomWeatherEventGenerator.class, "WeatherEvent generated is: " + weather);
		
		return weather;
	}

	/* returns the season based on month of date */
	String getSeason(Date date) {
		int month = date.getMonth();
		switch (month) {
		case 11:
		case 12:
		case 1:
		case 2:
			return "summer";
		case 3:
		case 4:
		case 5:
			return "spring";
		case 6:
		case 7:
		case 8:
			return "winter";
		default:
			return "autumn";
		}
	}
	
	String getCondition(int temp, float pressure, float humidity) {
		if (pressure > 90 && temp < 10 && humidity > 1000)
			if (season.equals("winter")) {
				return "snow";
			} else{
				return "rainy";
			}
		else
			return "sunny";
	}
}
