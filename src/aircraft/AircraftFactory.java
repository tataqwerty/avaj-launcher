package aircraft;

import aircraft.vehicles.*;
import aircraft.vehicles.base.*;
import java.util.TreeMap;

public class AircraftFactory {
	static final TreeMap<String, f()>	funcArray = {

	};

	private static Flyable	createHelicopter(String name, Coordinates coords) {
		return new Helicopter(name, coords);
	}
	
	private static Flyable	createBaloon(String name, Coordinates coords) {
		return new Baloon(name, coords);
	}

	private static Flyable	createJetPlane(String name, Coordinates coords) {
		return new JetPlane(name, coords);
	}

	public static Flyable	newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
		//	for safety reasons
		if (funcArray[type] == null)
			throw new Exception("Invalid aircraft type");

		return funcArray[type](name, new Coordinates(longitude, latitude, height));
	}
}