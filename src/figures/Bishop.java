package figures;

import javafx.scene.layout.GridPane;

public class Bishop {	
		
	public static void bishopKlicked(chess.Figure bishop) {
		int column = GridPane.getColumnIndex(bishop);
		int row = GridPane.getRowIndex(bishop);
		chess.Chess chess = bishop.getChess();
		
		//nach links oben
		for (int i=1; i < 8; i++) {
			if (column - i > 0) {
				if (row - i > 0) {
					if(chess.getGrid().getFigure((column - i), (row - i)).getType()==0) {
						chess.getGrid().getFigure((column - i), (row - i)).setSelected();
					}
					else if (bishop.isWhite()!=chess.getGrid().getFigure((column - i), (row - i)).isWhite()) {
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
					else if (bishop.isWhite()!=chess.getGrid().getFigure((column - i), (row + i)).isWhite()) {
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
					else if (bishop.isWhite()!=chess.getGrid().getFigure((column + i), (row - i)).isWhite()) {
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
					else if (bishop.isWhite()!=chess.getGrid().getFigure((column + i), (row + i)).isWhite()) {
						chess.getGrid().getFigure((column + i), (row + i)).setSelected();
						break;
					}
					else {
						break;
					}
				}
			}
		}
	
	}
	
	
}
