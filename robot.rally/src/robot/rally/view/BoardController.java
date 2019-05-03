package robot.rally.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import robot.rally.model.Direction;
import robot.rally.model.Rotation;

public class BoardController {
	private Image image;
	private ImageView imageView;
	private FileInputStream inputstream;
	
	
	public BoardController() {}
	


	@FXML
    private GridPane grid = new GridPane();
	
	
	@FXML 
	private void initialize() throws Exception {
		
		
		Board tempboard = new Board(2,2);
		
		BoardController boardController = new BoardController();
		
		robot.rally.IO.Input inputString = new robot.rally.IO.Input();
		
		String boardData = inputString.readFile("C:/cscw/coursework/boards/test2x2.brd");
		
		boardController.displayBoard(tempboard, boardData);
		
		
	}
	
	public void displayBoard(Board board, String boardData) throws Exception {
		
		int boardHeight = board.getBoardHeight();
		int boardLength = board.getBoardLength();
		
		for (int x = 0; x<boardHeight; x++) {
		
			for (int y=0; y<boardLength; y++ ) {
				if (board.getLocation(x, y).get(1) != null) {
					inputstream = new FileInputStream("C:/cscw/coursework/GameArt/Robot.png"); 
					Image image = new Image(inputstream);

					imageView = new ImageView();
			
					imageView.setImage(image); 
				}
				switch (boardData.charAt(y)) 
				{
				case '1':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/Flag.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
					break;
				case '2':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/Flag.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
					break;
				case '3':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/Flag.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
            		break;
				case '4':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/Flag.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
            		break;
				case '+':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/ClockwiseGear.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
            		break;
				case '-':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/CounterClockwiseGear.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
            		break;
				case 'x':  
            		break;
				case 'A':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/A.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
            		break;
				case 'B':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/B.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
            		break;
				case 'C':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/C.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
            		break;
				case 'D':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/D.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				
				y++;
        			break;
				case '<':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/WestConveyor.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
				
        			break;
				case '>':  inputstream = new FileInputStream("C:/cscw/coursework/GameArt/EastConveyor.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
				
        			break;
				case '^':  new FileInputStream("C:/cscw/coursework/GameArt/NorthConveyor.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
        			break;
				case 'v':  new FileInputStream("C:/cscw/coursework/GameArt/SouthConveyor.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
					break;
				default :  new FileInputStream("C:/cscw/coursework/GameArt/blankspace.png"); 
				image = new Image(inputstream);

				imageView = new ImageView();
		
				imageView.setImage(image);
		

				grid.add(imageView, x, y); // column row
				y++;
				
				}
			}
		}
		
		
	}
    
}
