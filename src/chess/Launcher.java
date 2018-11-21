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
		
		this.chess.queen.chess = this.chess;
		this.chess.king.chess = this.chess;
		this.chess.rook.chess = this.chess;
		this.chess.bishop.chess = this.chess;
		this.chess.rc.chess = this.chess;	
		this.chess.pawn.chess = this.chess;
		this.chess.knight.chess = this.chess;
		
		this.chess.grid.chess = this.chess;
		
		this.chess.grid.initFigures();
		
		//Pferd funktioniert noch nicht vollst�ndig 
		
		stage01.setScene(new Scene(chess));
		stage01.setTitle("Chess");
		//stage01.setResizable(false);
		stage01.show();
		
		
	}

	
	
}