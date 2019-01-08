package chess;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Controls extends VBox{

	public Chess chess;
	
	RadioButton radioButtonWhite;
	RadioButton radioButtonBlack;
	TextField firstFieldText;
	TextField secondFieldText;
	Label lastTurnLabel;	
	Controls_Controller cc = new Controls_Controller();
	
	public Controls(Chess c) {
		
		this.chess = c;
		this.cc.chess = this.chess;
		
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
		
		this.radioButtonWhite.setOnAction(cc);
		this.radioButtonWhite.setId("white");
		this.radioButtonBlack.setOnAction(cc);
		this.radioButtonBlack.setId("black");
		
		radioButtons.getChildren().add(this.radioButtonWhite);
		radioButtons.getChildren().add(this.radioButtonBlack);
		whosTurn.setContent(radioButtons);		
		this.getChildren().add(whosTurn);
		
		TitledPane lastTurn = new TitledPane();
		lastTurn.setCollapsible(false);
		lastTurn.setText("letzter Spielzug:");
		VBox lastTurnContent = new VBox();
		lastTurnLabel = new Label();
		lastTurnLabel.setFont(new Font(17));
		lastTurnContent.getChildren().add(lastTurnLabel);
		lastTurn.setContent(lastTurnContent);
		this.getChildren().add(lastTurn);
		
		
		
		TitledPane changeFields = new TitledPane();
		changeFields.setCollapsible(false);
		changeFields.setText("Felder tauschen");
		
		VBox changeFieldsContent = new VBox();
		
		HBox firstField = new HBox();
		Label firstFieldLabel = new Label("erstes Feld: ");
		this.firstFieldText = new TextField();
		firstFieldText.setMaxWidth(40);
		firstField.getChildren().add(firstFieldLabel);
		firstField.getChildren().add(firstFieldText);
		changeFieldsContent.getChildren().add(firstField);
		
		HBox secondField = new HBox();
		Label secondFieldLabel = new Label("erstes Feld: ");
		this.secondFieldText = new TextField();
		secondFieldText.setMaxWidth(40);
		secondField.getChildren().add(secondFieldLabel);
		secondField.getChildren().add(secondFieldText);
		changeFieldsContent.getChildren().add(secondField);
		
		Button changeFieldsButton = new Button("Tauschen!");
		changeFieldsButton.setId("change");
		changeFieldsButton.setOnAction(cc);
		changeFieldsContent.getChildren().add(changeFieldsButton);		
		changeFields.setContent(changeFieldsContent);
		this.getChildren().add(changeFields);
		
		
		this.setMinWidth(110);
		
		
	}
	
	
	
}
