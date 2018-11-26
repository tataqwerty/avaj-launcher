import aircraft.AircraftFactory;
import aircraft.vehicles.base.*;
import java.io.*;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Vector;
import java.lang.Integer;

public class Simulator {
	/* how many times weather should be changed, during the execution */
	private static int	weatherChangeCounter;

	private static void	usage() {
		System.out.println("usage : " + System.getProperty("sun.java.command") + " [scenario file]");
		System.exit(0);
	}

	private static TreeMap<String, String>			stringToToken(String s) throws Exception {
		String[]				groupNames = {"type", "name", "longitude", "latitude", "height"};
		final Pattern			regExp = Pattern.compile("^(Baloon|JetPlane|Helicopter) ([^\\s]+) (\\d+?) (\\d+?) (\\d+)$");
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
		// try {
		// 	int	longitude = Integer.parseInt(token.get("longitude"));
		// 	int	latitude = Integer.parseInt(token.get("latitude"));
		// 	int	height = Integer.parseInt(token.get("height"));

		// 	return AicraftFactory.newAircraft(token.get("type"), token.get("name"), longitude, latitude, height);
		// } catch (Exception e) {
		// 	throw new Exception("Error : invalid integer value");
		// }

		return AircraftFactory.newAircraft(token.get("type"), token.get("name"), Integer.parseInt(token.get("longitude")), Integer.parseInt(token.get("latitude")), Integer.parseInt(token.get("height")));
	}

	private static Vector<Flyable>			fileToFlyables(String fileName) throws Exception {
		FileReader				fileStream = new FileReader(fileName);
		BufferedReader			buffer = new BufferedReader(fileStream);
		Vector<Flyable>			flyables = new Vector<Flyable>();
		String					line;
		int						lineCounter = 1;
		boolean					error = false;

		if ((line = buffer.readLine()) == null)
			throw new Exception("invalid first line");

		try {
			weatherChangeCounter = Integer.parseUnsignedInt(line);
		} catch (Exception e) {
			throw new Exception("invalid first line");
		}

		while ((line = buffer.readLine()) != null)
		{
			try {
				flyables.add(tokenToFlyable(stringToToken(line)));
			} catch (Exception e) {
				error = true;
				System.out.println("Error : " + e.getMessage() + " (line " + lineCounter + " -> " + line + " )");
			}
			lineCounter++;
		}

		fileStream.close();

		if (error)
			throw new Exception(fileName + " is invalid file");

		return flyables;
	}

	public static void			main(String args[]) {
		Vector<Flyable>		flyables;
		// WeatherTower		tower;

		if (args.length == 0)
			usage();
		try {
			flyables = fileToFlyables(args[0]);

			// for(Flyable object : flyables) {
			// 	tower.register(object);
			// }

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
