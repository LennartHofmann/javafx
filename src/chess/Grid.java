package chess;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Grid extends GridPane{

	private Chess chess;
	
	private Figure[][] feld = new Figure[9][9];
	private Figure selectedFigure;
	
	private Font textSize = new Font(55);
	
	
	
	
	
	void initialise(Chess chess) {
		this.setChess(chess);		
		this.setSelectedFigure(new Figure(chess));
		
		this.initLabels();
		this.initFigures();

		
		
	}
	
	
	
	
	public Figure getFigure(int spalte, int reihe) {
		ObservableList<Node> list = this.getChildren();	
		for (Node node : list) {
			if(GridPane.getColumnIndex(node) == (spalte) && GridPane.getRowIndex(node) == reihe) {
				return((Figure) node);
	        }	
		}
		return null;
	}
	
	
	public void resetGrid() {
		for (int i = 1; i<=8; i++) {
			for (int z = 1; z <=8; z++) {
				this.getFigure(i, z).setStyle(this.getFigure(i, z).getDefaultStyle());
				this.getFigure(i, z).setType(this.getFigure(i, z).getType());
			}				
		}
	}
	
	
	public void initFigures() {
		
		for (int i = 1; i <= 8; i++) {
			for (int z = 1; z <=8; z++) {
				this.feld[i][z] = new Figure(this.chess);
				
				if(((i+z) % 2)==0) {
					this.feld[i][z].setDefaultStyle("-fx-background-color: #edb99a; -fx-padding:0px; -fx-background-radius: 0px;");
				}
				else {
					this.feld[i][z].setDefaultStyle("-fx-background-color: #954D03; -fx-padding:0px; -fx-background-radius: 0px;");
				}
				this.feld[i][z].setStyle(this.feld[i][z].getDefaultStyle());
				this.add(this.feld[i][z], i, z);
			}
		}
		
				
		// schwarze Figuren (außer Bauern)
		for (int column = 1; column <= 8; column++) {
			this.feld[column][1].setWhite(false);
		}
		this.feld[1][1].setType(2);
		this.feld[2][1].setType(3);
		this.feld[3][1].setType(4);
		this.feld[4][1].setType(5);
		this.feld[5][1].setType(6);
		this.feld[6][1].setType(4);
		this.feld[7][1].setType(3);
		this.feld[8][1].setType(2);
		// schwarze Bauern
		for (int column = 1; column <= 8; column++) {
			this.feld[column][2].setWhite(false);
			this.feld[column][2].setType(1);
		}
				
		
		// weisse Figuren (außer Bauern)
		for (int column = 1; column <= 8; column++) {
			this.feld[column][8].setWhite(true);
		}
		this.feld[1][8].setType(2);
		this.feld[2][8].setType(3);
		this.feld[3][8].setType(4);
		this.feld[4][8].setType(5);
		this.feld[5][8].setType(6);
		this.feld[6][8].setType(4);
		this.feld[7][8].setType(3);
		this.feld[8][8].setType(2);
		
		
		//weisse Bauern
		for (int column = 1; column <= 8; column++) {
			this.feld[column][7].setWhite(true);
			this.feld[column][7].setType(1);
		}

	}

	public void initLabels() {
		GridLabel labelA = new GridLabel("A");
		this.add(labelA, 1, 9);
		GridLabel labelB = new GridLabel("B");
		this.add(labelB, 2, 9);
		GridLabel labelC = new GridLabel("C");
		this.add(labelC, 3, 9);
		GridLabel labelD = new GridLabel("D");
		this.add(labelD, 4, 9);
		GridLabel labelE = new GridLabel("E");
		this.add(labelE, 5, 9);
		GridLabel labelF = new GridLabel("F");
		this.add(labelF, 6, 9);
		GridLabel labelG = new GridLabel("G");
		this.add(labelG, 7, 9);
		GridLabel labelH = new GridLabel("H");
		this.add(labelH, 8, 9);
		
		GridLabel label8 = new GridLabel("8");
		this.add(label8, 0, 1);
		GridLabel label7 = new GridLabel("7");
		this.add(label7, 0, 2);
		GridLabel label6 = new GridLabel("6");
		this.add(label6, 0, 3);
		GridLabel label5 = new GridLabel("5");
		this.add(label5, 0, 4);
		GridLabel label4 = new GridLabel("4");
		this.add(label4, 0, 5);
		GridLabel label3 = new GridLabel("3");
		this.add(label3, 0, 6);
		GridLabel label2 = new GridLabel("2");
		this.add(label2, 0, 7);
		GridLabel label1 = new GridLabel("1");
		this.add(label1, 0, 8);
	}
	

	public int[] getCoordinates(String coordinatesString) {
		int[] i = new int[2];
		i[0]=0;
		i[1]=0;
		if(coordinatesString.length()==2) {
			try {
				//first
				String letter = coordinatesString.substring(0,1);
				if(letter.compareTo("A")==0) {
					i[0] = 1;
				}
				else if(letter.compareTo("B")==0) {
					i[0] = 2;
				}
				else if(letter.compareTo("C")==0) {
					i[0] = 3;
				}
				else if(letter.compareTo("D")==0) {
					i[0] = 4;
				}
				else if(letter.compareTo("E")==0) {
					i[0] = 5;
				}
				else if(letter.compareTo("F")==0) {
					i[0] = 6;
				}
				else if(letter.compareTo("G")==0) {
					i[0] = 7;
				}
				else if(letter.compareTo("H")==0) {
					i[0] = 8;
				}
				
				
				//second
				int number = Integer.valueOf(coordinatesString.substring(1, 2));
				if(number==8) {
					i[1]=1;
				}
				else if(number==7) {
					i[1]=2;
				}
				else if(number==6) {
					i[1]=3;
				}
				else if(number==5) {
					i[1]=4;
				}
				else if(number==4) {
					i[1]=5;
				}
				else if(number==3) {
					i[1]=6;
				}
				else if(number==2) {
					i[1]=7;
				}
				else if(number==1) {
					i[1]=8;
				}
				
				
				
			} catch (Exception e) {
			}
		}
			
		
		return i;
	}

	public Font getTextSize() {
		return textSize;
	}

	public void setTextSize(Font textSize) {
		this.textSize = textSize;
	}

	public Chess getChess() {
		return chess;
	}

	public void setChess(Chess chess) {
		this.chess = chess;
	}

	public Figure getSelectedFigure() {
		return selectedFigure;
	}

	public void setSelectedFigure(Figure selectedFigure) {
		this.selectedFigure = selectedFigure;
	}

	
}
