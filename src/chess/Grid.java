package chess;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Grid extends GridPane{

	Chess chess;
	
	Figure[][] feld = new Figure[8][8];
	int spalte = 0;
	int reihe = 0;
	
	Integer selSpalte = null;
	Integer selReihe = null;
	
	void initialise() {
		for (int i = 0; i <= 7; i++) {
			for (int z = 0; z <=7; z++) {
				this.feld[i][z] = new Figure();
				
				if(((i+z) % 2)==0) {
					this.feld[i][z].setStyle("-fx-background-color: #edb99a; -fx-padding:0px");
				}
				else {
					this.feld[i][z].setStyle("-fx-background-color: #954D03; -fx-padding:0px");
				}
				
				this.feld[i][z].setOnAction(null);
				
				this.add(this.feld[i][z], i, z);
			}
		}
	}
	
	
	
	
	public Figure getFigure(int spalte, int reihe) {
		ObservableList<Node> list = this.getChildren();	
		for (Node node : list) {
			if(this.getColumnIndex(node) == (spalte) && this.getRowIndex(node) == reihe) {
				return((Figure) node);
	        }	
		}
		return null;
	}
	
	public void deleteAllStars() {
		for (int i = 0; i<=7; i++) {
			for (int z = 0; z <=7; z++) {
				if (this.getFigure(i, z).getText().equals("*")){
					(this.getFigure(i, z)).setText("");
					(this.getFigure(i, z)).setOnAction(null);
				}				
			}
		}
	}
	
	public void initFigures() {
		
		// schwarze Figuren (außer Bauern)
		for (int column = 0; column <= 7; column++) {
			this.getChildren().remove(this.feld[column][0]);
			this.feld[column][0] = new Figure();
		}
		this.feld[0][0].initialise(false, 2, 0, 0);
		this.feld[0][0].setOnAction(this.chess.rook);
		
		this.feld[1][0].initialise(false, 3, 1, 0);
		this.feld[1][0].setOnAction(this.chess.knight);
		
		this.feld[2][0].initialise(false, 4, 2, 0);
		this.feld[2][0].setOnAction(this.chess.bishop);
		
		this.feld[3][0].initialise(false, 5, 3, 0);
		this.feld[3][0].setOnAction(this.chess.queen);
		
		this.feld[4][0].initialise(false, 6, 4, 0);
		this.feld[4][0].setOnAction(this.chess.knight);
		
		this.feld[5][0].initialise(false, 4, 5, 0);
		this.feld[5][0].setOnAction(this.chess.bishop);
		
		this.feld[6][0].initialise(false, 3, 6, 0);
		this.feld[6][0].setOnAction(this.chess.knight);
		
		this.feld[7][0].initialise(false, 2, 7, 0);
		this.feld[7][0].setOnAction(this.chess.rook);
		
		for (int column = 0; column <= 7; column++) {
			this.add(this.feld[column][0], column, 0);
		}
		
		
		//schwarze Bauern
		for (int column = 0; column <= 7; column++) {
			this.getChildren().remove(this.feld[column][1]);
			this.feld[column][1] = new Figure();
			this.feld[column][1].initialise(false, 1, column, 1);
			this.feld[column][1].setOnAction(this.chess.pawn);
			this.add(this.feld[column][1], column, 1);
		}
				
		
		/*
		 * 
		 */
		
		// weisse Figuren (außer Bauern)
		for (int column = 0; column <= 7; column++) {
			this.getChildren().remove(this.feld[column][7]);
			this.feld[column][7] = new Figure();
		}
		this.feld[0][7].initialise(true, 2, 0, 7);
		this.feld[0][7].setOnAction(this.chess.rook);
		
		this.feld[1][7].initialise(true, 3, 1, 7);
		this.feld[1][7].setOnAction(this.chess.knight);
		
		this.feld[2][7].initialise(true, 4, 2, 7);
		this.feld[2][7].setOnAction(this.chess.bishop);
		
		this.feld[3][7].initialise(true, 5, 3, 7);
		this.feld[3][7].setOnAction(this.chess.queen);
		
		this.feld[4][7].initialise(true, 6, 4, 7);
		this.feld[4][7].setOnAction(this.chess.knight);
		
		this.feld[5][7].initialise(true, 4, 5, 7);
		this.feld[5][7].setOnAction(this.chess.bishop);
		
		this.feld[6][7].initialise(true, 3, 6, 7);
		this.feld[6][7].setOnAction(this.chess.knight);
		
		this.feld[7][7].initialise(true, 2, 7, 7);
		this.feld[7][7].setOnAction(this.chess.rook);
		
		for (int column = 0; column <= 7; column++) {
			this.add(this.feld[column][7], column, 7);
		}
		
		
		//weisse Bauern
		for (int column = 0; column <= 7; column++) {
			this.getChildren().remove(this.feld[column][6]);
			this.feld[column][6] = new Figure();
			this.feld[column][6].initialise(true, 1, column, 6);
			this.feld[column][6].setOnAction(this.chess.pawn);
			this.add(this.feld[column][6], column, 6);
		}

	}
	

	
}
