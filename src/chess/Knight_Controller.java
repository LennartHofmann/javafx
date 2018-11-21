package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Knight_Controller implements EventHandler<javafx.event.ActionEvent> {

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
		
		
		if(this.chess.isWhitesTurn==this.isWhite) {
			this.chess.grid.deleteAllStars();
			this.chess.deselectOtherControllers(3);
			boolean nullSelSpalte = false;
			if (this.chess.grid.selSpalte == null) {
				nullSelSpalte = true;
			}
			if(this.isSelected==false || (nullSelSpalte==false && this.chess.grid.selSpalte!=this.spalte)) {
				this.chess.grid.selSpalte = this.spalte;
				this.chess.grid.selReihe = this.reihe;
				this.chess.selectedFigure = 3;
				
				if((this.spalte + 2)<=7) {
					if((this.reihe + 1)<=7) {
						if(this.chess.grid.getFigure((this.spalte + 2), (this.reihe + 1)).getType()==0) {
							this.initField((this.spalte + 2), (this.reihe + 1));	
						}
					}
					if((this.reihe - 1)<=7) {
						if(this.chess.grid.getFigure((this.spalte + 2), (this.reihe - 1)).getType()==0) {
							this.initField((this.spalte + 2), (this.reihe - 1));	
						}
					}
				}
				if((this.spalte + 1)<=7) {
					if((this.reihe + 2)<=7) {
						if(this.chess.grid.getFigure((this.spalte + 1), (this.reihe + 2)).getType()==0) {
							this.initField((this.spalte + 1), (this.reihe + 2));	
						}
					}
					if((this.reihe - 2)>=0) {
						if(this.chess.grid.getFigure((this.spalte + 1), (this.reihe - 2)).getType()==0) {
							System.out.println("test");
							this.initField((this.spalte + 1), (this.reihe - 2));	
						}
					}
					
				}
				if((this.spalte - 1)>=0) {
					if((this.reihe + 2)<=7) {
						if(this.chess.grid.getFigure((this.spalte - 1), (this.reihe + 2)).getType()==0) {
							this.initField((this.spalte - 1), (this.reihe + 2));	
						}
					}
					if((this.reihe - 2)>=0) {
						if(this.chess.grid.getFigure((this.spalte - 1), (this.reihe - 2)).getType()==0) {
							this.initField((this.spalte - 1), (this.reihe - 2));	
						}
					}
				}
				if((this.spalte - 2)>=0) {
					if((this.reihe + 1)<=7) {
						this.initField((this.spalte - 2), (this.reihe + 1));
					}
					if((this.reihe - 1)<=7) {
						this.initField((this.spalte - 2), (this.reihe - 1));
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
