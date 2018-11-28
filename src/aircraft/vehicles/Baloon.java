package aircraft.vehicles;

import aircraft.vehicles.base.*;
import weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	public Baloon(String name, Coordinates coords) {
		super(name, coords);
	}
	public void	updateConditions() {

	}
	public void	registerTower(WeatherTower WeatherTower) {
		
	}
}