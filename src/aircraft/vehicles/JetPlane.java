package aircraft.vehicles;

import aircraft.vehicles.base.*;
import weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	public JetPlane(String name, Coordinates coords) {
		super(name, coords);
	}
	public void	updateConditions() {
	}
	public void	registerTower(WeatherTower WeatherTower) {
		
	}
}