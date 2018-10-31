package test;

import com.sun.xml.internal.bind.v2.runtime.property.ValueProperty;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class launcher extends Application{

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox parent = new VBox();
		
		Slider slide = new Slider();
		slide.setMax(360);
		parent.getChildren().add(slide);
		
		Label label = new Label();
		label.textProperty().bind(slide.valueProperty().asString());
		parent.getChildren().add(label);
		
		slide.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.doubleValue() > (slide.getMax() / 2)) {
					label.textProperty().unbind();
					label.setText("Größer als 50%");
				}
				else if (newValue.doubleValue() <= (slide.getMax() / 2)) {
					label.textProperty().bind(slide.valueProperty().asString());
				}
				
			}
		});
		
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY) {
					System.out.println("Links");
				}
				else if (event.getButton() == MouseButton.MIDDLE) {
					System.out.println("Mitte");
				}
				else if (event.getButton() == MouseButton.SECONDARY) {
					System.out.println("Rechts");
				}
				
			}
			
		});
		
		label.rotateProperty().bind(slide.valueProperty());

		label.translateYProperty().bind(slide.valueProperty());
		
		Scene szene = new Scene(parent);
		primaryStage.setScene(szene);
		primaryStage.show();
		
		
		
	}
}
