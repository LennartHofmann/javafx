package charts;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch();
		
	}

	@Override
	public void start(Stage s1) throws Exception {

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		
		BarChart<String, Number> chart = new BarChart<String, Number>(xAxis, yAxis);
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		XYChart.Data<String, Number> data1 = new XYChart.Data<String, Number>("Balken 1", 20);
		XYChart.Data<String, Number> data2 = new XYChart.Data<String, Number>("Balken 2", 40);
		
		series1.getData().addAll(data1, data2);
		series1.setName("Werte");
		chart.getData().add(series1);
		
		
		Scene szene = new Scene(chart);
		
		s1.setScene(szene);
		s1.show();
		
	}
	
}
