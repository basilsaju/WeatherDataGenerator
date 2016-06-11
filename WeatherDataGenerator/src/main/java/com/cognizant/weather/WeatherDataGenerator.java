package com.cognizant.weather;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.cognizant.weather.util.FileWrite;
import com.cognizant.weather.util.Log;

public class WeatherDataGenerator {
	
	static Log LOG = new Log();

	// args[0]: location file, args[1]: file that specifies the range of temp, press. & humidity
	public static void main(String[] args) {
		
		Map<String, Cordinates> locationMap = new HashMap<String, Cordinates>();
		Map<String, MinMax> minMaxMap = new HashMap<String, MinMax>();

		/**
		 * file that contains location details: city,latitude,longitude,altitude
		 */
		File locationFile = new File("/Users/basil/location.txt");
		/**
		 * file that contains min and max values for temperature, pressure and
		 * humidity: city, season, min. temp, max. temp, min. pressure, max.
		 * pressure, min. humidity, max. humidity
		 */
		File minMaxFile = new File("/Users/basil/minmax.txt");
		/* check is file exists */
		if ((locationFile.exists() && !locationFile.isDirectory())
				&& (minMaxFile.exists() && !minMaxFile.isDirectory())) {

			locationMap = FileRead.readLocationFile(locationFile);
			minMaxMap = FileRead.readMinMaxFile(minMaxFile);

			StringBuilder weatherReadings = new StringBuilder();
			/* random value generation */
			RandomWeatherEventGenerator generator = new RandomWeatherEventGenerator();
			for (Map.Entry<String, Cordinates> entry : locationMap.entrySet()) {
				Cordinates cordinates = entry.getValue();
				for (int i = 0; i < 5; i++) {
					String temp = generator.startSendingWeatherReadings(entry.getKey(), minMaxMap);
					weatherReadings = weatherReadings.append(entry.getKey() + "|"+ cordinates.getLongitude() + ","
									+ cordinates.getLatitude() + ","+ cordinates.getAltitude() + temp+"\n");
				}
			}
			
			/**
			 * Write output to an output file
			 * 
			 * */
			FileWrite.write("/Users/basil/output.txt",weatherReadings.toString());
			
		} else {
			LOG.error(WeatherDataGenerator.class, "Either or Both File(s) missing in the path specified! Check if "
					+ locationFile.getAbsolutePath()+ " and " + minMaxFile.getAbsolutePath() + " exist.");
		}
	}
}
