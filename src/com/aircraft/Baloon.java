package com.aircraft;

import com.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	interface IWeatherHandler
	{
		public void	handle();
	}

	class SunHandler implements IWeatherHandler
	{
		public void	handle()
		{

		}
	}

	class RainHandler implements IWeatherHandler
	{
		public void	handle()
		{

		}
	}

	class FogHandler implements IWeatherHandler
	{
		public void	handle()
		{

		}
	}

	class SnowHandler implements IWeatherHandler
	{
		public void	handle()
		{

		}
	}

	private	WeatherTower	weatherTower;
	private static TreeMap<String, IWeatherHandler>	weatherHandlers = null;

	Baloon(String name, Coordinates coords) {
		super(name, "Baloon", coords);

		if (weatherHandlers == null)
		{
			weatherHandlers = new TreeMap<String, IWeatherHandler>();
			weatherHandlers.put("SUN", new SunHandler());
			weatherHandlers.put("RAIN", new RainHandler());
			weatherHandlers.put("FOG", new FogHandler());
			weatherHandlers.put("SNOW", new SnowHandler());
		}
	}

	public void	updateConditions() {
		String currentWeather = weatherTower.getWeather(coordinates);

		weatherHandlers.get(currentWeather).handle();
	}

	public void	registerTower(WeatherTower weatherTower) throws Exception
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
