package robot.rally.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import robot.rally.game.Launcher;

public class BoardController {
	
	
	
@FXML public void ForwardsPressed() {
		
		System.out.println("buttz");
	}
	public BoardController() {}
	


	@FXML GridPane gridPane;
	
	
	@FXML
    private void initialize() {
		
		
	}
	
	public void displayBoard() throws Exception {
        
		FileInputStream inputstream = new FileInputStream("C:/cscw/coursework/GameArt/A.png"); 
		Image image = new Image(inputstream);
		
		ImageView imageView = new ImageView();
		
		imageView.setImage(image);
		
		//Image image = new Image("C:/cscw/coursework/GameArt/A.png");
        //System.out.println(image);
        //
        //System.out.println(imageView);
		//ImageView image = new ImageView();
		//image.setImage("C:/cscw/coursework/GameArt/A.png");
        //final HBox pictureRegion = new HBox();
       //pictureRegion.getChildren().add(imageView);
        
        //gridPane.add(pictureRegion, 0, 0);
		
		//Image image = new Image("C:/cscw/coursework/GameArt/A.png");
		gridPane.getChildren().add(imageView);
		//System.out.println("buttz");
		
		
	}
    
}
