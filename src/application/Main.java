package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		    Parent root =FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,800-10,500-10);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("rent-a-car-icon.png")));
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)  {
		launch(args);
//		Controller.Connection2();
	}
}
