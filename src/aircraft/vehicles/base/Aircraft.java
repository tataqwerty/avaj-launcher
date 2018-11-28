package aircraft.vehicles.base;

public class Aircraft {
	private static long		idCounter;
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;

	protected Aircraft(String name, Coordinates coords) {
		this.name = name;
		this.coordinates = coords;
		this.id = nextId();
		idCounter++;
	}

	private long	nextId() {
		return idCounter + 1;
	}
}