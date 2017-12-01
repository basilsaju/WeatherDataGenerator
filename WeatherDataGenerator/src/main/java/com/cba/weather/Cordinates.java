package com.cba.weather;

import java.text.DecimalFormat;

/**
 * POJO with latitude, longitude and altitude
 * 
 * */
public class Cordinates {
	private float latitude;
	private float longitude;
	private int altitude;

	/**
	 * Get the latitude.
	 * 
	 * @return latitude as float with 2 decimal places
	 */
	public float getLatitude() {
		DecimalFormat df = new DecimalFormat("#.##");
		return Float.parseFloat(df.format(latitude));
		//return latitude;
	}

	/**
	 * Set the Latitude.
	 * 
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get the Longitude.
	 * 
	 * @return longitude as float with 2 decimal places
	 */
	public float getLongitude() {
		return longitude;
	}

	/**
	 * Get the Longitude.
	 * 
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	/**
	 * Get the Altitude.
	 * 
	 * @return Altitude in int
	 */
	public int getAltitude() {
		return altitude;
	}

	/**
	 * Get the Altitude.
	 * 
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

}
