package fxml;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch();
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		String fxmlpath = "src/fxml/anchorPane.fxml";
		File f = new File(fxmlpath);
		
		FXMLLoader loader = new FXMLLoader(f.toURI().toURL());
		
		AnchorPane ap = loader.load();
		

		Scene scene1 = new Scene(ap);
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		
	}
	
}
