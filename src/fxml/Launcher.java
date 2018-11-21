package fxml;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch();
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String xmlpath = "src/fxml/test.xml";
		//String xmlpath = "test.xml";
		
		File f = new File(xmlpath);
		VBox box = new VBox();
		
		BarChart<String, Number> br = FXMLLoader.load(f.toURI().toURL());
		
		Scene scene1 = new Scene(br);
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		
	}
	
}
