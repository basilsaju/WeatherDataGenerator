package com.cognizant.weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Immutable Temperature Event class. The process control system creates these
 * events.
 */
public class WeatherEvent {

	/** Temperature in Celcius. */
	private int temperature;

	/** Pressure in hPa. */
	private float pressure;

	/** Humidity in %. */
	private float humidity;

	/** Time temperature reading was taken. */
	private Date timeOfReading;

	/**
	 * Temperature constructor.
	 * 
	 * @param temperature
	 *            Temperature in Celsius
	 * @param timeOfReading
	 *            Time of Reading
	 */
	public WeatherEvent(int temperature, float pressure, float humidity,
			Date timeOfReading) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		this.timeOfReading = timeOfReading;
	}

	/**
	 * Get the Temperature.
	 * 
	 * @return Temperature in Celsius
	 */
	public int getTemperature() {
		return temperature;
	}

	/**
	 * Get the Pressure.
	 * 
	 * @return Pressure in hPa
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * Get the humidity.
	 * 
	 * @return humidity in %
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * Get time Temperature reading was taken.
	 * 
	 * @return Time of Reading
	 */
	public Date getTimeOfReading() {
		return timeOfReading;
	}

	@Override
	public String toString() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String tempReadings = "|" + formatter.format(timeOfReading) + "|"
				+ temperature + "|" + String.format("%.2f", pressure) + "|"
				+ String.format("%.2f", humidity);

		return tempReadings;
	}

}