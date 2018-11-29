package weather;

import aircraft.vehicles.base.Flyable;
import java.io.*;
import java.util.Vector;

public class Tower {
	private Vector<Flyable>	observers = new Vector<Flyable>();

	public void register(Flyable flyable) {
		if (!observers.contains(flyable))
		{
			System.out.println("Tower says: " + flyable.toString() + " registered to weather tower.");
			observers.add(flyable);
		}
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void	conditionsChanged() {
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
		}
	}
}