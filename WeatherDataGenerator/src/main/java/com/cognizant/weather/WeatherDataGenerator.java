package com.cognizant.weather;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.cognizant.weather.util.FileWrite;
import com.cognizant.weather.util.Log;
/**
 * Main class that takes location file and minmax file as input
 * 
 * */
public class WeatherDataGenerator {
	
	static Log LOG = new Log();

	// args[0]: location file, args[1]: file that specifies the range of temp, press. & humidity, args[2] output file location
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

			StringBuilder weatherReadings = new StringBuilder();
			/* random value generation */
			RandomWeatherEventGenerator generator = new RandomWeatherEventGenerator();
			
			/*generate values for each location*/
			for (Map.Entry<String, Cordinates> entry : locationMap.entrySet()) {
				Cordinates cordinates = entry.getValue();
				/*generate 100 rows for each season*/
				for (int i = 0; i < 100; i++) {
					/*generate equal number of rows for each season*/
					for(SeasonEnum season: SeasonEnum.values()){
						String readings = generator.startSendingWeatherReadings(entry.getKey(), minMaxMap,season.name());
						weatherReadings = weatherReadings.append(entry.getKey() + "|"+ cordinates.getLongitude() + ","
									+ cordinates.getLatitude() + ","+ cordinates.getAltitude() + readings+"\n");
					}
				}
			}
			
			/**
			 * Write output to an output file
			 * 
			 * */
			FileWrite.write(args[2],weatherReadings.toString());
			
		} else {
			LOG.error(WeatherDataGenerator.class, "Either or Both File(s) missing in the path specified! Check if "
					+ locationFile.getAbsolutePath()+ " and " + minMaxFile.getAbsolutePath() + " exist.");
		}
	}
}
