package aircraft.vehicles;

import aircraft.vehicles.base.*;
import weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private	WeatherTower	weatherTower;

	public JetPlane(String name, Coordinates coords) {
		super(name, "JetPlane", coords);
	}

	public void	updateConditions() {

	}

	public void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}