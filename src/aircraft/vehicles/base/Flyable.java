package aircraft.vehicles.base;

import weather.WeatherTower;

public interface Flyable {
	public void	updateConditions();
	public void	registerTower(WeatherTower WeatherTower);
	public String	toString();
}