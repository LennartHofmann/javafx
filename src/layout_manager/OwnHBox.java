package layout_manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class OwnHBox extends Application{
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		TextFlow layout = new TextFlow();
		
		Text text1 = new Text("Sapere aude Sapere aude Sapere aude Sapere aude ");
		Text text2 = new Text("Sapere aude");
		
		layout.getChildren().add(text1);
		layout.getChildren().add(text2);
		
		Scene scene01 = new Scene(layout);
		primaryStage.setScene(scene01);
		primaryStage.show();
		
	}	
}