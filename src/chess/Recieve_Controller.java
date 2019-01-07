package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
			
			actualFigure.setType(this.chess.getGrid().getSelectedFigure().getType());
			actualFigure.setWhite(this.chess.getGrid().getSelectedFigure().isWhite());
			this.chess.getGrid().getSelectedFigure().setType(0);
			this.chess.getGrid().setSelectedFigure(new Figure(this.chess));
			this.chess.getGrid().resetGrid();
			
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
