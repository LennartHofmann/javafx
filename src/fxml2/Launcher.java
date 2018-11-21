package fxml2;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch();
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String xmlpath = "src/fxml2/test.xml";
		//String xmlpath = "test.xml";
		
		File f = new File(xmlpath);
		VBox box = FXMLLoader.load(f.toURI().toURL());
		
		
		Scene scene1 = new Scene(box);
		
		
				
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		
	}
	
}
