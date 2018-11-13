package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class King_Controller implements  EventHandler<javafx.event.ActionEvent>{

	public Chess chess;
	
	boolean isSelected = false;
		
	boolean isWhite;
	
	@Override
	public void handle(javafx.event.ActionEvent arg0) {				
		int spalte = GridPane.getColumnIndex((Node) arg0.getTarget());
		int reihe = GridPane.getRowIndex((Node) arg0.getTarget());
		
		int moglSpalten[] = new int[8];
		int moglReihen[] = new int[8];

		this.isWhite = this.chess.grid.getFigure(spalte, reihe).isWhite();
		
		for (int i = 0; i<=7; i++) {
			moglSpalten[i] = spalte;
		}	
		if(spalte!=0) {
			moglSpalten[1] = (spalte - 1);
		}
		if(spalte!=7) {
			moglSpalten[2] = (spalte + 1);
		}
		
		for (int i = 0; i<=7; i++) {
			moglReihen[i] = reihe;
		}
		if(reihe!=0) {
			moglReihen[1] = (reihe - 1);
		}
		if(reihe!=7) {
			moglReihen[2] = (reihe + 1);
		}
		
		
		if(this.chess.isWhitesTurn==this.isWhite) {		
			if(this.isSelected==false) {	
				for (int i = 0; i<=7; i++) {			
					for (int z = 0; z<=7; z++) {
						if(moglSpalten[i]==spalte && moglReihen[z]==reihe) {
						}
						else {
							if((this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).getType()==0 && (this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).isOccupied==false) {
								(this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).setText("*");
								(this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).setOnAction(this.chess.rc);
							}
						}
					}
				}
				
				this.chess.grid.selSpalte = spalte;
				this.chess.grid.selReihe = reihe;
				this.chess.selectedFigure = 6;
				this.isSelected = true;
			}
			else if (this.isSelected==true && this.chess.grid.selSpalte==spalte && this.chess.grid.selReihe==reihe){
				this.chess.grid.deletAllStars();
				this.isSelected = false;
				this.chess.grid.selSpalte = null;
				this.chess.grid.selReihe = null;
			}
			else if (this.isSelected==true){
				this.chess.grid.deletAllStars();
				for (int i = 0; i <=7; i++) {
					for (int z = 0; z <=7; z++) {
						if(this.chess.grid.selSpalte==spalte && this.chess.grid.selReihe==reihe) {
						}
						else if((this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).getType()==0 && (this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).isOccupied==false) {
								(this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).setText("*");
								(this.chess.grid.getFigure(moglSpalten[i], moglReihen[z])).setOnAction(this.chess.rc);
						}
					}
				}
				
				this.chess.grid.selSpalte = spalte;
				this.chess.grid.selReihe = reihe;
				this.isSelected = true;
				
			}
		}
		
	}

	
}
