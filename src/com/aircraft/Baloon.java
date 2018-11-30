package com.aircraft;

import com.weather.WeatherTower;
import com.simulator.Logger;
import java.util.TreeMap;
import java.io.*;

public class Baloon extends Aircraft implements Flyable {
	interface IWeatherHandler
	{
		public void	handle() throws Exception;
	}

	class SunHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("SUN"));
			coordinates.setLongitude(coordinates.getLongitude() + 2);
			coordinates.setHeight(coordinates.getHeight() + 4);
		}
	}

	class RainHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("RAIN"));
			coordinates.setHeight(coordinates.getHeight() - 5);
			if (coordinates.getHeight() == 0)
				land();
		}
	}

	class FogHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("FOG"));
			coordinates.setHeight(coordinates.getHeight() - 3);
			if (coordinates.getHeight() == 0)
				land();
		}
	}

	class SnowHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("SNOW"));
			coordinates.setHeight(coordinates.getHeight() - 15);
			if (coordinates.getHeight() == 0)
				land();
		}
	}

	private	WeatherTower	weatherTower;
	private static TreeMap<String, IWeatherHandler>	weatherHandlers = new TreeMap<String, IWeatherHandler>();
	{
		weatherHandlers.put("SUN", new SunHandler());
		weatherHandlers.put("RAIN", new RainHandler());
		weatherHandlers.put("FOG", new FogHandler());
		weatherHandlers.put("SNOW", new SnowHandler());
	}

	Baloon(String name, Coordinates coords) {
		super(name, "Baloon", coords);
	}

	public void	updateConditions() throws Exception
	{
		String currentWeather = weatherTower.getWeather(coordinates);

		weatherHandlers.get(currentWeather).handle();
	}

	public void	registerTower(WeatherTower weatherTower) throws Exception
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

	private void	land() throws Exception
	{
		Logger.write(toString() + " landing.");
		weatherTower.unregister(this);
		this.weatherTower = null;
	}
}
