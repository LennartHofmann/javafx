package chess;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Grid extends GridPane{

	Chess chess;
	
	Figure_2_0[][] feld = new Figure_2_0[8][8];
	int spalte = 0;
	int reihe = 0;
	
	private Font textSize = new Font(55);
	
	
	Integer selSpalte = null;
	Integer selReihe = null;
	
	
	
	void initialise() {
		for (int i = 0; i <= 7; i++) {
			for (int z = 0; z <=7; z++) {
				this.feld[i][z] = new Figure_2_0(this);
				
				if(((i+z) % 2)==0) {
					this.feld[i][z].setStyle("-fx-background-color: #edb99a; -fx-padding:0px");
				}
				else {
					this.feld[i][z].setStyle("-fx-background-color: #954D03; -fx-padding:0px");
				}
							
				this.add(this.feld[i][z], i, z);
			}
		}
	}
	
	
	
	/*
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
	*/
	
	
	public void initFigures() {
		// schwarze Figuren (außer Bauern)
		for (int column = 0; column <= 7; column++) {
			this.feld[column][0].setWhite(false);
		}
		this.feld[0][0].setType(2);
		this.feld[1][0].setType(3);
		this.feld[2][0].setType(4);
		this.feld[3][0].setType(5);
		this.feld[4][0].setType(6);
		this.feld[5][0].setType(4);
		this.feld[6][0].setType(3);
		this.feld[7][0].setType(2);
		// schwarze Bauern
		for (int column = 0; column <= 7; column++) {
			this.feld[column][1].setWhite(false);
			this.feld[column][1].setType(1);
		}
				
		
		// weisse Figuren (außer Bauern)
		for (int column = 0; column <= 7; column++) {
			this.feld[column][7].setWhite(true);
		}
		this.feld[0][7].setType(2);
		this.feld[1][7].setType(3);
		this.feld[2][7].setType(4);
		this.feld[3][7].setType(5);
		this.feld[4][7].setType(6);
		this.feld[5][7].setType(4);
		this.feld[6][7].setType(3);
		this.feld[7][7].setType(2);
		
		
		//weisse Bauern
		for (int column = 0; column <= 7; column++) {
			this.feld[column][6].setWhite(true);
			this.feld[column][6].setType(1);
		}

	}




	public Font getTextSize() {
		return textSize;
	}




	public void setTextSize(Font textSize) {
		this.textSize = textSize;
	}
	

	
}
