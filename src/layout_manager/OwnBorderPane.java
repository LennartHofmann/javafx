package layout_manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OwnBorderPane extends Application{
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane layout = new BorderPane();
		
		
		Scene scene01 = new Scene(layout);
		primaryStage.setScene(scene01);
		primaryStage.show();
		
	}	
}