package chess;


import javafx.scene.shape.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Launcher extends Application{

	Chess chess;

	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage01) throws Exception {
		this.chess = new Chess();
		
		this.chess.kc.chess = this.chess;
		this.chess.rook.chess = this.chess;
		this.chess.rc.chess = this.chess;
				
		
		//König setzen
		this.chess.grid.getChildren().remove(this.chess.grid.feld[3][4]);
		this.chess.grid.feld[3][4] = new Figure();
		this.chess.grid.feld[3][4].initialise(false, 6, 3, 4);
		this.chess.grid.feld[3][4].setOnAction(this.chess.kc);
		this.chess.grid.add(this.chess.grid.feld[3][4], 3, 4);
		
		//2. König setzen
		this.chess.grid.getChildren().remove(this.chess.grid.feld[6][6]);
		this.chess.grid.feld[6][6] = new Figure();
		this.chess.grid.feld[6][6].initialise(true, 6, 6, 6);
		this.chess.grid.feld[6][6].setOnAction(this.chess.kc);
		this.chess.grid.add(this.chess.grid.feld[6][6], 6, 6);
		
		
		//Turm setzten
		this.chess.grid.getChildren().remove(this.chess.grid.feld[3][3]);
		this.chess.grid.feld[3][3] = new Figure();
		this.chess.grid.feld[3][3].initialise(true, 2, 3, 3);
		this.chess.grid.feld[3][3].setOnAction(this.chess.rook);
		this.chess.grid.add(this.chess.grid.feld[3][3], 3, 3);
		

	
		
		stage01.setScene(new Scene(chess));
		stage01.setTitle("Chess");
		stage01.show();
		
		
	}

	
	
}
