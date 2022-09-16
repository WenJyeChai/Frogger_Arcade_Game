package p4_group_8_repo;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.controller.Menu_Controller;

/** 
 *  a class for starting the game with main menu
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Start_screen extends Application {
	Menu_Controller controller;
	
	public Start_screen() {
		
	}
		
	public static void main(String[] args) {
		launch(args);
	}
	
	/** 
	 *  function to start the game with the stage created
	 *  @param stage the stage for the scene to be presented
	 * 
	 * 
	 * */
	public void start(Stage stage) throws Exception {
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:src/main/resources/Image/frog _icon.png"));
		stage.setTitle("Frogger");
		FXMLLoader fx = new FXMLLoader();
		URL url = fx.getClassLoader().getResource("p4_group_8_repo/fxml/start.fxml");
		fx.setLocation(url);
		AnchorPane root= (AnchorPane)fx.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();


	}
}
	
