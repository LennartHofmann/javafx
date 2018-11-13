package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Recieve_Controller implements  EventHandler<javafx.event.ActionEvent> {

	public Chess chess;

	

	@Override
	public void handle(ActionEvent arg0) {
		int spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		int reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		
/*
		if() {
			
		}
*/		
		
		
		
		
		if(this.chess.selectedFigure==6) {
			this.chess.grid.getChildren().remove(this.chess.grid.feld[spalte][reihe]);
			this.chess.grid.feld[spalte][reihe] = new Figure();
			
			if(this.chess.isWhitesTurn==true) {
				this.chess.grid.feld[spalte][reihe].initialise(true, 6, spalte, reihe);
				this.chess.isWhitesTurn = false;
				this.chess.controls.radioButtonBlack.setSelected(true);
			}
			else {
				this.chess.grid.feld[spalte][reihe].initialise(false, 6, spalte, reihe);
				this.chess.isWhitesTurn = true;
				this.chess.controls.radioButtonWhite.setSelected(true);
			}

			this.chess.grid.feld[spalte][reihe].setOnAction(this.chess.kc);
			this.chess.grid.add(this.chess.grid.feld[spalte][reihe], spalte, reihe);
			
			this.chess.grid.getChildren().remove(this.chess.grid.feld[(int) this.chess.grid.selSpalte][(int) this.chess.grid.selReihe]);
			(this.chess.grid.feld[(int) this.chess.grid.selSpalte][(int) this.chess.grid.selReihe]) = new Figure();
			(this.chess.grid.feld[(int) this.chess.grid.selSpalte][(int) this.chess.grid.selReihe]).initialise(false, 0, ((int) this.chess.grid.selSpalte), ((int) this.chess.grid.selReihe));
			(this.chess.grid.feld[(int) this.chess.grid.selSpalte][(int) this.chess.grid.selReihe]).setOnAction(null);
			this.chess.grid.add((this.chess.grid.feld[(int) this.chess.grid.selSpalte][(int) this.chess.grid.selReihe]), ((int) this.chess.grid.selSpalte), ((int) this.chess.grid.selReihe));
			
			this.chess.grid.deletAllStars();
			
			this.chess.kc.isSelected = false;
			this.chess.grid.selSpalte = null;
			this.chess.grid.selReihe = null;
		}
		
		

		
		
		
		
		
	
	}
}
