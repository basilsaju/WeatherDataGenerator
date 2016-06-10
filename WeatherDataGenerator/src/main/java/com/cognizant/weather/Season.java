package com.cognizant.weather;

import java.util.Date;

/* to be deleted!*/
public class Season {

	String getSeason(Date date) {
		int month = date.getMonth();
	    switch(month) {
	          case 11:
	          case 12:
	          case 1:
	          case 2:
	                return "summer";
	          case 3:
	          case 4:
	                return "spring";
	          case 5:
	          case 6:
	          case 7:
	          case 8:
	                return "winter";
	          default:
	                return "autumn";
	      }
	}
	
	/*public void setMinMax(String season) {
	switch (season) {
	case "winter":
		minTemp = 0;
		maxTemp = 20;
		minPressure = 0;
		maxPressure = 20;
		minHumidity = 0;
		maxHumidity = 20;
	case "spring":
		minTemp = 15;
		maxTemp = 25;
		minPressure = 15;
		maxPressure = 25;
		minHumidity = 15;
		maxHumidity = 25;
	case "summer":
		minTemp = 25;
		maxTemp = 50;
		minPressure = 25;
		maxPressure = 50;
		minHumidity = 25;
		maxHumidity = 50;
	case "fall":
		minTemp = 15;
		maxTemp = 25;
		minPressure = 15;
		maxPressure = 25;
		minHumidity = 15;
		maxHumidity = 25;
	}
}*/
}
