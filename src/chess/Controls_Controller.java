package chess;

import com.sun.javafx.event.EventHandlerManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;


public class Controls_Controller implements EventHandler<javafx.event.ActionEvent>{

	Chess chess;
	
	@Override
	public void handle(ActionEvent event) {
	
		this.chess.getGrid().resetGrid();
		
		if(this.chess.controls.radioButtonWhite.isSelected()==true) {
			this.chess.setWhitesTurn(true);
		}
		else {
			this.chess.setWhitesTurn(false);
		}
		
		if(((Node) event.getSource()).getId().compareTo("change")==0) {
			int[] firstCoordinates = this.chess.getGrid().getCoordinates(this.chess.controls.firstFieldText.getText());
			int[] secondCoordinates = this.chess.getGrid().getCoordinates(this.chess.controls.secondFieldText.getText());
			
			int figure1Type = this.chess.getGrid().getFigure(firstCoordinates[0], firstCoordinates[1]).getType();
			boolean figure1IsWhite = this.chess.getGrid().getFigure(firstCoordinates[0], firstCoordinates[1]).isWhite();
			int figure2Type = this.chess.getGrid().getFigure(secondCoordinates[0], secondCoordinates[1]).getType();
			boolean figure2IsWhite = this.chess.getGrid().getFigure(secondCoordinates[0], secondCoordinates[1]).isWhite();
			
			
			
			this.chess.getGrid().getFigure(secondCoordinates[0], secondCoordinates[1]).setType(figure1Type);
			this.chess.getGrid().getFigure(secondCoordinates[0], secondCoordinates[1]).setWhite(figure1IsWhite);
			
			this.chess.getGrid().getFigure(firstCoordinates[0], firstCoordinates[1]).setType(figure2Type);
			this.chess.getGrid().getFigure(firstCoordinates[0], firstCoordinates[1]).setWhite(figure2IsWhite);
			
			
		}

	}

}
