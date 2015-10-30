import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Color;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PaintBoxMain extends Application {
		
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("Paint Box!");
		StackPane layout = new StackPane();
		//layout.getChildren().add();
		
		Scene scene = new Scene(layout, 500,400);
		scene.setOnMouseClicked(evt -> {
			System.out.println("You cicked");
			
		});
		scene.setOnMouseEntered(evt -> {
			System.out.println("You entered the panel");
			scene.setFill(javafx.scene.paint.Color.AQUAMARINE);
		});
		scene.setOnMouseExited(evt -> {
			System.out.println("You exited the application!");
			scene.setFill(javafx.scene.paint.Color.WHITE);
		});
		mainStage.setScene(scene);
		mainStage.show();
	}

	
}
