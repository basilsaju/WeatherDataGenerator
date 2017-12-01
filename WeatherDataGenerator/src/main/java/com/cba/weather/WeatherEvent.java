package com.cba.weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Temperature Event class. The process control system creates these events.
 */
public class WeatherEvent {

	/** Temperature in Celsius. */
	private int temperature;

	/** Pressure in hPa. */
	private float pressure;

	/** Humidity in %. */
	private float humidity;

	/** Time temperature reading was taken. */
	private Date timeOfReading;

	/** weather condition */
	private String condition;

	/**
	 * Temperature constructor.
	 * 
	 * @param temperature
	 *            Temperature in Celsius
	 * @param timeOfReading
	 *            Time of Reading
	 */
	public WeatherEvent(int temperature, float pressure, float humidity,
			Date timeOfReading, String condition) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		this.timeOfReading = timeOfReading;
		this.condition = condition;
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

	/**
	 * Get the weather condition.
	 * 
	 * @return weather condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Set the weather condition.
	 * 
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String tempReadings = "|" + formatter.format(timeOfReading) + "|"
				+ condition + "|" + temperature + "|"
				+ String.format("%.2f", pressure) + "|"
				+ String.format("%.2f", humidity);

		return tempReadings;
	}

}