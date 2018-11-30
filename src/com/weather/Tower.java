package com.weather;

import com.aircraft.Flyable;
import com.simulator.Logger;
import java.util.Vector;
import java.io.*;

public class Tower {
	private Vector<Flyable>		observers;

	Tower()
	{
		observers = new Vector<Flyable>();
	}

	public void register(Flyable flyable) throws Exception
	{
		if (!observers.contains(flyable))
		{
			observers.add(flyable);
			Logger.write("Tower says: " + flyable.toString() + " registered to weather tower.\n");
		}
	}

	public void unregister(Flyable flyable) throws Exception
	{
		observers.remove(flyable);
		Logger.write("Tower says: " + flyable.toString() + " unregistered from weather tower.\n");
	}

	protected void	conditionsChanged() throws Exception
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
		}
	}
}