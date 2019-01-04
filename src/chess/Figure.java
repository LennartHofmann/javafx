package chess;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Figure extends Button{

	private Chess chess;
	private Font textSize;
	
	private String defaultStyle;
	
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
	
	public Figure(Chess chess) {
		this.setChess(chess);
		this.setTextSize(this.chess.getGrid().getTextSize());
		this.type = 0;
		
		this.setPrefSize(80, 80);
		this.setMinSize(80, 80);
		this.setMaxSize(80, 80);
		this.setFont(this.getTextSize());
	}
	
	
	public void setSelected() {
		this.setStyle(this.getStyle() + " -fx-border-width: 5px; -fx-border-style: solid; -fx-border-color: #3d210e; -fx-border-radius: 5px;");
	}
	
	
	//Getters und Setters
	

	public boolean isThreatend() {
		return isThreatend;
	}

	public Chess getChess() {
		return chess;
	}

	public void setChess(Chess chess) {
		this.chess = chess;
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
		else {
			this.setOnAction(this.getChess().fc);
			if (this.type==1) {
				if(this.isWhite==true) {
					this.setText("\u2659");
				}
				else {
					this.setText("\u265F");
				}
			}
			if (this.type==2) {
				if(this.isWhite==true) {
					this.setText("\u2656");
				}
				else {
					this.setText("\u265C");
				}
			}
			if (this.type==3) {
				if(this.isWhite==true) {
					this.setText("\u2658");
				}
				else {
					this.setText("\u265E");
				}
			}
			if (this.type==4) {
				if(this.isWhite==true) {
					this.setText("\u2657");
				}
				else {
					this.setText("\u265D");
				}
			}
			if (this.type==5) {
				if(this.isWhite==true) {
					this.setText("\u2655");
				}
				else {
					this.setText("\u265B");
				}
			}
			if (this.type==6) {
				if(this.isWhite==true) {
					this.setText("\u2654");
				}
				else {
					this.setText("\u265A");
				}
			}
		}
		
		
		
	}

	public void setDefaultStyle() {
		this.setStyle(this.getDefaultStyle());
	}
	
	public Font getTextSize() {
		return textSize;
	}

	public void setTextSize(Font textSize) {
		this.textSize = textSize;
	}

	public String getDefaultStyle() {
		return defaultStyle;
	}

	public void setDefaultStyle(String defaultStyle) {
		this.defaultStyle = defaultStyle;
	}

	

	
	
	
}
