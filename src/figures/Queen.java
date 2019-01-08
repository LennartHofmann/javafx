package figures;

import javafx.scene.layout.GridPane;

public class Queen {

	public static void queenKlicked(chess.Figure queen) {
		int column = GridPane.getColumnIndex(queen);
		int row = GridPane.getRowIndex(queen);
		chess.Chess chess = queen.getChess();
		
		//Felder des Läufers:
		//nach links oben
		for (int i=1; i < 8; i++) {
			if (column - i > 0) {
				if (row - i > 0) {
					if(chess.getGrid().getFigure((column - i), (row - i)).getType()==0) {
						chess.getGrid().getFigure((column - i), (row - i)).setSelected();
					}
					else if (queen.isWhite()!=chess.getGrid().getFigure((column - i), (row - i)).isWhite()) {
						chess.getGrid().getFigure((column - i), (row - i)).setSelected();
						break;
					}
					else {
						break;
					}
				}
			}
		}
		
		//nach links unten
		for (int i=1; i < 8; i++) {
			if (column - i > 0) {
				if (row + i < 9) {
					if(chess.getGrid().getFigure((column - i), (row + i)).getType()==0) {
						chess.getGrid().getFigure((column - i), (row + i)).setSelected();
					}
					else if (queen.isWhite()!=chess.getGrid().getFigure((column - i), (row + i)).isWhite()) {
						chess.getGrid().getFigure((column - i), (row + i)).setSelected();
						break;
					}
					else {
						break;
					}
				}
			}
		}
		
		//nach rechts oben
		for (int i=1; i<8; i++) {
			if (column + i < 9) {
				if (row - i > 0) {
					if(chess.getGrid().getFigure((column + i), (row - i)).getType()==0) {
						chess.getGrid().getFigure((column + i), (row - i)).setSelected();
					}
					else if (queen.isWhite()!=chess.getGrid().getFigure((column + i), (row - i)).isWhite()) {
						chess.getGrid().getFigure((column + i), (row - i)).setSelected();
						break;
					}
					else {
						break;
					}
				}
			}
		}
		
		//nach rechts unten
		for (int i=1; i<8; i++) {
			if (column + i < 9) {
				if (row + i < 9) {
					if(chess.getGrid().getFigure((column + i), (row + i)).getType()==0) {
						chess.getGrid().getFigure((column + i), (row + i)).setSelected();
					}
					else if (queen.isWhite()!=chess.getGrid().getFigure((column + i), (row + i)).isWhite()) {
						chess.getGrid().getFigure((column + i), (row + i)).setSelected();
						break;
					}
					else {
						break;
					}
				}
			}
		}
				
				
		//Felder des Turms:
		//Spalten durchlaufen
		int posColumn = 0;
		for (int i = 1; i<8; i++) {
			posColumn = column + i;
			if (posColumn > 8) {
				break;
			}
			if(chess.getGrid().getFigure(posColumn, row).getType()!=0) {
				if(chess.getGrid().getFigure(posColumn, row).isWhite()!=queen.isWhite()) {
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
				if(chess.getGrid().getFigure(posColumn, row).isWhite()!=queen.isWhite()) {
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
				if(chess.getGrid().getFigure(column, posRow).isWhite()!=queen.isWhite()) {
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
				if(chess.getGrid().getFigure(column, posRow).isWhite()!=queen.isWhite()) {
					chess.getGrid().getFigure(column, posRow).setSelected();
				}
				break;
			}
			chess.getGrid().getFigure(column, posRow).setSelected();
		}
		
		
		
	}


}
