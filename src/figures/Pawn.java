package figures;

import javafx.scene.layout.GridPane;

public class Pawn {

	public static void pawnKlicked(chess.Figure pawn) {
		int column = GridPane.getColumnIndex(pawn);
		int row = GridPane.getRowIndex(pawn);
		chess.Chess chess = pawn.getChess();
				
		
		//normale Züge
		if(chess.isWhitesTurn) {
			if(row==7) {
				if(chess.getGrid().getFigure(column, (row - 1)).getType()==0) {
					chess.getGrid().getFigure(column, (row - 1)).setSelected();
				}
				if(chess.getGrid().getFigure(column, (row - 2)).getType()==0 && chess.getGrid().getFigure(column, (row - 1)).getType()==0) {
					chess.getGrid().getFigure(column, (row - 2)).setSelected();
				}
			}
			else {
				if(2<row && row<8) { 
					if(chess.getGrid().getFigure(column, (row - 1)).getType()==0) {
						chess.getGrid().getFigure(column, (row - 1)).setSelected();
					}
				}
			}
		}
		else if (chess.isWhitesTurn==false) {
			if(row==2) {
				if(chess.getGrid().getFigure(column, (row + 1)).getType()==0) {
					chess.getGrid().getFigure(column, (row + 1)).setSelected();
				}
				if(chess.getGrid().getFigure(column, (row + 2)).getType()==0 && chess.getGrid().getFigure(column, (row + 1)).getType()==0) {
					chess.getGrid().getFigure(column, (row + 2)).setSelected();
				}
			}
			else if(1<row && row<7){
				if(chess.getGrid().getFigure(column, (row + 1)).getType()==0) {
					chess.getGrid().getFigure(column, (row + 1)).setSelected();
				}
			}
		}
		
		
		//Schlagen von gegn. Figuren
		if(chess.isWhitesTurn && 2<row && row<8) {
			if(column>1) {
				if(chess.getGrid().getFigure(column-1, row-1).isWhite()==false && chess.getGrid().getFigure(column-1, row-1).getType()!=0) {
					chess.getGrid().getFigure(column-1, row-1).setSelected();
				}
			}
			if(column<8) {
				if(chess.getGrid().getFigure(column+1, row-1).isWhite()==false && chess.getGrid().getFigure(column+1, row-1).getType()!=0) {
					chess.getGrid().getFigure(column+1, row-1).setSelected();
				}
			}
		}
		else if (chess.isWhitesTurn==false && 1<row && row<7 ) {		
			if(column>1) {
				if(chess.getGrid().getFigure(column-1, row+1).isWhite() && chess.getGrid().getFigure(column-1, row+1).getType()!=0) {
					chess.getGrid().getFigure(column-1, row+1).setSelected();
				}
			}
			if(column<8) {
				if(chess.getGrid().getFigure(column+1, row+1).isWhite() && chess.getGrid().getFigure(column+1, row+1).getType()!=0) {
					chess.getGrid().getFigure(column+1, row+1).setSelected();
				}
			}

		}
		
	
		//letzter Zug des Bauern 
		if(chess.isWhitesTurn && row==2) {
			if(chess.getGrid().getFigure(column, (row - 1)).getType()==0) {
				chess.getGrid().getFigure(column, (row - 1)).setSelected();
				chess.getGrid().getFigure(column, (row - 1)).setOnAction(chess.getPcc());
			}
			if(column>1) {
				if(chess.getGrid().getFigure(column-1, row-1).isWhite()==false && chess.getGrid().getFigure(column-1, row-1).getType()!=0) {
					chess.getGrid().getFigure(column-1, row-1).setSelected();
					chess.getGrid().getFigure(column-1, (row - 1)).setOnAction(chess.getPcc());
				}
			}
			if(column<8) {
				if(chess.getGrid().getFigure(column+1, row-1).isWhite()==false && chess.getGrid().getFigure(column+1, row-1).getType()!=0) {
					chess.getGrid().getFigure(column+1, row-1).setSelected();
					chess.getGrid().getFigure(column+1, (row - 1)).setOnAction(chess.getPcc());
				}
			}			
		}
		else if (chess.isWhitesTurn==false && row==7 ) {		
			if(chess.getGrid().getFigure(column, (row + 1)).getType()==0) {
				chess.getGrid().getFigure(column, (row + 1)).setSelected();
				chess.getGrid().getFigure(column, (row + 1)).setOnAction(chess.getPcc());
			}
			if(column>1) {
				if(chess.getGrid().getFigure(column-1, row+1).isWhite() && chess.getGrid().getFigure(column-1, row+1).getType()!=0) {
					chess.getGrid().getFigure(column-1, row+1).setSelected();
					chess.getGrid().getFigure(column-1, (row+1)).setOnAction(chess.getPcc());
				}
			}
			if(column<8) {
				if(chess.getGrid().getFigure(column+1, row+1).isWhite() && chess.getGrid().getFigure(column+1, row+1).getType()!=0) {
					chess.getGrid().getFigure(column+1, row+1).setSelected();
					chess.getGrid().getFigure(column+1, (row + 1)).setOnAction(chess.getPcc());
				}
			}
		}
		
	
		
		
	}
		
}
