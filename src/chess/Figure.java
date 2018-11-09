package chess;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Figure extends Button{
	boolean isThreatend = false;
	boolean isOccupied = false;
	
	private boolean isWhite;
	private Font textGrösse = new Font(50);
	//isOccupied = true;
	
	
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
		this.isOccupied = false;
		this.type = 0;
		super.setPrefSize(80, 80);
		super.setMaxSize(80, 80);
		super.setFont(textGrösse);
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
			this.setStyle("-fx-background-color: #FFFFFF; -fx-padding:0px");
		}
		else {
			this.setStyle("-fx-background-color: #954D03; -fx-padding:0px");
		}
		
		if(type==0) {
			
		}
		else if (type==1) {
			super.setText("B");
		}
		else if (type==2) {
			super.setText("T");
		}
		else if (type==3) {
			super.setText("P");
		}
		else if (type==4) {
			super.setText("L");
		}
		else if (type==5) {
			super.setText("D");
		}
		else if (type==6) {
			super.setText("K");
		}
		
	}
	
	public Figure clone(Figure f) {
		return f;
	}
	
	
}
