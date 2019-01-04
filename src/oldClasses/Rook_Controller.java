package oldClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Rook_Controller implements  EventHandler<javafx.event.ActionEvent> {

	Chess chess;
	boolean isSelected = false;
	boolean isWhite;
	
	int spalte;
	int reihe;
	
	@Override
	public void handle(ActionEvent arg0) {
		this.spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		this.reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		this.isWhite = this.chess.grid.getFigure(this.spalte, this.reihe).isWhite();
		

		if(this.chess.isWhitesTurn==this.isWhite) {
			this.chess.grid.deleteAllStars();
			this.chess.deselectOtherControllers(2);
				
			
			boolean nullSelSpalte = false;
			if (this.chess.grid.selSpalte == null) {
				nullSelSpalte = true;
			}
			if(this.isSelected == false || (nullSelSpalte==false && this.chess.grid.selSpalte!=this.spalte)) {
								
				this.isSelected = true;
				int moglReihe = this.reihe;
				int moglSpalte = this.spalte;
				this.chess.grid.selSpalte = this.spalte;
				this.chess.grid.selReihe = this.reihe;
				this.chess.selectedFigure = 2;
				
				for (int i = 1; i<=7; i++) {
					moglReihe = this.reihe + i;
					if(moglReihe>7) {
						break;
					}
					if(this.chess.grid.getFigure(this.spalte, moglReihe).isOccupied==true) {
						break;
					}
					this.initField(this.spalte, moglReihe);
				}
				for (int i = 1; i<=7; i++) {
					moglReihe = this.reihe - i;
					if(moglReihe<0) {
						break;
					}
					if(this.chess.grid.getFigure(this.spalte, moglReihe).isOccupied==true) {
						break;
					}
					this.initField(this.spalte, moglReihe);
				}	
				for (int i = 1; i<=7; i++) {
					moglSpalte = this.spalte + i;
					if (moglSpalte >7) {
						break;
					}
					if(this.chess.grid.getFigure(moglSpalte, this.reihe).isOccupied==true) {
						break;
					}
					this.initField(moglSpalte, this.reihe);
				}	
				for (int i = 1; i<=7; i++) {
					moglSpalte = this.spalte - i;
					if (moglSpalte < 0) {
						break;
					}
					if(this.chess.grid.getFigure(moglSpalte, this.reihe).isOccupied==true) {
						break;
					}
					this.initField(moglSpalte, this.reihe);
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
