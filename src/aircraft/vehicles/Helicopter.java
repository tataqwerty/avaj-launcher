package aircraft.vehicles;

import aircraft.vehicles.base.*;
import weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	public Helicopter(String name, Coordinates coords) {
		super(name, coords);
	}

	public void	updateConditions() {
		
	}

	public void	registerTower(WeatherTower WeatherTower) {
		
	}
}