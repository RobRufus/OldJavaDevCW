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
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import robot.rally.game.*;

public class LauncherController {
	
	private File boardFile;
	private File actionFile;
	
	@FXML public void chooseFilePressed() {
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		String fileName = selectedFile.getName();
		
		
		
		if (selectedFile != null) 
		{
			System.out.println("File selected: " + selectedFile.getPath());
			if(fileName.substring(fileName.length()- 4).equals(".brd"))
		    {
				boardFile = selectedFile;
				boardFileLabel.setText("Board file set to:" + fileName);
		    }
			else if(fileName.substring(fileName.length() - 4).equals(".prg")) {
				actionFile = selectedFile;
				actionFileLabel.setText("Action file set to:" + fileName);
			}
			else {
				System.out.println("File invalid");
			}
		}
		else
		{
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
	@FXML private Label actionFileLabel;
	
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


