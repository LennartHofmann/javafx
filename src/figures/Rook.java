package figures;

import javafx.scene.layout.GridPane;

public class Rook {

	
	public static void rookKlicked(chess.Figure rook) {
		int column = GridPane.getColumnIndex(rook);
		int row = GridPane.getRowIndex(rook);
		chess.Chess chess = rook.getChess();
		
		
		//Spalten durchlaufen
		int posColumn = 0;
		for (int i = 1; i<8; i++) {
			posColumn = column + i;
			if (posColumn > 8) {
				break;
			}
			if(chess.getGrid().getFigure(posColumn, row).getType()!=0) {
				if(chess.getGrid().getFigure(posColumn, row).isWhite()!=rook.isWhite()) {
					chess.getGrid().getFigure(posColumn, row).setSelected();
				}
				break;
			}
			chess.getGrid().getFigure(posColumn, row).setSelected();
		}	
		for (int i = 1; i<8; i++) {
			posColumn = column - i;
			if (posColumn < 1) {
				break;
			}
			if(chess.getGrid().getFigure(posColumn, row).getType()!=0) {
				if(chess.getGrid().getFigure(posColumn, row).isWhite()!=rook.isWhite()) {
					chess.getGrid().getFigure(posColumn, row).setSelected();
				}
				break;
			}
			chess.getGrid().getFigure(posColumn, row).setSelected();
		}
		
		
		//Reihen durchlaufen
		int posRow = 0;
		for (int i = 1; i<8; i++) {
			posRow = row + i;
			if (posRow > 8) {
				break;
			}
			if(chess.getGrid().getFigure(column, posRow).getType()!=0) {
				if(chess.getGrid().getFigure(column, posRow).isWhite()!=rook.isWhite()) {
					chess.getGrid().getFigure(column, posRow).setSelected();
				}
				break;
			}
			chess.getGrid().getFigure(column, posRow).setSelected();
		}	
		for (int i = 1; i<8; i++) {
			posRow = row - i;
			if (posRow < 1) {
				break;
			}
			if(chess.getGrid().getFigure(column, posRow).getType()!=0) {
				if(chess.getGrid().getFigure(column, posRow).isWhite()!=rook.isWhite()) {
					chess.getGrid().getFigure(column, posRow).setSelected();
				}
				break;
			}
			chess.getGrid().getFigure(column, posRow).setSelected();
		}
		
		
		
		
		
		
		
		
	}
	
	
}
