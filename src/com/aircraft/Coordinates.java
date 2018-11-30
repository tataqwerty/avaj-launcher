package com.aircraft;

public class Coordinates {
	private int	longitude;
	private int	latitude;
	private int	height;

	Coordinates(int longitude, int latitude, int height) throws Exception {
		setLongitude(longitude);
		setLatitude(latitude);
		setHeight(height);
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

	public void	setLongitude(int value) {
		longitude = value;
	}

	public void	setLatitude(int value) {
		latitude = value;
	}

	public void	setHeight(int value) {
		height = value;
		if (height > 100)
			height = 100;
		else if (height < 0)
			height = 0;
	}
}