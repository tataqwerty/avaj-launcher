package com.weather;

import com.aircraft.Coordinates;
import java.io.*;

public class WeatherTower extends Tower {
	public String	getWeather(Coordinates coordinates)
	{
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void	changeWeather() throws Exception
	{
		conditionsChanged();
	}

	public void	changeWeatherHandler() throws Exception
	{
		changeWeather();
	}
}