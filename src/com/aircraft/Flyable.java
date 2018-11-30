package com.aircraft;

import com.weather.WeatherTower;

public interface Flyable {
	public void	updateConditions();
	public void	registerTower(WeatherTower WeatherTower) throws Exception;
}