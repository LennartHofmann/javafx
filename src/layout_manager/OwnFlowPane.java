package layout_manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class OwnFlowPane extends Application{
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane layout = new FlowPane();
		
		Button button[] = new Button[50];
		
		for (int i = 0; i < 50; i++) {
			button[i] = new Button();
			button[i].setText("Button " + i);
			layout.getChildren().add(button[i]);
		}
		
		
		Scene scene01 = new Scene(layout);
		primaryStage.setScene(scene01);
		primaryStage.show();
		
	}	
}