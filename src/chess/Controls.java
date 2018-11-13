package chess;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Controls extends AnchorPane{

	public Chess chess;
	
	RadioButton radioButtonWhite;
	RadioButton radioButtonBlack;
	
	RadioButton_Controller rbc = new RadioButton_Controller();
	
	public Controls(Chess c) {
		
		this.chess = c;
		this.rbc.chess = this.chess;
		
		TitledPane whosTurn = new TitledPane();
		whosTurn.setCollapsible(false);
		whosTurn.setText("aktueller Spielzug:");
		VBox radioButtons = new VBox();
		
		ToggleGroup turn = new ToggleGroup();
		this.radioButtonWhite = new RadioButton();
		this.radioButtonWhite.setText("weiﬂ");
		this.radioButtonWhite.setToggleGroup(turn);
		this.radioButtonWhite.setSelected(this.chess.isWhitesTurn);
		this.radioButtonBlack = new RadioButton();
		this.radioButtonBlack.setText("schwarz");
		this.radioButtonBlack.setToggleGroup(turn);
		
		this.radioButtonWhite.setOnAction(rbc);
		this.radioButtonBlack.setOnAction(rbc);
		
		radioButtons.getChildren().add(this.radioButtonWhite);
		radioButtons.getChildren().add(this.radioButtonBlack);
		whosTurn.setContent(radioButtons);		
		this.getChildren().add(whosTurn);
		
	
		
	}
	
	
	
}
