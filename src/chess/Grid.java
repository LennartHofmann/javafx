package chess;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Grid extends GridPane{

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
	
	public void deletAllStars() {
		for (int i = 0; i<=7; i++) {
			for (int z = 0; z <=7; z++) {
				if (this.getFigure(i, z).getText().equals("*")){
					(this.getFigure(i, z)).setText("");
					(this.getFigure(i, z)).setOnAction(null);
				}				
			}
		}
	}
	
}
