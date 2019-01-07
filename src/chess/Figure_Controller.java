package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Figure_Controller implements EventHandler<javafx.event.ActionEvent>{

	private Chess chess;
		
	public Figure_Controller(Chess chess) {
		this.setChess(chess);
	}
		
	@Override
	public void handle(ActionEvent event) {		
		if(event.getSource() instanceof Figure) {
			Figure actualFigure = (Figure) event.getSource();
			
			if(this.getChess().isWhitesTurn==actualFigure.isWhite() && 0<actualFigure.getType() && actualFigure.getType()<7) {
				this.chess.getGrid().resetGrid();			
				
				if(actualFigure==this.chess.getGrid().getSelectedFigure()) {
					this.chess.getGrid().setSelectedFigure(new Figure(this.chess));
				}
				else {
					this.chess.getGrid().setSelectedFigure(actualFigure);
					if(actualFigure.getType()==1) {
						figures.Pawn.pawnKlicked(actualFigure);
					}
					else if(actualFigure.getType()==2) {
						//Turm
					}
					else if(actualFigure.getType()==3) {
						//Pferd
					}
					else if(actualFigure.getType()==4) {
						//Laeufer
					}
					else if(actualFigure.getType()==5) {
						//Dame
					}
					else if(actualFigure.getType()==6) {
						//Koenig
					}
				}

			}			
		}
	}


	public Chess getChess() {
		return chess;
	}


	public void setChess(Chess chess) {
		this.chess = chess;
	}
	
	
}
