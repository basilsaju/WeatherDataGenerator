package com.cognizant.weather;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherDataGenerator {
	
	static Logger LOG = LoggerFactory.getLogger(WeatherDataGenerator.class);

	// args[0]: location file, args[1]: file that specifies the range of temp, press. & humidity
	public static void main(String[] args) {
		
		Map<String, Cordinates> locationMap = new HashMap<String, Cordinates>();
		Map<String, MinMax> minMaxMap = new HashMap<String, MinMax>();

		/**
		 * file that contains location details: city,latitude,longitude,altitude
		 */
		File locationFile = new File(args[0]);
		/**
		 * file that contains min and max values for temperature, pressure and
		 * humidity: city, season, min. temp, max. temp, min. pressure, max.
		 * pressure, min. humidity, max. humidity
		 */
		File minMaxFile = new File(args[1]);
		/* check is file exists */
		if ((locationFile.exists() && !locationFile.isDirectory())
				&& (minMaxFile.exists() && !minMaxFile.isDirectory())) {

			locationMap = FileRead.readLocationFile(locationFile);
			minMaxMap = FileRead.readMinMaxFile(minMaxFile);

			/* random value generation */
			RandomWeatherEventGenerator generator = new RandomWeatherEventGenerator();
			for (Map.Entry<String, Cordinates> entry : locationMap.entrySet()) {
				Cordinates cordinates = entry.getValue();
				for (int i = 0; i < 5; i++) {
					String temp = generator.startSendingTemperatureReadings(
							entry.getKey(), minMaxMap);
					System.out.println(entry.getKey() + "|"+ cordinates.getLongitude() + ","
							+ cordinates.getLatitude() + ","+ cordinates.getAltitude() + temp);
				}
			}
		} else {
			LOG.error("Either or Both File(s) missing in the path specified! Check if "
					+ locationFile.getAbsolutePath()+ " and " + minMaxFile.getAbsolutePath() + " exist.");
		}
	}
}
