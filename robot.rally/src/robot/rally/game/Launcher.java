package robot.rally.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import robot.rally.view.LauncherController;

public class Launcher extends Application {
	
	int numOfPlayers;
	int gameType;
	String playerNames[];
	String actionFileName;
	String boardFileName;
	
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
	
	
	public Launcher() 
	{
		//constructor for launcher class
	}
	
	
	public void buildSim()
	{
		/* function which allows user to change settings and uses them
		to build a simulator class*/
		
	}
	
	

}
