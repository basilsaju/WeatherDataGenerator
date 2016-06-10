package com.cognizant.weather;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomWeatherEventGenerator {
	
	String condition;
	String season;

	Logger LOG = LoggerFactory.getLogger(RandomWeatherEventGenerator.class);
	public String startSendingTemperatureReadings(String city,
			Map<String, MinMax> map) {
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
		WeatherEvent weatherEvent = new WeatherEvent(temp, pressure, humidity, date);
		condition = getCondition(weatherEvent);
		String weather = weatherEvent.toString()+"|"+condition;
		LOG.info("WeatherEvent generated is: " + weather);
		
		return weather;
	}

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
	
	String getCondition(WeatherEvent weatherEvent) {
		if (weatherEvent.getHumidity() > 90 && weatherEvent.getTemperature() < 10 && weatherEvent.getHumidity() > 1000)
			if (season.equals("winter")) {
				return "snow";
			} else{
				return "rainy";
			}
		else
			return "sunny";
	}

}
