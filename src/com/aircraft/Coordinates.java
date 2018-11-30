package com.aircraft;

public class Coordinates {
	private int	longitude;
	private int	latitude;
	private int	height;

	Coordinates(int longitude, int latitude, int height) throws Exception {
		this.longitude = longitude;
		this.latitude = latitude;
			
		if (height > 100)
			this.height = 100;
		else if (height < 0)
			this.height = 0;
		else
			this.height = height;
	}

	public int	getLongitude() {
		return longitude;
	}

	public int	getLatitude() {
		return latitude;
	}

	public int	getHeight() {
		return height;
	}
}