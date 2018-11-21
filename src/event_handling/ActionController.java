package event_handling;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionController implements javafx.event.EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
		if(event.getSource() instanceof Button) {
			System.out.println("Button 2 ausgelöst");
		}
		
		
	}

	
	
}
