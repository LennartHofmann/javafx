package chess;

import com.sun.prism.shader.FillCircle_Color_AlphaTest_Loader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Pawn_Change_Stage extends Stage{

	
	Button queen = new Button();
	Button rook = new Button();
	Button bishop = new Button();
	Button knight = new Button();
		
	
	public Pawn_Change_Stage(Figure pawn, Figure field) {
		
		queen.setPrefSize(80, 80);
		queen.setMinSize(80, 80);
		queen.setMaxSize(80, 80);
		
		rook.setPrefSize(80, 80);
		rook.setMinSize(80, 80);
		rook.setMaxSize(80, 80);
				
		bishop.setPrefSize(80, 80);
		bishop.setMinSize(80, 80);
		bishop.setMaxSize(80, 80);
		
		knight.setPrefSize(80, 80);
		knight.setMinSize(80, 80);
		knight.setMaxSize(80, 80);
		
		queen.setStyle(field.getDefaultStyle() + " -fx-background-radius: 10px");
		rook.setStyle(field.getDefaultStyle() + " -fx-background-radius: 10px");
		bishop.setStyle(field.getDefaultStyle() + " -fx-background-radius: 10px");
		knight.setStyle(field.getDefaultStyle() + " -fx-background-radius: 10px");
		
		/*
		queen.setStyle("-fx-background-color: #ffffff; -fx-padding:0px; -fx-background-radius: 0px;");
		rook.setStyle("-fx-background-color: #ffffff; -fx-padding:0px; -fx-background-radius: 0px;");
		bishop.setStyle("-fx-background-color: #ffffff; -fx-padding:0px; -fx-background-radius: 0px;");
		knight.setStyle("-fx-background-color: #ffffff; -fx-padding:0px; -fx-background-radius: 0px;");
		_*/
		
		queen.setFont(pawn.getChess().getGrid().getTextSize());
		rook.setFont(pawn.getChess().getGrid().getTextSize());
		bishop.setFont(pawn.getChess().getGrid().getTextSize());
		knight.setFont(pawn.getChess().getGrid().getTextSize());
		
		
		queen.setId("5");
		rook.setId("2");
		bishop.setId("4");
		knight.setId("3");
		
		
		queen.setOnAction(pawn.getChess().getPcc());
		rook.setOnAction(pawn.getChess().getPcc());
		bishop.setOnAction(pawn.getChess().getPcc());
		knight.setOnAction(pawn.getChess().getPcc());
		
		
		if(pawn.isWhite()) {
			queen.setText("\u2655");
			rook.setText("\u2656");
			bishop.setText("\u2657");
			knight.setText("\u2658");
		}
		else {
			queen.setText("\u265B");
			rook.setText("\u265C");
			bishop.setText("\u265D");
			knight.setText("\u265E");
		}
		
				
		HBox content = new HBox();	
		content.getChildren().add(queen);
		content.getChildren().add(rook);
		content.getChildren().add(bishop);
		content.getChildren().add(knight);
		content.setStyle("-fx-background-color: transparent");
	

		
		Scene szene = new Scene(content);
		szene.setFill(Color.TRANSPARENT);
		
		this.setScene(szene);
		
		
		this.setAlwaysOnTop(true);
		this.initStyle(StageStyle.TRANSPARENT);
		
		this.sizeToScene();
		

		
	}
	
	
}
