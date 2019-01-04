package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Recieve_Controller implements  EventHandler<javafx.event.ActionEvent> {

	public Chess chess;

	int spalte;
	int reihe;
	
	int alteSpalte;
	int alteReihe;

	@Override
	public void handle(ActionEvent arg0) {
		this.spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		this.reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		this.alteSpalte = (int) this.chess.grid.selSpalte;
		this.alteReihe = (int) this.chess.grid.selReihe;
		

	
		if(this.chess.selectedFigure==1) {
			
			this.createNewFigure(1);
			
			this.chess.grid.feld[this.spalte][this.reihe].setOnAction(this.chess.pawn);
			this.chess.grid.add(this.chess.grid.feld[this.spalte][this.reihe], this.spalte, this.reihe);
			
			this.deleteOldFigure();
			
			this.chess.grid.deleteAllStars();
			
			this.chess.pawn.isSelected = false;
		}
		if(this.chess.selectedFigure==2) {
			
			this.createNewFigure(2);
			
			this.chess.grid.feld[this.spalte][this.reihe].setOnAction(this.chess.rook);
			this.chess.grid.add(this.chess.grid.feld[this.spalte][this.reihe], this.spalte, this.reihe);
			
			this.deleteOldFigure();
			
			this.chess.grid.deleteAllStars();
			
			this.chess.rook.isSelected = false;
		}
		
		if(this.chess.selectedFigure==3) {
			this.createNewFigure(3);
			
			this.chess.grid.feld[this.spalte][this.reihe].setOnAction(this.chess.knight);
			this.chess.grid.add(this.chess.grid.feld[this.spalte][this.reihe], this.spalte, this.reihe);
		
			this.deleteOldFigure();
			this.chess.grid.deleteAllStars();
			
			this.chess.knight.isSelected = false;
		}
		
		if(this.chess.selectedFigure==4) {
			this.createNewFigure(4);
			
			this.chess.grid.feld[this.spalte][this.reihe].setOnAction(this.chess.bishop);
			this.chess.grid.add(this.chess.grid.feld[this.spalte][this.reihe], this.spalte, this.reihe);
		
			this.deleteOldFigure();
			this.chess.grid.deleteAllStars();
			
			this.chess.bishop.isSelected = false;
		}
		
		if(this.chess.selectedFigure==5) {
			this.createNewFigure(5);
			
			this.chess.grid.feld[this.spalte][this.reihe].setOnAction(this.chess.queen);
			this.chess.grid.add(this.chess.grid.feld[this.spalte][this.reihe], this.spalte, this.reihe);
		
			this.deleteOldFigure();
			this.chess.grid.deleteAllStars();
			
			this.chess.queen.isSelected = false;
		}
		
		if(this.chess.selectedFigure==6) {
			this.createNewFigure(6);
			this.chess.grid.feld[this.spalte][this.reihe].setOnAction(this.chess.king);
			this.chess.grid.add(this.chess.grid.feld[this.spalte][this.reihe], this.spalte, this.reihe);
			
			this.deleteOldFigure();
			
			this.chess.grid.deleteAllStars();
			
			this.chess.king.isSelected = false;
		}
		
		this.chess.grid.selSpalte = null;
		this.chess.grid.selReihe = null;
	
	}
	
	public void createNewFigure(int type) {
		this.chess.grid.getChildren().remove(this.chess.grid.feld[this.spalte][this.reihe]);
		this.chess.grid.feld[this.spalte][this.reihe] = new Figure();
		
		if(this.chess.isWhitesTurn==true) {
			this.chess.grid.feld[this.spalte][this.reihe].initialise(true, type, this.spalte, this.reihe);
			this.chess.isWhitesTurn = false;
			this.chess.controls.radioButtonBlack.setSelected(true);
		}
		else {
			this.chess.grid.feld[this.spalte][this.reihe].initialise(false, type, this.spalte, this.reihe);
			this.chess.isWhitesTurn = true;
			this.chess.controls.radioButtonWhite.setSelected(true);
		}
	}
	
	public void deleteOldFigure() {
		this.chess.grid.getChildren().remove(this.chess.grid.feld[this.alteSpalte][this.alteReihe]);
		(this.chess.grid.feld[this.alteSpalte][this.alteReihe]) = new Figure();
		(this.chess.grid.feld[this.alteSpalte][this.alteReihe]).initialise(false, 0, alteSpalte, alteReihe);
		(this.chess.grid.feld[this.alteSpalte][this.alteReihe]).setOnAction(null);
		this.chess.grid.add((this.chess.grid.feld[alteSpalte][alteReihe]), alteSpalte, alteReihe);
		
	}
}
