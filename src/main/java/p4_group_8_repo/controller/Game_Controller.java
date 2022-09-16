package p4_group_8_repo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import p4_group_8_repo.game_actor.*;
import p4_group_8_repo.game_level.*;

/** 
 *  a class for setting the controller that control the interaction in {@link p4_group_8_repo.game_level.Game_Pane} class.
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Game_Controller{
	private static Game_Controller game_Controller_instance;
	static Game_Pane game_pane;
	static Stage stage;
	static AnimationTimer timer;
	static GameScene_Controller gamescene_controller;
	static GameMechanism_Controller gamemechanism_controller;
	
	@FXML
	Button yes_button;
	
	@FXML
	Button no_button;
	
	@FXML
	Button back_to_menu_button;
	
	@FXML
	Button resume_button;
	
	@FXML
	Button restart_button;
	
	/** 
	 *  initialize function for linking controller with fxml file
	 * 
	 * */
	@FXML
	private void initialize(){
	}
	
	
	/** 
	 *  construct the instance of game controller with the {@link javafx.stage.Stage} that it control.
	 * @param stage the stage that this controller control
	 * 
	 * */
	private Game_Controller(Stage stage) {
		Game_Controller.stage = stage;
		game_pane = (Game_Pane) stage.getScene().getRoot();
		createTimer();
		gamescene_controller = GameScene_Controller.getGameSceneController();
		gamemechanism_controller = GameMechanism_Controller.getGameMechanismController();
	}
	
	/** 
     *  function to create timer for animation
     * 
     * 
     * */
	private static void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                	gamescene_controller.act(now);
                	gamemechanism_controller.act(now);
				} catch (IOException e) {
					e.printStackTrace();
				}
      
            }
        };
    }

    /** 
     *  function to start the timer
     * 
     * 
     * */
    public void start() {
        timer.start();
    }

    /** 
     *  function to stop the timer
     * 
     * 
     * */
    public void stop() {
        timer.stop();
    }
	
	/** 
	 * function to deduct player's life when the frog died
	 * 
	 * */
	static void lost_lives() {
		if(game_pane.player.getLives()>1)
			game_pane.remove(game_pane.getObjects(Lives.class).get(0));
		game_pane.player.setLives(game_pane.player.getLives()-1);
	}
	
	/** 
	 * function to record the player's score into a txt file
	 * @param x the player's score
	 * 
	 * */
	static void write_Score() {
		try{
	          File file =new File("src/main/java/p4_group_8_repo/player_Score.txt");
	    	  if(!file.exists()){
	    	 	file.createNewFile();
	    	  }
	    	  FileWriter fw = new FileWriter(file,true);
	    	  PrintWriter pw = new PrintWriter(fw);
	    	  pw.println(game_pane.player.getName()+" "+game_pane.player.getScore());
	    	  pw.close();
	       }catch(IOException ioe){
	    	   System.out.println("Exception occurred:");
	    	   ioe.printStackTrace();
	      }
	}
	
	/** 
	 *  function to get the high score of text file
	 *  @return the high score value 
	 *  @throws FileNotFoundException when the score file is not found
	 * 
	 * */
	public static int getHighscore() throws FileNotFoundException {
		
		Map<String, Integer> sorted_leaderboard = Leaderboard_Controller.read_score_from_file();
		Object[] player_name = sorted_leaderboard.keySet().toArray();
		

		
		return sorted_leaderboard.get((String)player_name[0]);
		   
	}
	
	/** 
	 *  function to get only controller instance from the class (singleton)
	 *  @param stage the current window being display
	 *  @return the only controller instance that being construct
	 * 
	 * */
	public static Game_Controller getGameController(Stage stage){
			
			if (game_Controller_instance == null) {
				
				game_Controller_instance = new Game_Controller(stage);
				
			}
			else {
				game_pane = (Game_Pane) stage.getScene().getRoot();
			}
			
			return game_Controller_instance;
			
		}
	

}
