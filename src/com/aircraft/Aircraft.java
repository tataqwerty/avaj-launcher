package com.aircraft;

import java.util.TreeMap;

public class Aircraft {
	private static long		idCounter;
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	protected String		type;
	protected static TreeMap<String, String>	weatherMessages = new TreeMap<String, String>();
	{
		weatherMessages.put("SUN", "Let's enjoy the good weather and take some pics.\n");
		weatherMessages.put("RAIN", "It's raining. Better watch out for lightings.\n");
		weatherMessages.put("FOG", "Holy shit! I can't see anything.\n");
		weatherMessages.put("SNOW", "It's snowing. We're gonna crash.\n");
	}

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