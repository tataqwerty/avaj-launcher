package com.aircraft;

import com.weather.WeatherTower;
import com.simulator.Logger;
import java.util.TreeMap;

public class JetPlane extends Aircraft implements Flyable {
	interface IWeatherHandler
	{
		public void	handle() throws Exception;
	}

	class SunHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("SUN"));
			coordinates.setLatitude(coordinates.getLatitude() + 10);
			coordinates.setHeight(coordinates.getHeight() + 2);
		}
	}

	class RainHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("RAIN"));
			coordinates.setLatitude(coordinates.getLatitude() + 5);
		}
	}

	class FogHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("FOG"));
			coordinates.setLatitude(coordinates.getLatitude() + 1);
		}
	}

	class SnowHandler implements IWeatherHandler
	{
		public void	handle() throws Exception
		{
			Logger.write(weatherMessages.get("SNOW"));
			coordinates.setHeight(coordinates.getHeight() - 7);
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

	JetPlane(String name, Coordinates coords) {
		super(name, "JetPlane", coords);
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
