package robot.rally.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Input {


	private String fileData, fileName;


	public Input()
	{
		//constructor for input class
		fileData = "filedata";
		fileName = "conveyor-loops.brd";
	}

	/*
	public String readBoardFile(String theFileName)
	{

		//for each line read that line into a string with a line break character
		StringBuilder contentString = new StringBuilder();

		//read in each line
	    try (Stream<String> fileStream = Files.lines( Paths.get(theFileName), StandardCharsets.UTF_8))
	    {
	        fileStream.forEach(i -> contentString.append(i).append("\n")); 		//separate the string with line break characters
	    }
	    catch (IOException prntException)										//print exception when error occours
	    {
	    	prntException.printStackTrace();
	    }

	    //return file content string
	    return contentString.toString();

	}
	*/

	public String readFile(String fileName)
	{
		//for each line read that line into a string with a line break character
		StringBuilder contentString = new StringBuilder();
		//temporary player counter variable
		int playerCount = 0;
		//read in each line
	    try (Stream<String> fileStream = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8))
	    {
	        fileStream.forEach(i -> contentString.append(i).append("\n")); 		//separate the string with line break characters
	    }
	    catch (IOException prntException)										//print exception when error occurs
	    {
	    	prntException.printStackTrace();
	    }
	    //If the file extension is a board file return the processed file as a string
	    if(fileName.substring(fileName.length()- 4).equals(".brd"))
	    {
	    	/*
	    	for (int i = 0; i < contentString.toString().length(); i++)
	    	{
	    		if (contentString.toString().charAt(i) == )
	    		{

	    		}
	    	}
	    	*/
	    	System.out.println(contentString.toString());
	    	return contentString.toString();
	    }
	    //If the file extension is an action file call the parseActionFile function to process the action file further
	    else if(fileName.substring(fileName.length() - 4).equals(".prg"))
	    	parseActionFile(contentString.toString());
	   return "fail";

	}

	public void parseActionFile(String actionText)
	{
		//Replace the line breaks with space
		actionText = actionText.replace("\n", " ");
		//Separate the string on spaces and enter them into a string array
		String[] parts = actionText.split(" ");
		//Loop through the string array and remove any extra spaces either side
		for(int i = 0; i < parts.length; i++)
		{
			String trimmed = parts[i].trim();
			//Replace the entries with the trimmed ones
			parts[i] = trimmed;
			//System.out.println(parts[i]);
		}
	}


	public String readPlayerInput()
	{
		return "";	//reads the player input from the console
	}




}


