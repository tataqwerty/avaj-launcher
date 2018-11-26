import java.io.*;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Vector;
import java.lang.Integer;

class UsageException extends Exception {
	public String getMessage() {
		return "usage : " + System.getProperty("sun.java.command") + " [scenario file]";
	}
}

public class Simulator {
	/* how many times weather should be changed, during the execution */
	private static int	weatherChangeCounter;

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
			throw new Exception("Undefined token -> " + s);
		}

		return token;
	}

	private static Vector<TreeMap<String, String> >			fileToTokens(String fileName) throws Exception {
		FileReader							fileStream	= new FileReader(fileName);
		BufferedReader						buffer		= new BufferedReader(fileStream);
		Vector<TreeMap<String, String> >	tokens		= new Vector<TreeMap<String, String> >();
		String								line;

		if ((line = buffer.readLine()) == null)
			throw new Exception("First line not specified");

		//	check validity of the first string
		//	try ... catch need to be here, to throw my own exception
		weatherChangeCounter = Integer.parseUnsignedInt(line);

		while ((line = buffer.readLine()) != null)
		{
			tokens.add(stringToToken(line));
		}

		fileStream.close();
		return tokens;
	}

	// private static Flyable[]	tokensToFlyables(TreeMap<String, String>[] tokens) throws Exception {

	// }

	public static void			main(String args[]) {
		Vector<TreeMap<String, String> >	tokens;
		// Flyable[]							flyableObjects;
		// WeatherTower						tower;

		try {
			if (args.length == 0)
				throw new UsageException();

			tokens = fileToTokens(args[0]);

			System.out.println("weatherChangeCounter=" + weatherChangeCounter);
			for (TreeMap<String, String> token : tokens) {
				System.out.println(token.toString());
			}

			// flyableObjects = tokensToFlyables(tokens);

			// for(Flyable object : flyableObjects) {
			// 	tower.register(object);
			// }

			// while (weatherChangeCounter > 0)
			// {
			// 	// Main Logic ( one step execution )
			// 	weatherChangeCounter--;
			// }

		} catch (Exception e) {
		 	System.out.println(e.getMessage());
		}

	}
}
