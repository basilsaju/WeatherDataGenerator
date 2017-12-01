package com.cba.weather;

import java.util.Map;
/**
 * POJO with minTemp, maxTemp, minPressure, maxPressure, minHumidity, maxHumidity
 *  
 * */
public class MinMax {

	/** Temperature in Celcius. */
	private int minTemp;
	private int maxTemp;
	
	/** Pressure in hPa. */
	private int minPressure;
	private int maxPressure;
	
	/** Humidity in %. */
	private float minHumidity;
	private float maxHumidity;

	public MinMax(int minTemp, int maxTemp, int minPressure, int maxPressure,
			float minHumidity, float maxHumidity) {

		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.minPressure = minPressure;
		this.maxPressure = maxPressure;
		this.minHumidity = minHumidity;
		this.maxHumidity = maxHumidity;
	}

	/* populate the max and min values based on city and season*/
	public MinMax(String key, Map<String, MinMax> map) {
		this.minTemp = map.get(key).getMinTemp();
		this.maxTemp = map.get(key).getMaxTemp();
		this.minPressure = map.get(key).getMinPressure();
		this.maxPressure = map.get(key).getMaxPressure();
		this.minHumidity = map.get(key).getMinHumidity();
		this.maxHumidity = map.get(key).getMaxHumidity();

	}

	/**
	 * Get the Temperature.
	 * 
	 * @return Temperature in Celsius
	 */
	
	public int getMinTemp() {
		return minTemp;
	}

	/**
	 * Set the Temperature.
	 * 
	 * @return Temperature in Celsius
	 */
	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	/**
	 * Get the Temperature.
	 * 
	 * @return Temperature in Celsius
	 */
	public int getMaxTemp() {
		return maxTemp;
	}

	/**
	 * Set the Temperature.
	 * 
	 */
	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	/**
	 * Get the Pressure.
	 * 
	 * @return Pressure in hPa
	 */
	public int getMinPressure() {
		return minPressure;
	}

	/**
	 * Set the Pressure.
	 * 
	 */
	public void setMinPressure(int minPressure) {
		this.minPressure = minPressure;
	}

	/**
	 * Get the Pressure.
	 * 
	 * @return Pressure in hPa
	 */
	public int getMaxPressure() {
		return maxPressure;
	}

	/**
	 * Set the Pressure.
	 * 
	 */
	public void setMaxPressure(int maxPressure) {
		this.maxPressure = maxPressure;
	}

	/**
	 * Get the humidity.
	 * 
	 * @return humidity in %
	 */
	public float getMinHumidity() {
		return minHumidity;
	}

	/**
	 * Set the humidity.
	 * 
	 */
	public void setMinHumidity(float minHumidity) {
		this.minHumidity = minHumidity;
	}

	/**
	 * Get the humidity.
	 * 
	 * @return humidity in %
	 */
	public float getMaxHumidity() {
		return maxHumidity;
	}

	/**
	 * Set the humidity.
	 * 
	 */
	public void setMaxHumidity(float maxHumidity) {
		this.maxHumidity = maxHumidity;
	}
}
