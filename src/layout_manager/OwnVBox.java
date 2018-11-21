package layout_manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OwnVBox extends Application{
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox layout = new VBox();
		
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		
		layout.getChildren().add(button1);
		layout.getChildren().add(button2);
		layout.getChildren().add(button3);
		layout.getChildren().add(button4);
		
		Scene scene01 = new Scene(layout);
		primaryStage.setScene(scene01);
		primaryStage.show();
		
	}	
}