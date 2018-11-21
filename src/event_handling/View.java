package event_handling;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class View extends VBox{

	MouseController mc;
	KeyController kc;
	
	Button changeColor;
	Button left;
	Button up;
	Button down;
	Button right;
	
	HBox arrows;
	
	public void initialise() {
		this.changeColor = new Button("Klick um Farbe ändern");
		this.changeColor.setFont(new Font(30));
		this.changeColor.setOnMouseClicked(this.mc);
		this.getChildren().add(this.changeColor);
		
		this.arrows = new HBox();
		
		initArrowButtons();
		this.getChildren().add(this.arrows);
		this.setOnKeyPressed(kc);
		
	}

	
	public void initArrowButtons() {
		Font arrowFont = new Font(40);
		
		this.left = new Button("\u2190");
		this.left.setFont(arrowFont);
		this.left.setFocusTraversable(false);
		this.arrows.getChildren().add(this.left);
		
		this.up = new Button("\u2191");
		this.up.setFont(arrowFont);
		this.up.setFocusTraversable(false);
		this.arrows.getChildren().add(this.up);
		
		this.down = new Button("\u2193");
		this.down.setFont(arrowFont);
		this.down.setFocusTraversable(false);
		this.arrows.getChildren().add(this.down);
		
		this.right = new Button("\u2192");
		this.right.setFont(arrowFont);
		this.right.setFocusTraversable(false);
		this.arrows.getChildren().add(this.right);
	}
}
