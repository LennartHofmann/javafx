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
import javafx.stage.Stage;

public class Chess extends HBox{
	
	private Stage stage;
	
	private Grid grid = new Grid();
	
	Controls controls;
	private Black_Figures_Pane black_Figures_Pane;
	private White_Figures_Pane white_Figures_Pane;
	
	Figure_Controller fc;
	Recieve_Controller rc;
	
	public boolean isWhitesTurn = true;
	
	
	public Chess(Stage stage) {
		this.setStage(stage);
		this.fc = new Figure_Controller(this);
		this.rc = new Recieve_Controller(this);
		this.grid.initialise(this);
		this.controls = new Controls(this);		
		
		this.black_Figures_Pane = new Black_Figures_Pane(this);
		this.white_Figures_Pane = new White_Figures_Pane(this);
		
		this.getChildren().add(black_Figures_Pane);
		this.getChildren().add(grid);
		this.getChildren().add(white_Figures_Pane);
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


	public Black_Figures_Pane getBlack_Figures_Pane() {
		return black_Figures_Pane;
	}


	public void setBlack_Figures_Pane(Black_Figures_Pane black_Figures_Pane) {
		this.black_Figures_Pane = black_Figures_Pane;
	}


	public Stage getStage() {
		return stage;
	}


	public void setStage(Stage stage) {
		this.stage = stage;
	}


	public White_Figures_Pane getWhite_Figures_Pane() {
		return white_Figures_Pane;
	}


	public void setWhite_Figures_Pane(White_Figures_Pane white_Figures_Pane) {
		this.white_Figures_Pane = white_Figures_Pane;
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