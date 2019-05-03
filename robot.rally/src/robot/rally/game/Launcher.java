package robot.rally.game;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import robot.rally.IO.Input;
import robot.rally.view.LauncherController;
import javafx.scene.layout.AnchorPane;

/**
 * This is the class that parses the {@link Board} file and {@link Action} file to the {@link Simulator}.
 * It also initialises the GUI used by the game.
 * Does not use a Contructor because it is GUI based.
 * 
 * @author Team18.
 *
 */


public class Launcher extends Application {
	
	int numOfPlayers;
	int gameType;
	String playerNames[];
	String actionFilePath;
	String boardFilePath;
	Input input;
	Simulator simulator;
    private Stage primaryStage;
    private BorderPane rootLayout;
    Scene launcherScene, boardScene;
    
    
    @Override
    
    /**
     * Initialises the given Stage to hold the Scene displaying the {@link Board} itself.
     * 
     * @param primaryStage
     */
    
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RoboRally launcher");

        initRootLayout();
        
        showLauncher();
    }
    
    /**
     * This method load's the root layout from the RootLayout.fxml file and establishes the launcher scene. 
     */
    
public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Launcher.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            launcherScene = new Scene(rootLayout);
            primaryStage.setScene(launcherScene);
            primaryStage.show();
            
            //board setup
            //boardScene = new Scene(rootLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

public void showLauncher() {
    try {
        // Load launcher screen.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Launcher.class.getResource("../view/LauncherView.fxml"));
        AnchorPane launcher = (AnchorPane) loader.load();
        
        // Set launcher into the centre of root layout.
        rootLayout.setCenter(launcher);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void showBoard() {
	
	
}



public Stage getPrimaryStage() {
	return primaryStage;
	
}


public static void main(String[] args){
		System.out.println("Hello World");
		launch(args);	
	}
	

/*public void showLauncherButtons() {
    try {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Launcher.class.getResource("../view/LauncherView.fxml"));
        AnchorPane overview = (AnchorPane) loader.load();
        
        // Set overview into the centre of root layout.
        rootLayout.setCenter(overview);

        // Give the controller access to the main app.
        LauncherController controller = loader.getController();
        controller.setMainApp(this);

    } catch (IOException e) {
        e.printStackTrace();
    }
}*/

//	@Override
//	public void start(Stage primaryStage) throws Exception{
//		
//		final FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("LauncherView.fxml"));
//		loader.setController(new LauncherController());;
//		final Parent root = loader.load();
//		final Scene scene = new Scene(root, 400, 300);
//		this.primaryStage.setTitle("RoboRally launcher");
//		this.primaryStage.setScene(scene);
//		this.primaryStage.show();
//		
//	}
	
	
//	public Launcher(String brdFilePath, String actFilePath) 
//	{
//		//constructor for launcher class
//		boardFilePath = brdFilePath;
//		actionFilePath = actFilePath;
//		Input input = new Input();
//		Simulator simulator = new Simulator();
//		simulator.generateBoard(input.readFile(boardFilePath));
//		input.readFile(actionFilePath);		
//	}
	
	
//	public void buildSim()
//	{
//		/* function which allows user to change settings and uses them
//		to build a simulator class*/
//		
//	}
	
	

}
