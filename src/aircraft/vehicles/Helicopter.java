package aircraft.vehicles;

import aircraft.vehicles.base.*;
import weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private	WeatherTower	weatherTower;

	public Helicopter(String name, Coordinates coords) {
		super(name, "Helicopter", coords);
	}

	public void	updateConditions() {

	}

	public void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}