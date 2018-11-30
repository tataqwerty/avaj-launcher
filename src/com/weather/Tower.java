package com.weather;

import com.aircraft.Flyable;
import com.simulator.Logger;
import java.io.*;
import java.util.Vector;

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

	public void unregister(Flyable flyable)
	{
		observers.remove(flyable);
	}

	protected void	conditionsChanged()
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
		}
	}
}