package chess;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Figure extends Button{
	
	private boolean isThreatend = false;
	private boolean isWhite;
	private Font textgroesse = new Font(55);
	
	
	
	private int type;
	
	/*
	 * type = 0 -> leer
	 * type = 1 -> Bauer
	 * type = 2 -> Turm
	 * type = 3 -> Pferd
	 * type = 4 -> Laeufer
	 * type = 5 -> Dame
	 * tape = 6 -> Koenig
	 */

	public Figure() {
		//this.isOccupied = false;
		this.type = 0;
		super.setPrefSize(80, 80);
		super.setMinSize(80, 80);
		super.setMaxSize(80, 80);
		super.setFont(textgroesse);
	}
	
	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void initialise(boolean isWhite, int type, int i, int z) {
		if(type!=0) {
			this.isOccupied = true;
		}
		
		this.isWhite = isWhite;
		this.type = type;
		
		if(((i+z) % 2)==0) {
			this.setStyle("-fx-background-color: #edb99a; -fx-padding: 0px");
		}
		else {
			this.setStyle("-fx-background-color: #954D03; -fx-padding:0px");
		}
		
		
		if(this.type==0) {
			
		}
		else if (this.type==1) {
			if(this.isWhite==true) {
				super.setText("\u2659");
			}
			else {
				super.setText("\u265F");
			}
		}
		else if (this.type==2) {
			if(this.isWhite==true) {
				super.setText("\u2656");
			}
			else {
				super.setText("\u265C");
			}
		}
		else if (this.type==3) {
			if(this.isWhite==true) {
				super.setText("\u2658");
			}
			else {
				super.setText("\u265E");
			}
		}
		else if (this.type==4) {
			if(this.isWhite==true) {
				super.setText("\u2657");
			}
			else {
				super.setText("\u265D");
			}
		}
		else if (this.type==5) {
			if(this.isWhite==true) {
				super.setText("\u2655");
			}
			else {
				super.setText("\u265B");
			}
		}
		else if (this.type==6) {
			if(this.isWhite==true) {
				super.setText("\u2654");
			}
			else {
				super.setText("\u265A");
			}
		}
		
		
	}
	
	
	
}
