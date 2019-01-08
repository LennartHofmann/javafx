package figures;

import javafx.scene.layout.GridPane;

public class Knight {
	
	public static void knightKlicked(chess.Figure knight) {
		int column = GridPane.getColumnIndex(knight);
		int row = GridPane.getRowIndex(knight);
		chess.Chess chess = knight.getChess();
		
		//2 Spalten nach rechts
		if((column + 2) < 9) {
			if(row + 1 < 9) {
				Knight.checkField(knight, (column+2), (row+1));
			}
			if((row - 1) > 0) {
				Knight.checkField(knight, (column+2), (row-1));
			}
		}
		
		//1 Spalte nach rechts
		if((column + 1) < 9) {
			if(row + 2 < 9) {
				Knight.checkField(knight, (column+1), (row+2));
			}
			if((row - 2) > 0) {
				Knight.checkField(knight, (column+1), (row-2));
			}
		}
		
		//1 Spalte nach links
		if((column - 1) > 0) {
			if(row + 2 < 9) {
				Knight.checkField(knight, (column-1), (row+2));
			}
			if((row - 2) > 0) {
				Knight.checkField(knight, (column-1), (row-2));
			}
		}
		
		//2 Spalten nach links
		if((column - 2) > 0) {
			if(row + 1 < 9) {
				Knight.checkField(knight, (column-2), (row+1));
			}
			if((row - 1) > 0) {
				Knight.checkField(knight, (column-2), (row-1));
			}
		}
				
	}
	
	
	
	public static void checkField(chess.Figure knight, int column, int row) {
		chess.Chess chess = knight.getChess();
			
		if(chess.getGrid().getFigure(column, row).getType()==0) {
			chess.getGrid().getFigure(column, row).setSelected();
		}
		else {
			if(knight.isWhite()!=chess.getGrid().getFigure(column, row).isWhite()) {
				chess.getGrid().getFigure(column, row).setSelected();
			}
		}
		
		
		
	}
	
}