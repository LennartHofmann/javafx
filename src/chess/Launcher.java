package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Launcher extends Application{

	Layout grid = new Layout();

	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage stage01) throws Exception {
		
		
		grid.initialise();
		this.grid.kc.grid = this.grid;
		this.grid.rc.grid = this.grid;
	
		
		//König setzen
		this.grid.getChildren().remove(this.grid.feld[3][4]);
		this.grid.feld[3][4] = new Figure();
		this.grid.feld[3][4].initialise(false, 6, 3, 4);
		this.grid.feld[3][4].setOnAction(this.grid.kc);
		this.grid.add(this.grid.feld[3][4], 3, 4);
		
		//2. König setzen
		this.grid.getChildren().remove(this.grid.feld[5][6]);
		this.grid.feld[5][6] = new Figure();
		this.grid.feld[5][6].initialise(false, 6, 5, 6);
		this.grid.feld[5][6].setOnAction(this.grid.kc);
		this.grid.add(this.grid.feld[5][6], 5, 6);
		
		Scene scene01 = new Scene(grid);
		stage01.setScene(scene01);
		stage01.setTitle("Chess");
		stage01.show();
		
		
	}

	
	
}
