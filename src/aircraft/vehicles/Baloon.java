package aircraft.vehicles;

import aircraft.vehicles.base.*;
import weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private	WeatherTower	weatherTower;

	public Baloon(String name, Coordinates coords) {
		super(name, "Baloon", coords);
	}

	public void	updateConditions() {

	}

	public void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}