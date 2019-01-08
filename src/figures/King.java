package figures;

import javafx.scene.layout.GridPane;

public class King {

	public static void kingKlicked(chess.Figure king) {
		int column = GridPane.getColumnIndex(king);
		int row = GridPane.getRowIndex(king);
		chess.Chess chess = king.getChess();
				
		//Reihe überhalb des Königs
		int posRow = 0;
		if(row>1) {
			posRow = row - 1;
			if(column>1) {
				King.checkField(king, column-1, posRow);
			}
			King.checkField(king, column, posRow);
			if(column<8) {
				King.checkField(king, column+1, posRow);
			}
		}
		
		//Felder neben dem König
		if(column>1) {
			King.checkField(king, column-1, row);
		}
		if (column<8) {
			King.checkField(king, column+1, row);
		}
		
		//Reihe unterhalb des Königs
		if(row<8) {
			posRow = row + 1;
			if(column>1) {
				King.checkField(king, column-1, posRow);
			}
			King.checkField(king, column, posRow);
			if(column<8) {
				King.checkField(king, column+1, posRow);
			}
		}
		
		//Rochade
		if(king.isWhite()) {
			if(chess.isLongWhiteCastling()) {
				//prüfen ob Felder leer sind
				//TODO, prüfen, ob Felder bedroht sind
				if(chess.getGrid().getFigure(2, 8).getType()==0 && chess.getGrid().getFigure(3, 8).getType()==0 && chess.getGrid().getFigure(4, 8).getType()==0) {
					chess.getGrid().getFigure(3, 8).setStyle(chess.getGrid().getFigure(3, 8).getStyle() + " -fx-background-radius: 10px; -fx-border-width: 5px; -fx-border-style: dashed; -fx-border-color: #3d210e; -fx-border-radius: 5px;");
					chess.getGrid().getFigure(3, 8).setOnAction(chess.getCc());
				}
			}
			if(chess.isShortWhiteCastling()) {
				if(chess.getGrid().getFigure(6, 8).getType()==0 && chess.getGrid().getFigure(7, 8).getType()==0) {
					chess.getGrid().getFigure(7, 8).setStyle(chess.getGrid().getFigure(7, 8).getStyle() + " -fx-background-radius: 10px; -fx-border-width: 5px; -fx-border-style: dashed; -fx-border-color: #3d210e; -fx-border-radius: 5px;");
					chess.getGrid().getFigure(7, 8).setOnAction(chess.getCc());
				}
			}
		}
		else {
			if(chess.isLongBlackCastling()) {
				if(chess.getGrid().getFigure(2, 1).getType()==0 && chess.getGrid().getFigure(3, 1).getType()==0 && chess.getGrid().getFigure(4, 1).getType()==0) {
					chess.getGrid().getFigure(3, 1).setStyle(chess.getGrid().getFigure(3, 1).getStyle() + " -fx-background-radius: 10px; -fx-border-width: 5px; -fx-border-style: dashed; -fx-border-color: #3d210e; -fx-border-radius: 5px;");
					chess.getGrid().getFigure(3, 1).setOnAction(chess.getCc());
				}
			}
			if(chess.isShortBlackCastling()) {
				if(chess.getGrid().getFigure(6, 1).getType()==0 && chess.getGrid().getFigure(7, 1).getType()==0) {
					chess.getGrid().getFigure(7, 1).setStyle(chess.getGrid().getFigure(7, 1).getStyle() + " -fx-background-radius: 10px; -fx-border-width: 5px; -fx-border-style: dashed; -fx-border-color: #3d210e; -fx-border-radius: 5px;");
					chess.getGrid().getFigure(7, 1).setOnAction(chess.getCc());
				}
			}
		}
		

	}
		
	public static void checkField(chess.Figure king, int column, int row) {
		chess.Chess chess = king.getChess();
		
		if(chess.getGrid().getFigure(column, row).getType()==0) {
			chess.getGrid().getFigure(column, row).setSelected();
		}
		else {
			if(chess.getGrid().getFigure(column, row).isWhite()!=king.isWhite()) {
				chess.getGrid().getFigure(column, row).setSelected();
			}
		}
	}
	
}