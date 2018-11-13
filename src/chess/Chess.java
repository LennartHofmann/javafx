package chess;

import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class Chess extends HBox{
	
	Grid grid = new Grid();
	Controls controls;
	
	
	public King_Controller kc = new King_Controller();
	public Rook_Controller rook = new Rook_Controller();
	public Recieve_Controller rc = new Recieve_Controller();
	
	
	public boolean isWhitesTurn = true;
	public int selectedFigure = 0;
	
	
	public Chess() {
		this.grid.initialise();
		this.controls = new Controls(this);		
		
		this.getChildren().add(grid);
		this.getChildren().add(controls);
		
		
	}


	public boolean isWhitesTurn() {
		return isWhitesTurn;
	}


	public void setWhitesTurn(boolean isWhitesTurn) {
		this.isWhitesTurn = isWhitesTurn;
	}
	
	
	
	
	
}
