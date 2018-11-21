package chess;

import com.sun.glass.events.MouseEvent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class Queen_Controller implements  EventHandler<javafx.event.ActionEvent> {

	Chess chess;
	
	int spalte;
	int reihe;
	
	boolean isSelected = false;
	boolean isWhite;
	
	
	@Override
	public void handle(ActionEvent arg0) {
		this.spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		this.reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		this.isWhite = this.chess.grid.getFigure(this.spalte, this.reihe).isWhite();
		
		if(this.chess.isWhitesTurn==this.isWhite) {
			this.chess.grid.deleteAllStars();
			this.chess.deselectOtherControllers(5);
			
			boolean nullSelSpalte = false;
			if (this.chess.grid.selSpalte == null) {
				nullSelSpalte = true;
			}
			
			if(this.isSelected==false || (nullSelSpalte==false && (this.chess.grid.selSpalte!=this.spalte))) {
				this.isSelected = true;
				int moglReihe = this.reihe;
				int moglSpalte = this.spalte;
				this.chess.grid.selSpalte = this.spalte;
				this.chess.grid.selReihe = this.reihe;
				this.chess.selectedFigure = 5;

				boolean OccupiedDiagonale[] = new boolean[4];
				for (int i = 0; i<OccupiedDiagonale.length; i++) {
					OccupiedDiagonale[i] = false;
				}
				for (int i=1; i<=7; i++) {
					if (this.spalte - i >= 0) {
						if (reihe - i >= 0) {
							if(this.chess.grid.getFigure((this.spalte - i), (this.reihe - i)).isOccupied==false && (OccupiedDiagonale[0]==false)) {
								this.initField((this.spalte - i), (this.reihe - i));
							}
							else {
								OccupiedDiagonale[0] = true;
							}
						}
						if (this.reihe + i <= 7) {
							if(this.chess.grid.getFigure((this.spalte - i), (this.reihe + i)).isOccupied==false && (OccupiedDiagonale[1]==false)) {
								this.initField((this.spalte - i), (this.reihe + i));
							}
							else {
								OccupiedDiagonale[1] = true;
							}
						}
					}
					if (this.spalte + i <=7) {
						if (this.reihe - i >= 0) {
							if(this.chess.grid.getFigure((this.spalte + i), (this.reihe - i)).isOccupied==false && (OccupiedDiagonale[2]==false)) {
								this.initField((this.spalte + i), (this.reihe - i));
							}
							else {
								OccupiedDiagonale[2] = true;
							}
						}
						if (this.reihe + i <= 7) {
							if(this.chess.grid.getFigure((this.spalte + i), (this.reihe + i)).isOccupied==false && (OccupiedDiagonale[3]==false)) {
								this.initField((this.spalte + i), (this.reihe + i));
							}
							else {
								OccupiedDiagonale[3] = true;
							}
						}
					}
				}
				
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
