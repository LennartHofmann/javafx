package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Pawn_Controller implements EventHandler<javafx.event.ActionEvent> {

	Chess chess;

	int spalte;
	int reihe;

	boolean isSelected = false;
	boolean isWhite;

	@Override
	public void handle(ActionEvent arg0) {
		this.spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		this.reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		this.isWhite = this.chess.grid.getFigure(spalte, reihe).isWhite();
		
		if(this.chess.isWhitesTurn==false && this.isWhite == false) {
			this.chess.grid.deleteAllStars();
			this.chess.deselectOtherControllers(1);
			boolean nullSelSpalte = false;
			if (this.chess.grid.selSpalte == null) {
				nullSelSpalte = true;
			}
			if(this.isSelected==false || (nullSelSpalte==false && this.chess.grid.selSpalte!=this.spalte)) {
				this.chess.grid.selSpalte = this.spalte;
				this.chess.grid.selReihe = this.reihe;
				this.chess.selectedFigure = 1;
				if(this.reihe==1) {
					if(this.chess.grid.getFigure(this.spalte, (this.reihe + 1)).getType()==0) {
						this.initField(this.spalte, (this.reihe + 1));
					}
					if(this.chess.grid.getFigure(this.spalte, (this.reihe + 1)).getType()==0) {
						this.initField(this.spalte, (this.reihe + 2));
					}
				}
				else {
					if(this.reihe>7) { 
						if(this.chess.grid.getFigure(this.spalte, (this.reihe + 1)).getType()==0) {
							this.initField(this.spalte, (this.reihe + 1));
						}
					}
				}
			}
			
		}
		else if (this.chess.isWhitesTurn==true && this.isWhite == true) {
			this.chess.grid.deleteAllStars();
			this.chess.deselectOtherControllers(1);
			boolean nullSelSpalte = false;
			if (this.chess.grid.selSpalte == null) {
				nullSelSpalte = true;
			}
			if(this.isSelected==false || (nullSelSpalte==false && this.chess.grid.selSpalte!=this.spalte)) {
				this.chess.grid.selSpalte = this.spalte;
				this.chess.grid.selReihe = this.reihe;
				this.chess.selectedFigure = 1;
				if(this.reihe==6) {
					if(this.chess.grid.getFigure(this.spalte, (this.reihe - 1)).getType()==0) {
						this.initField(this.spalte, (this.reihe - 1));
					}
					if(this.chess.grid.getFigure(this.spalte, (this.reihe - 2)).getType()==0) {
						this.initField(this.spalte, (this.reihe - 2));
					}
				}
				else {
					if(this.reihe>0) {
						if(this.chess.grid.getFigure(this.spalte, (this.reihe - 1)).getType()==0) {
							this.initField(this.spalte, (this.reihe - 1));
						}
					}
				}
			}
		}
		else {
			this.chess.grid.deleteAllStars();
			this.isSelected = false;
		}
		
		
		
	}

	public void initField(int spalte, int reihe) {
		this.chess.grid.getFigure(spalte, reihe).setText("*");
		this.chess.grid.getFigure(spalte, reihe).setOnAction(this.chess.rc);
	}
}
