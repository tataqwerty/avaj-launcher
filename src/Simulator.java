import aircraft.AircraftFactory;
import aircraft.vehicles.base.*;
import java.io.*;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Vector;
import java.lang.Integer;
import weather.WeatherTower;

public class Simulator {
	/* how many times weather should be changed, during the execution */
	private static int	weatherChangeCounter;

	private static void	usage() {
		System.out.println("usage : " + System.getProperty("sun.java.command") + " [scenario file]");
		System.exit(0);
	}

	private static TreeMap<String, String>			stringToToken(String s) throws Exception {
		String[]				groupNames = {"type", "name", "longitude", "latitude", "height"};
		final Pattern			regExp = Pattern.compile("^([^\\s]+) ([^\\s]+) (\\d+?) (\\d+?) (\\d+)$");
		Matcher					match = regExp.matcher(s);
		TreeMap<String, String>	token = null;
		int						groupsIterator = 0;

		if (match.matches())
		{
			token = new TreeMap<String, String>();
			while (groupsIterator < match.groupCount())
			{
				token.put(groupNames[groupsIterator], match.group(groupsIterator + 1)); // + 1, because groups start from 1, not 0
				groupsIterator++;
			}
		}
		else
		{
			throw new Exception("Undefined token");
		}

		return token;
	}

	private static Flyable					tokenToFlyable(TreeMap<String, String> token) throws Exception {
		int	longitude;
		int	latitude;
		int	height;

		try {
			longitude = Integer.parseInt(token.get("longitude"));
			latitude = Integer.parseInt(token.get("latitude"));
			height = Integer.parseInt(token.get("height"));
		} catch (Exception e) {
			throw new Exception("Invalid integer value");
		}

		return AircraftFactory.newAircraft(token.get("type"), token.get("name"), longitude, latitude, height);
	}

	private static Vector<Flyable>			fileToFlyables(String fileName) throws Exception {
		FileReader				fileStream = new FileReader(fileName);
		BufferedReader			buffer = new BufferedReader(fileStream);
		Vector<Flyable>			flyables = new Vector<Flyable>();
		String					line;
		int						lineCounter = 1;
		boolean					error = false;

		if ((line = buffer.readLine()) == null)
			throw new Exception("Invalid first line");

		try {
			weatherChangeCounter = Integer.parseUnsignedInt(line);
		} catch (Exception e) {
			throw new Exception("Invalid first line");
		}

		while ((line = buffer.readLine()) != null)
		{
			lineCounter++;

			try {
				flyables.add(tokenToFlyable(stringToToken(line)));
			} catch (Exception e) {
				error = true;
				System.out.println("Error : " + e.getMessage() + " (line " + lineCounter + " -> " + line + " )");
			}
		}

		fileStream.close();

		if (error)
			throw new Exception(fileName + " is invalid file");

		return flyables;
	}

	public static void			main(String args[]) {
		Vector<Flyable>		flyables;
		WeatherTower		tower;

		if (args.length == 0)
			usage();
		try {
			flyables = fileToFlyables(args[0]);

			for(Flyable object : flyables) {
				object.registerTower(tower);
			}

			// while (weatherChangeCounter > 0)
			// {
			// 	// Main Logic ( one step execution )
			// 	weatherChangeCounter--;
			// }
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}

	}
}
