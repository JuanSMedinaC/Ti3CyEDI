package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private ImageView background;
	
	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../ui/Sample.fxml"));
			Scene scene = new Scene(root, 1200, 800);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}