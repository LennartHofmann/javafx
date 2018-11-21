package event_handling;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseController implements javafx.event.EventHandler<MouseEvent>{

	
	@Override
	public void handle(MouseEvent event) {
		
		if (event.getButton() == MouseButton.PRIMARY) {
			if (event.getSource() instanceof Button) {
				((Button)(event.getSource())).setStyle("-fx-background-color: #000000");
			}
		}
		if (event.getButton() == MouseButton.SECONDARY) {
			if (event.getSource() instanceof Button) {
				((Button)(event.getSource())).setStyle("-fx-background-color: #FFFFFF");
			}
		}

		
	}

}
