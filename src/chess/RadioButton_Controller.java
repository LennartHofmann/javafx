package chess;

import com.sun.javafx.event.EventHandlerManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class RadioButton_Controller implements EventHandler<javafx.event.ActionEvent>{

	Chess chess;
	
	@Override
	public void handle(ActionEvent arg0) {
	
		if(this.chess.controls.radioButtonWhite.isSelected()==true) {
			this.chess.setWhitesTurn(true);
		}
		else {
			this.chess.setWhitesTurn(false);
		}
		
		
	}

	
	
}
