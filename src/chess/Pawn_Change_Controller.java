package chess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Pawn_Change_Controller implements EventHandler<ActionEvent>{

	private Chess chess;
	private int changeID;
	
	
	public Pawn_Change_Controller(Chess chess) {
		this.chess = chess;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		this.changeID = 0;
		
		if (event.getSource() instanceof Figure) {
			Figure actualFigure = (Figure) event.getSource();
			
			this.chess.setPcs(new Pawn_Change_Stage(this.chess.getGrid().getSelectedFigure(), actualFigure));
			Bounds boundsInScreen = actualFigure.localToScreen(actualFigure.getBoundsInLocal());
			this.chess.getPcs().setX(boundsInScreen.getMinX() - 120);
			if(this.chess.getGrid().getSelectedFigure().isWhite()) {
				this.chess.getPcs().setY(boundsInScreen.getMinY()-80);
			}
			else {
				this.chess.getPcs().setY(boundsInScreen.getMinY()+80);
			}

			this.getChess().getPcs().initOwner(this.getChess().getStage());
			this.getChess().getPcs().initModality(Modality.APPLICATION_MODAL);
			this.chess.getPcs().showAndWait();
			
			
			//geschlagene Figur "aussen" hinzufügen
			if(actualFigure.getType()!=0) {			
				if(actualFigure.isWhite()) {
					chess.getWhite_Figures_Pane().addFigure(actualFigure);
				}
				else {
					chess.getBlack_Figures_Pane().addFigure(actualFigure);
				}
			}
				
			
			//letzten Spielzug anzeigen
			Figure changedFigure = new Figure(this.getChess());
			changedFigure.setType(this.getChangeID());
			changedFigure.setWhite(this.getChess().getGrid().getSelectedFigure().isWhite());
			
			if	(changedFigure.getType()==0) {
				this.chess.controls.lastTurnLabel.setText(this.chess.getGrid().getSelectedFigure().getText() + this.chess.getGrid().getLabel(GridPane.getColumnIndex(this.chess.getGrid().getSelectedFigure()), GridPane.getRowIndex(this.chess.getGrid().getSelectedFigure())) + " \u21D2 " + actualFigure.getText() + this.chess.getGrid().getLabel(GridPane.getColumnIndex(actualFigure), GridPane.getRowIndex(actualFigure)));
			}
			else {
				this.chess.controls.lastTurnLabel.setText(this.chess.getGrid().getSelectedFigure().getText() + this.chess.getGrid().getLabel(GridPane.getColumnIndex(this.chess.getGrid().getSelectedFigure()), GridPane.getRowIndex(this.chess.getGrid().getSelectedFigure())) + " \u21D2 " + actualFigure.getText() + this.chess.getGrid().getLabel(GridPane.getColumnIndex(actualFigure), GridPane.getRowIndex(actualFigure)) + "=" + changedFigure.getText());
			}			
			//this.chess.getStage().sizeToScene();
			
			
			//Figuren tauschen
			actualFigure.setType(this.getChangeID());
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
		//
		else {
			if(((Button) event.getSource()).getId().compareTo("5")==0) {
				//queen
				this.changeID = 5;
				this.chess.getPcs().close();
			}
			else if (((Button) event.getSource()).getId().compareTo("2")==0) {
				//rook
				this.changeID = 2;
				this.chess.getPcs().close();
			}
			else if (((Button) event.getSource()).getId().compareTo("4")==0) {
				//bishop
				this.changeID = 4;
				this.chess.getPcs().close();
			}
			else if (((Button) event.getSource()).getId().compareTo("3")==0) {
				//knight
				this.changeID = 3;
				this.chess.getPcs().close();
			}
			
		}
		
		
		
		
	}


	public Chess getChess() {
		return chess;
	}


	public void setChess(Chess chess) {
		this.chess = chess;
	}


	public int getChangeID() {
		return changeID;
	}


	public void setChangeID(int changeID) {
		this.changeID = changeID;
	}

	
	
	
	
	
}