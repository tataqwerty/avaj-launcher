package aircraft;

import aircraft.vehicles.*;
import aircraft.vehicles.base.*;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;

public class AircraftFactory {
	private interface	ICreator {
		Flyable	createAircraft(String name, Coordinates coords);
	}

	private static class BaloonCreator implements ICreator {
		public Flyable	createAircraft(String name, Coordinates coords) {
			return new Baloon(name, coords);
		}
	}

	private static class HelicopterCreator implements ICreator {
		public Flyable	createAircraft(String name, Coordinates coords) {
			return new Helicopter(name, coords);
		}
	}

	private static class JetPlaneCreator implements ICreator {
		public Flyable	createAircraft(String name, Coordinates coords) {
			return new JetPlane(name, coords);
		}
	}

	public static Flyable	newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
		TreeMap<String, ICreator>	createFunctions = new TreeMap<String, ICreator>();

		createFunctions.put("Baloon", new BaloonCreator());
		createFunctions.put("Helicopter", new HelicopterCreator());
		createFunctions.put("JetPlane", new JetPlaneCreator());

		/* for safety reasons */
		if (createFunctions.get(type) == null)
			throw new Exception("Invalid aircraft type");

		return createFunctions.get(type).createAircraft(name, new Coordinates(longitude, latitude, height));
	}
}