package com.cba.weather;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cba.weather.util.Log;

/**
 * Class generates random weather readings 
 * */
public class RandomWeatherEventGenerator {
	
	String condition;

	Log LOG = new Log();
	/**
	 * Generates the weather readings
	 * */
	public String startSendingWeatherReadings(String city,Map<String, MinMax> map, String season) {
		Random rand = new Random();
		RandomDateGenerator rnd = minMaxDate(season);
		Date date = rnd.generate();
		MinMax minMax = new MinMax(city + "|" + season.toLowerCase(), map);
		int temp = rand.nextInt((minMax.getMaxTemp() - minMax.getMinTemp()) + 1) + minMax.getMinTemp();
		float pressure = rand.nextFloat() * (minMax.getMaxPressure() - minMax.getMinPressure()) + minMax.getMinPressure();
		float humidity = rand.nextFloat() * (minMax.getMaxHumidity() - minMax.getMinHumidity()) + minMax.getMinHumidity();
		condition = getCondition(pressure, humidity, season, date);
		WeatherEvent weatherEvent = new WeatherEvent(temp, pressure, humidity, date, condition);
		String weather = weatherEvent.toString();
		LOG.info(RandomWeatherEventGenerator.class, "WeatherEvent generated is: " + weather);
		
		return weather;
	}
	
	/** 
	 * predict condition based on pressure, temp, humidity and season
	 * @return weather conditions
	 * */
	String getCondition(float pressure, float humidity, String season, Date date) {

		if (pressure > 1000 && humidity > 80){
			if (season.equals("WINTER")) {
				return "snow";
			} else{
				return "rainy";
			}
		}else if(date.getHours()>6 && date.getHours()< 18){
			return "sunny";
		}else
			return "clear sky";
		
	}
	
	/** setMinMax Date
	 * This method is to define the various seasons
	 * @return RandomDateGenerator*/
	RandomDateGenerator minMaxDate(String season){
		RandomDateGenerator randomDateGenerator = new RandomDateGenerator();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String minDate;
		String maxDate;
		
		switch(season){
		case "SUMMER":
			minDate = "01-11-2016 00:00:01";
			maxDate = "28-02-2017 23:59:59";
			try {
				randomDateGenerator.setdMin(formatter.parse(minDate));
				randomDateGenerator.setdMax(formatter.parse(maxDate));
			} catch (ParseException e) {
				LOG.error(RandomWeatherEventGenerator.class, "Check if date is in dd-MM-yyyy HH:mm:ss format");
			}
			break;
			
		case "SPRING":
			minDate = "01-03-2016 00:00:01";
			maxDate = "30-05-2016 23:59:59";
			try {
				randomDateGenerator.setdMin(formatter.parse(minDate));
				randomDateGenerator.setdMax(formatter.parse(maxDate));
			} catch (ParseException e) {
				LOG.error(RandomWeatherEventGenerator.class, "Check if date is in dd-MM-yyyy HH:mm:ss format");
			}
			break;
			
		case "WINTER":
			minDate = "01-06-2016 00:00:01";
			maxDate = "30-08-2016 23:59:59";
			try {
				randomDateGenerator.setdMin(formatter.parse(minDate));
				randomDateGenerator.setdMax(formatter.parse(maxDate));
			} catch (ParseException e) {
				LOG.error(RandomWeatherEventGenerator.class, "Check if date is in dd-MM-yyyy HH:mm:ss format");
			}
			break;
		
		default:
			minDate = "01-09-2016 00:00:01";
			maxDate = "31-10-2016 23:59:59";
			try {
				randomDateGenerator.setdMin(formatter.parse(minDate));
				randomDateGenerator.setdMax(formatter.parse(maxDate));
			} catch (ParseException e) {
				LOG.error(RandomWeatherEventGenerator.class, "Check if date is in dd-MM-yyyy HH:mm:ss format");
			}
		
		}
		return randomDateGenerator;		
		
	}
	
}
