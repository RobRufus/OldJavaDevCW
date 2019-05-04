package robot.rally.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import robot.rally.game.Player;
import robot.rally.game.Simulator;

public class Input {

	private String[] names;
	private String fileData, fileName;


	public Input()
	{
		//constructor for input class
		fileData = "filedata";
		fileName = "conveyor-loops.brd";
		
	}

	public String readFile(String fileName) throws IOException
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
	    	return contentString.toString();
	    }
	    //If the file extension is an action file call the parseActionFile function to process the action file further
	    else if(fileName.substring(fileName.length() - 4).equals(".prg"))
	    	parseAction(contentString.toString());
	   return "Invalid file";

	}

	public String[] parseAction(String actionText) throws IOException
	{
		//replace the formatting
		actionText = actionText.replace("format 1", "");
		//Separate the string on spaces and enter them into a string array
		String[] parts = actionText.split(" ");			
		//Loop through the string array and remove any extra spaces either side
		for(int i = 0; i < parts.length; i++)
		{	
			//Replace the line breaks with space
			actionText = parts[i].replace("\n", " ");
			String trimmed = parts[i].trim();
			//Replace the entries with the trimmed ones
			parts[i] = trimmed;			
			System.out.print(parts[i]);
		}
		//return parts;		
		
		actionText = actionText.replace("format 1", "");
		String[] lines = actionText.split("\n");
		
		
		
		
		return parts;
	}

	public String[] parsePlayerNames(String actionText)
	{
		actionText = actionText.replace("format 1", "");
		String[] lines = actionText.split("\n");
		String ln2 = lines[1];	
		names = ln2.split(" ");
		for(int a = 0; a < names.length; a++)
		{
			
			
		}
		
		return names;
	}
	
	public String getPlayerNames(int index)
	{
		return names[index];
	}

	public String readPlayerInput()
	{
		return "";	//reads the player input from the console
	}




}


