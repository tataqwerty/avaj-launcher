package weather;

import aircraft.vehicles.base.Flyable;

public class Tower {
	private Vector<Flyable>	observers;

	public void register(Flyable flyable) {
		if (!observers.contains(flyable))
			flyable.registerTower(this);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void	conditionsChanged() {

	}
}