package com.aircraft;

import com.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private	WeatherTower	weatherTower;

	JetPlane(String name, Coordinates coords) {
		super(name, "JetPlane", coords);
	}

	public void	updateConditions() {

	}

	public void	registerTower(WeatherTower weatherTower) throws Exception
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
