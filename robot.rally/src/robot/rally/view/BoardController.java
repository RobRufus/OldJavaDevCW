package robot.rally.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import robot.rally.game.Launcher;
import robot.rally.model.Board;

public class BoardController {
	
	
	
	@FXML public void ForwardsPressed() {
		
		System.out.println("buttz");
		}
	public BoardController() {}
	


	@FXML
    private GridPane grid = new GridPane();
	
	
	@FXML 
	private void initialize() {
		
		
	}
	
	public void displayBoard(Stage primaryStage, Board board) throws Exception {
		
		int boardHeight = board.getBoardHeight();
		int boardLength = board.getBoardLength();
		
		for (int i = 0; i<boardHeight; i++) {
		
			for (int i= )
			FileInputStream inputstream = new FileInputStream("C:/cscw/coursework/GameArt/A.png"); 
			Image image = new Image(inputstream);

			ImageView imageView = new ImageView();
		
			imageView.setImage(image);
		

			grid.add(imageView, 1, 0); // column=1 row=0
		}
		
		//Image image = new Image("C:/cscw/coursework/GameArt/A.png");
		//grid.getChildren().add(imageView);
		//System.out.println("buttz");
		
		Scene scene = new Scene(grid);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
    
}
