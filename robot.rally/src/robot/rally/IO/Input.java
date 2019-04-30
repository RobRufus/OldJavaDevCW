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
	
	
	public String readActionFile(String theFileName) 
	{
		return "";	//reads a preset Action file into a string
	}
	
	
	public String readPlayerInput() 
	{
		return "";	//reads the player input from the console
	}
	
	
	
	
}


