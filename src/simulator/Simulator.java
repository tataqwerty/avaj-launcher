import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UsageException extends Exception {
	public String getMessage() {
		return "usage : " + System.getProperty("sun.java.command") + " [scenario file]";
	}
}

public class Simulator {



	/* how many times weather should be changed, during the execution */
	private static int	weatherChangeCounter;

	private static Token			stringToToken(String s) throws Exception {
		static finale Pattern	regExp = Pattern.compile("...");
		static Matcher			match = regExp.matcher(s);
		Token					token = null;
		int						groupsIterator = 0;

		if (match.matches())
		{
			while (groupsIterator < match.groupCount())
			{
				token[groupsIterator] = match.group(groupsIterator);
				groupsIterator++;
			}
		}
		else
		{
			throw new Exception("Undefined token");
		}

		return token;
	}

	private static Tokens[]			parseFile(String fileName) throws Exception {
		FileReader		fileStream	= new FileReader(fileName);
		BufferedReader	buffer		= new BufferedReader(fileStream);
		String			line;
		Tokens[]		tokens;
		int				tokensIterator = 0;

		// get first line, check whether it is INT ot not, and save it in weatherChangeCounter

		while ((line = buffer.readLine()) != null)
		{
			token[tokensIterator] = stringToToken(line);
			tokensIterator++;
		}

		fileStream.close();
		return tokens;
	}

	private static Flyable[]	tokensToFlyables(Token[] tokens) throws Exception {

	}

	public static void			main(String args[]) {
		Tokens[]		tokens;
		Flyable[]		flyableObjects;
		WeatherTower	tower;

		try {
			if (args.length == 0)
				throw new UsageException();

			tokens = fileToTokens(args[0]);
			flyableObjects = tokensToFlyables(tokens);

			for(Flyable object : flyableObjects) {
				tower.register(object);
			}

			while (weatherChangeCounter > 0)
			{
				// Main Logic ( one step execution )
				weatherChangeCounter--;
			}

		} catch (Exception e) {
		 	System.out.println(e.getMessage());
		}

	}
}
