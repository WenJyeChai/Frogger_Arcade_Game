package p4_group_8_repo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import p4_group_8_repo.game_level.*;

/** 
 *  a class for setting the controller that control the game scene and game window
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class GameScene_Controller {
	private Game_Level_Factory level_factory = new Game_Level_Factory();
	private static GameScene_Controller game__Scene_Controller_instance;


	/** 
	 * construct the instance of gameScene controller
	 * 
	 * */
	private GameScene_Controller() {
	}
	
	/** 
	 * actions that run throughout the game as long as the timer is running
	 * @param now the timestamp of the current time 
	 * @throws FileNotFoundException when the fxml file not found
	 * 
	 * */
	public void act(long now) throws IOException {
		
		Game_Pane game_pane = Game_Controller.game_pane;
		player_level(game_pane);
		call_option(game_pane);
		player_lose(game_pane);		
		
	}
	
	/** 
	 * function to restart the game from level 1 
	 * 
	 * */
	@FXML
	private void restart_game(ActionEvent event) throws FileNotFoundException {
		Stage restart_stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		Game_Pane game_pane = Game_Controller.game_pane;
		game_pane.player.resetScore();
		game_pane.player.resetLives();
		switch_level(new Game_Level_1(game_pane.player));
		Game_Controller game_controller = Game_Controller.getGameController(Game_Controller.stage);
		game_controller.start();
		restart_stage.close();
	}
	
	/** 
	 *  function to switch level once player won the current level
	 *  @param game_pane the current level
	 *  @param game_pane the next level 
	 * 
	 * */
	private void switch_level(Game_Pane next_level) {
		Game_Controller.game_pane.stop();
		Game_Controller.stage.getScene().setRoot(next_level);
		Game_Controller.game_pane = (Game_Pane) Game_Controller.stage.getScene().getRoot();
		Game_Controller.game_pane.start();
		
	}
	
	/** 
	 * function to bring player back to main menu
	 * @throws Exception 
	 * 
	 * */
	@FXML
	private void back_to_menu(ActionEvent event) throws IOException {
		Game_Controller.write_Score();
		Stage restart_stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		Menu_Controller menu_Controller = new Menu_Controller();
		menu_Controller.switch_menu_from_game(Game_Controller.stage);
		restart_stage.close();
	}
	
	/** 
	 *  function to bring player to leaderboard when the player won the game
	 * @throws Exception 
	 * 
	 * */
	@FXML
	private void switch_scoreboard(ActionEvent event) throws IOException {
		Stage restart_stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		Menu_Controller menu_Controller = new Menu_Controller();
		menu_Controller.switch_menu_from_game(Game_Controller.stage);
		restart_stage.close();
	}
	
	/** 
	 *  function to create a pop out window when player in game
	 *  @param dir the directory of the fxml file
	 *  @param game_pane the current 
	 * 
	 * */
	private void pop_out_window(String dir,Game_Pane game_pane){
		game_pane.stop();
		Game_Controller game_controller = Game_Controller.getGameController(Game_Controller.stage);
		game_controller.stop();
		Stage option_stage = new Stage();
		FXMLLoader fx = new FXMLLoader();
		URL url = fx.getClassLoader().getResource(dir);
		fx.setLocation(url);
		fx.setController(this);
		AnchorPane root = null;
		try {
			root = (AnchorPane)fx.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		option_stage.initStyle(StageStyle.TRANSPARENT);
		Scene scene = new Scene(root);
		option_stage.setScene(scene);
		option_stage.show();
		
	}
	
	/** 
	 *  function the resume the game from where the player call for game option
	 * 
	 * */
	@FXML
	private void resume_game(ActionEvent event) {
		Stage restart_stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		restart_stage.close();
		Game_Controller.game_pane.start();
		Game_Controller game_controller = Game_Controller.getGameController(Game_Controller.stage);
		game_controller.start();
	}
	
	/** 
	 *  function to detect if player can progress to next level or win the game
	 *  @param game_pane the game scene that are currently shown
	 * 
	 * */
	private void player_level(Game_Pane game_pane) throws IOException {
		Game_Pane next_level = null;
		if (game_pane.animal.getStop()) {
			
			if (Game_Controller.game_pane instanceof Game_Level_10) {
				pop_out_window("p4_group_8_repo/fxml/game_win.fxml",game_pane);
			}
			
			else {
				
				if (Game_Controller.game_pane instanceof Game_Level_1) {
					next_level = level_factory.make_levels(2, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_2) {
					next_level = level_factory.make_levels(3, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_3) {
					next_level = level_factory.make_levels(4, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_4) {
					next_level = level_factory.make_levels(5, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_5) {
					next_level = level_factory.make_levels(6, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_6) {
					next_level = level_factory.make_levels(7, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_7) {
					next_level = level_factory.make_levels(8, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_8) {
					next_level = level_factory.make_levels(9, game_pane.player);
				}
				
				else if (Game_Controller.game_pane instanceof Game_Level_9) {
					next_level = level_factory.make_levels(10, game_pane.player);
				}
				
				switch_level(next_level);
				
			}	

		}  
	}

	/** 
	 *  function to detect if player calls for options menu
	 *  @param game_pane the game scene that are currently shown
	 * 
	 * */
	private void call_option(Game_Pane game_pane) {
		if(game_pane.call_option) {
			pop_out_window("p4_group_8_repo/fxml/option.fxml",game_pane);
			game_pane.call_option = false;
		}	
	}

	/** 
	 *  function to detect if player lose the game
	 *  @param game_pane the game scene that are currently shown
	 * 
	 * */
	private void player_lose(Game_Pane game_pane) {
		if(game_pane.player.getLives() <=0 ) {
			Game_Controller.write_Score();
			pop_out_window("p4_group_8_repo/fxml/game_over.fxml",game_pane);
		} 
	}
	
	/** 
	 *  function to get only controller instance from the class (singleton)
	 *  @return the only controller instance that being construct
	 * 
	 * */
	public static GameScene_Controller getGameSceneController(){
		
		if (game__Scene_Controller_instance == null) {
			
			game__Scene_Controller_instance = new GameScene_Controller();
			
		}
		
		return game__Scene_Controller_instance;
		
	}

}
