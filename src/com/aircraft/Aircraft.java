package com.aircraft;

public class Aircraft {
	private static long		idCounter;
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	protected String		type;

	protected Aircraft(String name, String type, Coordinates coords)
	{
		this.type = type;
		this.name = name;
		this.coordinates = coords;
		this.id = nextId();
		idCounter++;
	}

	private long	nextId()
	{
		return idCounter + 1;
	}

	public String	toString()
	{
		return this.type + "#" + this.name + "(" + this.id + ")";
	}
}