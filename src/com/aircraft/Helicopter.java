package com.aircraft;

import com.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private	WeatherTower	weatherTower;

	Helicopter(String name, Coordinates coords) {
		super(name, "Helicopter", coords);
	}

	public void	updateConditions() {

	}

	public void	registerTower(WeatherTower weatherTower) throws Exception
	{
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
