package robot.rally.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
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
	@FXML public void donePressed() {
		
		System.out.println("buttz");
	}
	
	
	private Launcher launcher;
	
	
	// constructor
	public LauncherController() {
		
	
		
	}
	
	@FXML
    private void initialize() {}
	
	/**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Launcher launcher) {
        this.launcher = launcher;
	}

    


}


