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
	Castling_Controller cc;
	
	
	public boolean isWhitesTurn = true;
	
	private boolean longWhiteCastling = true;
	private boolean shortWhiteCastling = true;
	private boolean longBlackCastling = true;
	private boolean shortBlackCastling = true;
		
	
	public Chess(Stage stage) {
		this.setStage(stage);
		this.fc = new Figure_Controller(this);
		this.rc = new Recieve_Controller(this);
		this.cc = new Castling_Controller(this);
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
	public boolean isLongWhiteCastling() {
		return longWhiteCastling;
	}
	public void setLongWhiteCastling(boolean longWhiteCastling) {
		this.longWhiteCastling = longWhiteCastling;
	}
	public boolean isShortWhiteCastling() {
		return shortWhiteCastling;
	}
	public void setShortWhiteCastling(boolean shortWhiteCastling) {
		this.shortWhiteCastling = shortWhiteCastling;
	}
	public boolean isLongBlackCastling() {
		return longBlackCastling;
	}
	public void setLongBlackCastling(boolean longBlackCastling) {
		this.longBlackCastling = longBlackCastling;
	}
	public boolean isShortBlackCastling() {
		return shortBlackCastling;
	}
	public void setShortBlackCastling(boolean shortBlackCastling) {
		this.shortBlackCastling = shortBlackCastling;
	}
	
	public Castling_Controller getCc() {
		return cc;
	}
}