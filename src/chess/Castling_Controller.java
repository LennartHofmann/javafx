package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class Castling_Controller implements EventHandler<ActionEvent>{

	private Chess chess;
	
	public Castling_Controller(Chess chess) {
		this.chess = chess;
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {
			
		if (event.getSource() instanceof Figure) {
			Figure actualFigure = (Figure) event.getSource();
			
			
			
			//Figuren tauschen
			actualFigure.setType(this.chess.getGrid().getSelectedFigure().getType());
			actualFigure.setWhite(this.chess.getGrid().getSelectedFigure().isWhite());
			this.chess.getGrid().setSelectedFigure(new Figure(this.chess));
			this.chess.getGrid().resetGrid();
			
			int column = GridPane.getColumnIndex(actualFigure);	
			if(actualFigure.isWhite()) {					
				if (column==3) {
					this.chess.getGrid().getFigure(3, 8).setType(6);
					this.chess.getGrid().getFigure(4, 8).setType(2);
			
					this.chess.getGrid().getFigure(1, 8).setType(0);
					this.chess.getGrid().getFigure(5, 8).setType(0);
					
					this.chess.controls.lastTurnLabel.setText("O-O-O");
					//this.chess.getStage().sizeToScene();
					
				}
				if(column==7) {
					this.chess.getGrid().getFigure(7, 8).setType(6);
					this.chess.getGrid().getFigure(6, 8).setType(2);
			
					this.chess.getGrid().getFigure(8, 8).setType(0);
					this.chess.getGrid().getFigure(5, 8).setType(0);
					
					this.chess.controls.lastTurnLabel.setText("O-O");
					//this.chess.getStage().sizeToScene();
				}
				this.chess.setLongWhiteCastling(false);
				this.chess.setShortWhiteCastling(false);
			}
			else {
				if (column==3) {
					this.chess.getGrid().getFigure(3, 1).setType(6);
					this.chess.getGrid().getFigure(4, 1).setType(2);
			
					this.chess.getGrid().getFigure(1, 1).setType(0);
					this.chess.getGrid().getFigure(5, 1).setType(0);
					
					this.chess.controls.lastTurnLabel.setText("O-O-O");
					//this.chess.getStage().sizeToScene();
				}
				if(column==7) {
					this.chess.getGrid().getFigure(7, 1).setType(6);
					this.chess.getGrid().getFigure(6, 1).setType(2);
			
					this.chess.getGrid().getFigure(8, 1).setType(0);
					this.chess.getGrid().getFigure(5, 1).setType(0);
					
					this.chess.controls.lastTurnLabel.setText("O-O");
					//this.chess.getStage().sizeToScene();
				}
				this.chess.setLongBlackCastling(false);
				this.chess.setShortBlackCastling(false);
			}
			
			this.chess.getGrid().resetGrid();
			
			
			//Zug wechseln
			if(this.chess.isWhitesTurn) {
				this.chess.setWhitesTurn(false);
				this.chess.controls.radioButtonBlack.setSelected(true);
			}
			else {
				this.chess.setWhitesTurn(true);
				this.chess.controls.radioButtonWhite.setSelected(true);
			}
			
			
		}
		
	}

}
