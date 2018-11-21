package event_handling;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		View background = new View();
		MouseController mc = new MouseController();
		KeyController kc = new KeyController();
		ActionController ac = new ActionController();
		
		background.ac = ac;
		background.mc = mc;
		background.kc = kc;
		background.kc.view = background;
		
		background.initialise();
		
		Scene s = new Scene(background);
		primaryStage.setScene(s);
		primaryStage.show();
		
	}
	
	
}
