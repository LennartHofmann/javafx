package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Rook_Controller implements  EventHandler<javafx.event.ActionEvent> {

	Chess chess;
	boolean isSelected = false;
	boolean isWhite;
	
	@Override
	public void handle(ActionEvent arg0) {
		int spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		int reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		
		this.isWhite = this.chess.grid.getFigure(spalte, reihe).isWhite();
		
		this.chess.grid.deletAllStars();
		
		if(this.chess.isWhitesTurn==this.isWhite) {
			if(this.isSelected == false) {
				this.isSelected = true;
				int moglReihe = reihe;
				int moglSpalte = spalte;
				this.chess.grid.selSpalte = spalte;
				this.chess.grid.selReihe = reihe;
				
				for (int i = 1; i<=7; i++) {
					moglReihe = reihe + i;
					if(moglReihe>7) {
						break;
					}
					if(this.chess.grid.getFigure(spalte, moglReihe).isOccupied==true) {
						break;
					}
					this.initFields(spalte, moglReihe);
				}
				for (int i = 1; i<=7; i++) {
					moglReihe = reihe - i;
					if(moglReihe<0) {
						break;
					}
					if(this.chess.grid.getFigure(spalte, moglReihe).isOccupied==true) {
						break;
					}
					this.initFields(spalte, moglReihe);
				}	
				for (int i = 1; i<=7; i++) {
					moglSpalte = spalte + i;
					if (moglSpalte >7) {
						break;
					}
					if(this.chess.grid.getFigure(moglSpalte, reihe).isOccupied==true) {
						break;
					}
					this.initFields(moglSpalte, reihe);
				}	
				for (int i = 1; i<=7; i++) {
					moglSpalte = spalte - i;
					if (moglSpalte < 0) {
						break;
					}
					if(this.chess.grid.getFigure(moglSpalte, reihe).isOccupied==true) {
						break;
					}
					this.initFields(moglSpalte, reihe);
				}
			}
			else {
				this.chess.grid.deletAllStars();
				this.isSelected = false;
			}
		
		}
		
	}
	
	
	public void initFields(int spalte, int reihe) {
		this.chess.grid.getFigure(spalte, reihe).setText("*");
		this.chess.grid.getFigure(spalte, reihe).setOnAction(this.chess.rc);
	}
	
	
	
}
