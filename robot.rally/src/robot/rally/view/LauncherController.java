package robot.rally.view;


import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import robot.rally.game.*;

public class LauncherController {
	
	@FXML public void chooseFilePressed() {
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		 
		if (selectedFile != null) {
		 
		    System.out.println("File selected: " + selectedFile.getPath());
		}
		else {
			System.out.println("File selection cancelled.");
		}
	}
	@FXML public void donePressed(ActionEvent event) throws IOException{
		Parent boardViewParent = FXMLLoader.load(getClass().getResource("../view/Board.fxml"));
		Scene boardView = new Scene(boardViewParent);
		
		//gets stage info
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		primaryStage.setScene(boardView);
		primaryStage.show();
	}
	@FXML private Label boardFileLabel;
	@FXML private Label actionsFileLabel;
	
	private Launcher launcher;
	
	
	// constructor
	public LauncherController() {
		
	
		
	}
	
	@FXML
    private void initialize() {}
	
	/**
     * Is called by the main application to give a reference back to itself.
     * 
     * 
     */
    public void setMainApp(Launcher launcher) {
        this.launcher = launcher;
	}

    


}


