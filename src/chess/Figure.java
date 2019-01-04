package chess;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Figure extends Button{

	private Grid grid;
	private Font textSize;
	
	
	private boolean isThreatend = false;
	private boolean isWhite;
	

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
	
	public Figure(Grid grid) {
		this.setGrid(grid);
		this.setTextSize(this.grid.getTextSize());
		this.type = 0;
		
		this.setPrefSize(80, 80);
		this.setMinSize(80, 80);
		this.setMaxSize(80, 80);
		this.setFont(this.getTextSize());
	}
	
	//Getters und Setters
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public boolean isThreatend() {
		return isThreatend;
	}

	public void setThreatend(boolean isThreatend) {
		this.isThreatend = isThreatend;
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
		
		if(this.type==0) {
		}
		else if (this.type==1) {
			if(this.isWhite==true) {
				this.setText("\u2659");
			}
			else {
				this.setText("\u265F");
			}
		}
		else if (this.type==2) {
			if(this.isWhite==true) {
				this.setText("\u2656");
			}
			else {
				this.setText("\u265C");
			}
		}
		else if (this.type==3) {
			if(this.isWhite==true) {
				this.setText("\u2658");
			}
			else {
				this.setText("\u265E");
			}
		}
		else if (this.type==4) {
			if(this.isWhite==true) {
				this.setText("\u2657");
			}
			else {
				this.setText("\u265D");
			}
		}
		else if (this.type==5) {
			if(this.isWhite==true) {
				this.setText("\u2655");
			}
			else {
				this.setText("\u265B");
			}
		}
		else if (this.type==6) {
			if(this.isWhite==true) {
				this.setText("\u2654");
			}
			else {
				this.setText("\u265A");
			}
		}
		
	}

	public Font getTextSize() {
		return textSize;
	}

	public void setTextSize(Font textSize) {
		this.textSize = textSize;
	}

}
