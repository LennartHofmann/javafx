package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class Recieve_Controller implements EventHandler<ActionEvent>{

	private Chess chess;
	
	public Recieve_Controller(Chess chess) {
		this.chess = chess;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		
		if (event.getSource() instanceof Figure) {
			Figure actualFigure = (Figure) event.getSource();
			
			if(actualFigure.getType()!=0) {			
				if(actualFigure.isWhite()) {
					chess.getWhite_Figures_Pane().addFigure(actualFigure);
				}
				else {
					chess.getBlack_Figures_Pane().addFigure(actualFigure);
				}
			}
			
			
			//Rochade deaktivieren
			if(this.chess.getGrid().getSelectedFigure().getType()==2) {
				int column = GridPane.getColumnIndex(this.chess.getGrid().getSelectedFigure());
				int row = GridPane.getRowIndex(this.chess.getGrid().getSelectedFigure());
				
				if (row==1 && column==1) {
					this.chess.setLongBlackCastling(false);
				}
				else if (row==1 && column==8) {
					this.chess.setShortBlackCastling(false);
				}
				else if (row==8 && column==1) {
					this.chess.setLongWhiteCastling(false);
				}
				else if (row==8 && column==8) {
					this.chess.setShortWhiteCastling(false);
				}
			}
			if(this.chess.getGrid().getSelectedFigure().getType()==6) {
				if(this.chess.getGrid().getSelectedFigure().isWhite()) {
					this.chess.setLongWhiteCastling(false);
					this.chess.setShortWhiteCastling(false);
				}
				else {
					this.chess.setLongBlackCastling(false);
					this.chess.setShortBlackCastling(false);
				}
			}
			
			this.chess.controls.lastTurnLabel.setText(this.chess.getGrid().getSelectedFigure().getText() + this.chess.getGrid().getLabel(GridPane.getColumnIndex(this.chess.getGrid().getSelectedFigure()), GridPane.getRowIndex(this.chess.getGrid().getSelectedFigure())) + " \u21D2 " + actualFigure.getText() + this.chess.getGrid().getLabel(GridPane.getColumnIndex(actualFigure), GridPane.getRowIndex(actualFigure)));
			this.chess.getStage().sizeToScene();
			
			//Figuren tauschen
			actualFigure.setType(this.chess.getGrid().getSelectedFigure().getType());
			actualFigure.setWhite(this.chess.getGrid().getSelectedFigure().isWhite());
			this.chess.getGrid().getSelectedFigure().setType(0);
			this.chess.getGrid().setSelectedFigure(new Figure(this.chess));
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


	public Chess getChess() {
		return chess;
	}


	public void setChess(Chess chess) {
		this.chess = chess;
	}

	
	
	
}
