package com.aircraft;

import com.weather.WeatherTower;

public interface Flyable {
	public void	updateConditions() throws Exception;
	public void	registerTower(WeatherTower WeatherTower) throws Exception;
}