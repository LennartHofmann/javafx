package figures;

import javafx.scene.layout.GridPane;

public class Pawn {

	public static void pawnKlicked(chess.Figure pawn) {
		int column = GridPane.getColumnIndex(pawn);
		int row = GridPane.getRowIndex(pawn);
		chess.Chess chess = pawn.getChess();
				
		if(chess.isWhitesTurn) {
			if(row==6) {
				if(chess.getGrid().getFigure(column, (row - 1)).getType()==0) {
					chess.getGrid().getFigure(column, (row - 1)).setSelected();
				}
				if(chess.getGrid().getFigure(column, (row - 2)).getType()==0) {
					chess.getGrid().getFigure(column, (row - 2)).setSelected();
				}
			}
			else {
				if(row>0 && row<7) { 
					if(chess.getGrid().getFigure(column, (row - 1)).getType()==0) {
						chess.getGrid().getFigure(column, (row - 1)).setSelected();
					}
				}
			}
			
		}
		

		
	}
	
	
}
