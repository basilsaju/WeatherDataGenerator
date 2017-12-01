package com.cba.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cba.weather.util.Log;

/**
 * Reads the location file and minmax file
 * */
public class FileRead {

	static Log LOG = new Log();
	static BufferedReader in = null;
	static Map<String, Cordinates> locationMap = new HashMap<String, Cordinates>();
	static Map<String, MinMax> minMaxMap = new HashMap<String, MinMax>();

	/**
	 * Read location file
	 * file contains data in the format: latitude, longitude,altitude
	 * 
	 * @return Map<String, Cordinates>
	 * */
	static Map<String, Cordinates> readLocationFile(File locationFile) {
		FileReader reader = null;
		try {
			reader = new FileReader(locationFile);
		} catch (FileNotFoundException e) {
			LOG.error(FileRead.class,"File not found!");
		}
		in = new BufferedReader(reader);
		String string;
		String[] inputs;

		/* copy geographical information to hashmap */
		try {
			while ((string = in.readLine()) != null) {
				inputs = string.split(",");
				if (inputs != null && inputs.length == 4) {
					Cordinates cordinates = new Cordinates();
					cordinates.setLatitude(Float.parseFloat(inputs[1]));
					cordinates.setLongitude(Float.parseFloat(inputs[2]));
					cordinates.setAltitude(Integer.parseInt(inputs[3]));
					locationMap.put(inputs[0].substring(0, 3).toUpperCase(),cordinates);
				}
			}
		} catch (NumberFormatException e) {
			LOG.error(FileRead.class,"Number format issue! Check if the values(lat., long., alt.) are given in proper format.");
		} catch (IOException e) {
			LOG.error(FileRead.class,"IOException! Check if file is correct.");
		}
		return locationMap;
	 }

	static Map<String, MinMax> readMinMaxFile(File minMaxFile) {
			FileReader reader = null;
		try {
			reader = new FileReader(minMaxFile);
		} catch (FileNotFoundException e) {
			LOG.error(FileRead.class,"File not found!");

		}
		in = new BufferedReader(reader);
		
		String string;
		String[] inputs;

		/*
		 * copy min and max temp, pressure and humidity for each
		 * city|season(key) to hashmap
		 */
		try {
			while ((string = in.readLine()) != null) {
				inputs = string.split(",");
				if (inputs != null && inputs.length == 8) {
					MinMax minMax = new MinMax(Integer.parseInt(inputs[2]),
							Integer.parseInt(inputs[3]),
							Integer.parseInt(inputs[4]),
							Integer.parseInt(inputs[5]),
							Float.parseFloat(inputs[6]),
							Float.parseFloat(inputs[7]));
					minMaxMap.put(inputs[0].substring(0, 3).toUpperCase() + "|" + inputs[1], minMax);
				}
			}
		} catch (NumberFormatException e) {
			LOG.error(FileRead.class,"Number format issue! Check if the values are given in proper format.");
		} catch (IOException e) {
			LOG.error(FileRead.class,"IOException! Check if file is correct.");
		}
		return minMaxMap;
	}
}
