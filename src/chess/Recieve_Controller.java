package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class Recieve_Controller implements  EventHandler<javafx.event.ActionEvent> {

	public Layout grid;

	@Override
	public void handle(ActionEvent arg0) {
		int spalte = Layout.getColumnIndex((Node) arg0.getTarget());
		int reihe = Layout.getRowIndex((Node) arg0.getTarget());
		

		if(this.grid.kc.isSelected==true) {
			this.grid.getChildren().remove(this.grid.feld[spalte][reihe]);
			this.grid.feld[spalte][reihe] = new Figure();
			this.grid.feld[spalte][reihe].initialise(false, 6, spalte, reihe);
			this.grid.feld[spalte][reihe].setOnAction(this.grid.kc);
			this.grid.add(this.grid.feld[spalte][reihe], spalte, reihe);
			
			this.grid.getChildren().remove(this.grid.feld[(int) this.grid.selSpalte][(int) this.grid.selReihe]);
			(this.grid.feld[(int) this.grid.selSpalte][(int) this.grid.selReihe]) = new Figure();
			(this.grid.feld[(int) this.grid.selSpalte][(int) this.grid.selReihe]).initialise(false, 0, ((int) this.grid.selSpalte), ((int) this.grid.selReihe));
			(this.grid.feld[(int) this.grid.selSpalte][(int) this.grid.selReihe]).setOnAction(null);
			this.grid.add((this.grid.feld[(int) this.grid.selSpalte][(int) this.grid.selReihe]), ((int) this.grid.selSpalte), ((int) this.grid.selReihe));
		}
		
		
		for (int i = 0; i<=7; i++) {			
			for (int z = 0; z<=7; z++) {
					if(spalte==i && reihe==z) {
						
					}
					else if ((this.grid.getFigure(i, z)).getText().equals("*")) {
						(this.grid.getFigure(i, z)).setText("");
						(this.grid.getFigure(i, z)).setOnAction(null);
					}
					else if (this.grid.selSpalte==i && this.grid.selSpalte==z ) {
						/*
						this.grid.getChildren().remove(this.grid.feld[i][z]);
						this.grid.feld[i][z] = new Figure();
						this.grid.feld[i][z].initialise(false, 0, i, z);
						this.grid.feld[i][z].setOnAction(null);
						this.grid.add(this.grid.feld[i][z], i, z);
						*/
					}
				}
			}			
		this.grid.kc.isSelected = false;
	}
	
	
}
