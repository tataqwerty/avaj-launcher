package com.weather;

import com.aircraft.Coordinates;

public class WeatherTower extends Tower {
	public String	getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void	changeWeather() {
		conditionsChanged();
	}

	public void	changeWeatherHandler() {
		changeWeather();
	}
}