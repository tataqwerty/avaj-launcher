package com.weather;

import com.aircraft.Coordinates;
import java.util.Arrays;
import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider	weatherProvider = null;
	private String[]				weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider()
	{}

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String	getCurrentWeather(Coordinates coordinates)
	{
		Random rand = new Random(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight());
		return weather[rand.nextInt(Arrays.asList(weather).size())];
	}
}