package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class King_Controller implements  EventHandler<javafx.event.ActionEvent>{

	public Layout grid;
	
	public boolean isSelected = false;
		

	
	@Override
	public void handle(javafx.event.ActionEvent arg0) {		
		int spalte = Layout.getColumnIndex((Node) arg0.getTarget());
		int reihe = Layout.getRowIndex((Node) arg0.getTarget());
		
		int moglSpalten[] = new int[8];
		int moglReihen[] = new int[8];


		
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
		
		if(this.isSelected==false) {	
			for (int i = 0; i<=7; i++) {			
				for (int z = 0; z<=7; z++) {
					if(moglSpalten[i]==spalte && moglReihen[z]==reihe) {
					}
					else {
						if((this.grid.getFigure(moglSpalten[i], moglReihen[z])).getType()==0 && (this.grid.getFigure(moglSpalten[i], moglReihen[z])).isOccupied==false) {
							(this.grid.getFigure(moglSpalten[i], moglReihen[z])).setText("*");
							(this.grid.getFigure(moglSpalten[i], moglReihen[z])).setOnAction(this.grid.rc);
						}
					}
				}
			}
			
			this.grid.selSpalte = spalte;
			this.grid.selReihe = reihe;
			
			this.isSelected = true;
		}
		else {
			for (int i = 0; i<=7; i++) {			
				for (int z = 0; z<=7; z++) {
					if(moglSpalten[i]==spalte && moglReihen[z]==reihe) {
					}
					else if (this.grid.getFigure(moglSpalten[i], moglReihen[z]).getText().equals("*")){
						(this.grid.getFigure(moglSpalten[i], moglReihen[z])).setText("");
						(this.grid.getFigure(moglSpalten[i], moglReihen[z])).setOnAction(null);
					}
				}
			}
			this.isSelected = false;
			this.grid.selSpalte = null;
			this.grid.selReihe = null;
		}
		
		
		
	
		
		
		
	}

	
}
