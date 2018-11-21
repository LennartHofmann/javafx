package event_handling;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyController implements javafx.event.EventHandler<KeyEvent>{

	View view;
	
	@Override
	public void handle(KeyEvent event) {
		if(event.getCode() == KeyCode.LEFT) {
			resetColors();
			this.view.left.setStyle("-fx-text-fill: red");
		}
		if(event.getCode() == KeyCode.UP) {
			resetColors();
			this.view.up.setStyle("-fx-text-fill: red");
		}
		if(event.getCode() == KeyCode.DOWN) {
			resetColors();
			this.view.down.setStyle("-fx-text-fill: red");
		}
		if(event.getCode() == KeyCode.RIGHT) {
			resetColors();
			this.view.right.setStyle("-fx-text-fill: red");
		}
		
	}
	
	void resetColors() {
		this.view.left.setStyle("-fx-text-fill: black");
		this.view.up.setStyle("-fx-text-fill: black");
		this.view.down.setStyle("-fx-text-fill: black");
		this.view.right.setStyle("-fx-text-fill: black");
	}

	
	
}
