package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class launcher extends Application{

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox parent = new VBox();
		
		TextField tf = new TextField();
		tf.setText("Hello World!");
		parent.getChildren().add(tf);
		
		
		Scene szene = new Scene(parent);
		primaryStage.setScene(szene);
		primaryStage.show();
		
		
		
	}
}
