package chess;


import javafx.scene.shape.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Launcher extends Application{

	Chess chess;

	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage01) throws Exception {
		this.chess = new Chess(stage01);
		
		
		stage01.setScene(new Scene(chess));
		stage01.setTitle("Chess");
		//stage01.setResizable(false);
		stage01.show();
		
		
		
		
	}

	
	
}
