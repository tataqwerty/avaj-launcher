package com.simulator;

import java.io.FileWriter;

public class Logger
{
	private static FileWriter	outFile = null;

	public static void	write(String s) throws Exception
	{
		if (outFile == null)
			outFile = new FileWriter("simulation.txt");
		outFile.write(s);
	}

	public static void	close() throws Exception
	{
		if (outFile != null)
			outFile.close();
	}
}