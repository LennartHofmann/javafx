package chess;

import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class White_Figures_Pane extends GridPane{

	private Chess chess;
	private Font textSize;
	
	private int row = 0;
	private int column = 0;
	
	
	public White_Figures_Pane(Chess chess) {
		this.chess = chess;
		this.textSize = this.chess.getGrid().getTextSize();
	}
	
	
	public void addFigure(Figure figure) {	
		Label figureLabel = new Label();
		figureLabel.setFont(chess.getGrid().getTextSize());
		
		if (figure.getType()==1) {
			figureLabel.setText("\u2659");
		}
		if (figure.getType()==2) {
			figureLabel.setText("\u2656");		
		}
		if (figure.getType()==3) {
			figureLabel.setText("\u2658");
			
		}
		if (figure.getType()==4) {
			figureLabel.setText("\u2657");
		}
		if (figure.getType()==5) {
			figureLabel.setText("\u2655");
			
		}
		if (figure.getType()==6) {
			figureLabel.setText("\u2654");
		}
		
		if(column==0) {
			this.add(figureLabel, column, row);
			column = 1;
		}
		else {
			this.add(figureLabel, column, row);
			column = 0;
			row = row + 1;
		}
		this.setPrefWidth(110);		
		chess.getStage().sizeToScene();
		
	}
			


	public Font getTextSize() {
		return textSize;
	}


	public void setTextSize(Font textSize) {
		this.textSize = textSize;
	}

	
	
}
