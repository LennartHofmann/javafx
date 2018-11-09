package chess;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Layout extends GridPane{


	Figure[][] feld = new Figure[8][8];
	int spalte = 0;
	int reihe = 0;
	
	Integer selSpalte = null;
	Integer selReihe = null;
	
	public King_Controller kc = new King_Controller();
	public King_Controller kc2 = new King_Controller();
	public Recieve_Controller rc = new Recieve_Controller();
	
	
	public Figure getFigure(int spalte, int reihe) {
		ObservableList<Node> list = this.getChildren();	
		for (Node node : list) {
			if(this.getColumnIndex(node) == (spalte) && this.getRowIndex(node) == reihe) {
				return((Figure) node);
	        }	
		}
		return null;
	}
	
	void initialise() {
		for (int i = 0; i <= 7; i++) {
			for (int z = 0; z <=7; z++) {
				this.feld[i][z] = new Figure();
				
				if(((i+z) % 2)==0) {
					this.feld[i][z].setStyle("-fx-background-color: #FFFFFF; -fx-padding:0px");
				}
				else {
					this.feld[i][z].setStyle("-fx-background-color: #954D03; -fx-padding:0px");
				}
				
				this.feld[i][z].setOnAction(null);
				
				this.add(this.feld[i][z], i, z);
			}
		}
	}
	
	
}
