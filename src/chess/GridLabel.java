package chess;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GridLabel extends Label{

	public GridLabel(String text) {
		this.setFont(new Font(25));
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setText(text);

		this.setMinWidth(30);
		try {
			Integer.valueOf(text);
		} 
		catch (Exception e) {
			this.setMinWidth(80);
		}
		
	}
	
}
