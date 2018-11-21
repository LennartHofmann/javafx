package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Bishop_Controller implements  EventHandler<javafx.event.ActionEvent> {

	Chess chess;
	boolean isSelected = false;
	boolean isWhite;
	
	@Override
	public void handle(ActionEvent arg0) {
		int spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		int reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		this.isWhite = this.chess.grid.getFigure(spalte, reihe).isWhite();
		
		if(this.chess.isWhitesTurn==this.isWhite) {
			this.chess.grid.deleteAllStars();
			this.chess.deselectOtherControllers(4);
			
			boolean nullSelSpalte = false;
			if (this.chess.grid.selSpalte == null) {
				nullSelSpalte = true;
			}
			if(this.isSelected==false || (nullSelSpalte==false && this.chess.grid.selSpalte!=spalte)) {
				this.isSelected = true;
				this.chess.grid.selSpalte = spalte;
				this.chess.grid.selReihe = reihe;
				this.chess.selectedFigure = 4;

				boolean OccupiedDiagonale[] = new boolean[4];
				for (int i = 0; i<OccupiedDiagonale.length; i++) {
					OccupiedDiagonale[i] = false;
				}
				for (int i=1; i<=7; i++) {
					if (spalte - i >= 0) {
						if (reihe - i >= 0) {
							if(this.chess.grid.getFigure((spalte - i), (reihe - i)).isOccupied==false && (OccupiedDiagonale[0]==false)) {
								this.initField((spalte - i), (reihe - i));
							}
							else {
								OccupiedDiagonale[0] = true;
							}
						}
						if (reihe + i <= 7) {
							if(this.chess.grid.getFigure((spalte - i), (reihe + i)).isOccupied==false && (OccupiedDiagonale[1]==false)) {
								this.initField((spalte - i), (reihe + i));
							}
							else {
								OccupiedDiagonale[1] = true;
							}
						}
					}
					if (spalte + i <=7) {
						if (reihe - i >= 0) {
							if(this.chess.grid.getFigure((spalte + i), (reihe - i)).isOccupied==false && (OccupiedDiagonale[2]==false)) {
								this.initField((spalte + i), (reihe - i));
							}
							else {
								OccupiedDiagonale[2] = true;
							}
						}
						if (reihe + i <= 7) {
							if(this.chess.grid.getFigure((spalte + i), (reihe + i)).isOccupied==false && (OccupiedDiagonale[3]==false)) {
								this.initField((spalte + i), (reihe + i));
							}
							else {
								OccupiedDiagonale[3] = true;
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
		
	}
	
	public void initField(int spalte, int reihe) {
		this.chess.grid.getFigure(spalte, reihe).setText("*");
		this.chess.grid.getFigure(spalte, reihe).setOnAction(this.chess.rc);
	}

}
