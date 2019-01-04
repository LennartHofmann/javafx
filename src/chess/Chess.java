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
	
	private Grid grid = new Grid();
	Controls controls;
	
	Figure_Controller fc;
	
	public boolean isWhitesTurn = true;
	
	
	public Chess() {
		this.fc = new Figure_Controller(this);
		this.grid.initialise(this);
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


	public Grid getGrid() {
		return grid;
	}


	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	/*
	public void deselectOtherControllers(int i) {
		//Resette alle Controller, auﬂer den gew‰hlten (‹bergeben via int i)
		if(i!=0) {
			
		}
		if(i!=1) {
			this.pawn.isSelected = false;
		}
		if(i!=2) {
			this.rook.isSelected = false;
		}
		if(i!=3) {
	
		}
		if(i!=4) {
			this.bishop.isSelected = false;
		}
		if(i!=5) {
			this.queen.isSelected = false;
		}
		if(i!=6) {
			this.king.isSelected = false;
		}
	}
	*/
	
	
	
}