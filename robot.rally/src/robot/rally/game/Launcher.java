package robot.rally.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import robot.rally.IO.Input;
import robot.rally.view.LauncherController;

public class Launcher extends Application {
	
	int numOfPlayers;
	int gameType;
	String playerNames[];
	String actionFilePath;
	String boardFilePath;
	Input input;
	Simulator simulator;
	
	public static void main(String[] args){
		System.out.println("Hello World");
		launch(args);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LauncherView.fxml"));
		loader.setController(new LauncherController());;
		final Parent root = loader.load();
		final Scene scene = new Scene(root, 400, 300);
		primaryStage.setTitle("RoboRally launcher");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	public Launcher(String brdFilePath, String actFilePath) 
	{
		//constructor for launcher class
		boardFilePath = brdFilePath;
		actionFilePath = actFilePath;
		Input input = new Input();
		Simulator simulator = new Simulator();
		simulator.generateBoard(input.readFile(boardFilePath));
		input.readFile(actionFilePath);		
	}
	
	
	public void buildSim()
	{
		/* function which allows user to change settings and uses them
		to build a simulator class*/
		
	}
	
	

}
