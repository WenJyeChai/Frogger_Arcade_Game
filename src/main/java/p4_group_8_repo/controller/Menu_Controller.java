package p4_group_8_repo.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import p4_group_8_repo.User;
import p4_group_8_repo.game_actor.Digit;
import p4_group_8_repo.game_level.Game_Level_1;
import p4_group_8_repo.game_level.Game_Level_Factory;

/** 
 *  a class for setting the controller that control the interaction in the main menu
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Menu_Controller{
	MediaPlayer mediaPlayer;
	Stage current_stage;
	User new_user;
	Game_Level_Factory level_factory = new Game_Level_Factory();
	
	@FXML
	private Button start_button;
	
	@FXML
	private Button instruction_button;
	
	@FXML
	private Button scoreboard_button;
	
	@FXML
	private Button quit_button;
	
	@FXML 
	private Button back_button;
	
	@FXML
	private Button enter_game;
	
	@FXML
	private TextField player_name;
	

	/** 
	 *  construct the instance of of menu controller
	 * 
	 * 
	 * */
	public Menu_Controller()  {
		playMusic();
	}

	/** 
	 *  initialize function for linking controller with fxml file
	 * 
	 * */
	@FXML
	private void initialize()
	{

	}
	
	/** 
	 *  function to initiate the game and switch from main menu to game level 1
	 * 
	 * */
	@FXML
	private void start_game() throws Exception {
		mediaPlayer.stop();
		Stage pop_out_stage = new Stage();
		FXMLLoader fx = new FXMLLoader();
		URL url = fx.getClassLoader().getResource("p4_group_8_repo/fxml/enter_your_name.fxml");
		fx.setLocation(url);
		fx.setController(this);
		AnchorPane root= (AnchorPane)fx.load();
		pop_out_stage.initStyle(StageStyle.TRANSPARENT);
		Scene scene = new Scene(root);
		pop_out_stage.setScene(scene);
		pop_out_stage.show();		
		
	}
	
	/** 
	 *  function to initiate and switch current pane to instruction pane
	 * 
	 * */
	@FXML
	private void switch_instruction() throws Exception {
		current_stage = (Stage) instruction_button.getScene().getWindow();
		switchScene(current_stage,"p4_group_8_repo/fxml/instruction.fxml");
	}
	
	/** 
	 *  function to initiate and switch current pane to instruction pane
	 *  @param current_stage the stage that are presenting to the user at the moment
	 *  @throws IOException when the fxml file not found
	 * 
	 * */
	public void switch_instruction_from_game(Stage current_stage) throws IOException  {
		switchScene(current_stage,"p4_group_8_repo/fxml/instruction.fxml");
	}
	
	/** 
	 *  function to initiate and switch current pane to leaderboard pane
	 *  @throws IOException when the fxml file not found
	 * 
	 * */
	@FXML
	private void switch_scoreboard() throws IOException {
		current_stage = (Stage) instruction_button.getScene().getWindow();
		switchScene(current_stage,"p4_group_8_repo/fxml/leaderboard.fxml");
	}
	
	/** 
	 *  function to initiate and switch back current pane to main menu 
	 * 
	 * */
	@FXML
	private void switch_menu() throws IOException {
		current_stage = (Stage) back_button.getScene().getWindow();
		switchScene(current_stage,"p4_group_8_repo/fxml/start.fxml");
	}
	
	/** 
	 *  function to initiate and switch back current pane to main menu
	 *  @param current_stage the stage that are presenting to the user at the moment 
	 *  @throws IOException when the fxml file not found
	 *  
	 * 
	 * */
	public void switch_menu_from_game(Stage current_stage) throws IOException {
		switchScene(current_stage,"p4_group_8_repo/fxml/start.fxml");
	}
	
	/** 
	 *  function to close the program
	 * 
	 * */
	@FXML
	private void quit_game() {
        System.exit(0);
	}
	
	/** 
	 *  function to initiate and play the music
	 * 
	 * */
	private void playMusic() {
		String musicFile = "src/main/resources/Music/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/** 
	 *  function to switch current stage to another
	 *  @param stage current stage
	 *  @param the directory of the fxml file that wished to be show
	 * @throws IOException 
	 * 
	 * */
	private AnchorPane switchScene(Stage stage, String dir) throws IOException{
		mediaPlayer.stop();
		FXMLLoader fx = new FXMLLoader();
		URL url = fx.getClassLoader().getResource(dir);
		fx.setLocation(url);
		AnchorPane root= (AnchorPane)fx.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		return root;

	}			   

	/** 
	 *  function to initiate digit class and show it on leaderboard
	 *  @param n the score
	 *  @param size the size of the digit 
	 *  @param x position x
	 *  @param y position y
	 *  @param root the current stage
	 * */
	public void setNumber(int n,int size,int x,int y,AnchorPane root) {
		int shift = 0;
		while (n > 0) {
			  int d = n / 10;
			  int k = n - d * 10;
			  n = d;
			  root.getChildren().add(new Digit(k, size, x - shift, y, true));
			  shift+=33;
			}
	}
	
	/** 
	 *  function to initiate the game start 
	 *  
	 * */
	@FXML
	private void proceed_game(ActionEvent event) throws IOException {
		Stage pop_out_window = (Stage) ((Button)event.getSource()).getScene().getWindow();
		String input = player_name.getText();
		if (input.isEmpty())
			new_user = new User(0,"player");
		else 
			new_user = new User(0,input);
		Game_Level_1 game_background = (Game_Level_1) level_factory.make_levels(1, new_user);
		current_stage = (Stage) instruction_button.getScene().getWindow();
		Scene scene  = new Scene(game_background,600,800);
		current_stage.setTitle("Frogger");
		current_stage.setScene(scene);
		Game_Controller game_controller = Game_Controller.getGameController(current_stage);
		game_controller.start();
		game_background.start();
		current_stage.show();
		pop_out_window.close();
		
	}
}
