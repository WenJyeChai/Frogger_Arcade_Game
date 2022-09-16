package p4_group_8_repo.controller;

import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** 
 *  a class for setting the controller that control the leaderboard search window
 * 
 * 
 * */
public class LeaderboardSearch_Controller {
	String player_name;
	String player_score;
	boolean query_exist = false;
	
	@FXML
	Label query_score;
	
	@FXML
	Label query_name;
	
	@FXML 
	Label query_context;
	
	@FXML 
	Button close_button;
	
	
	/** 
	 *  construct the controller based on query name and result
	 *  @param player_name player's name
	 *  @param player_score player's score
	 *  @param query_exist true of the query exist in text file
	 * 
	 * 
	 * */
	public LeaderboardSearch_Controller(String player_name,int player_score, boolean query_exist) {
		this.player_name = player_name;
		this.player_score = Integer.toString(player_score);
		this.query_exist = query_exist;
		// TODO Auto-generated constructor stub
	}
	
	/** 
	 *  initialize function for linking controller with fxml file
	 * 
	 * */
	@FXML
	private void initialize() throws FileNotFoundException
	{
		query_name.setText(player_name);
		if (query_exist)
			query_score.setText(player_score);
		else {
			query_context.setText("Sorry your name is not recorded in our scoreboard");
			}
	}
	
	/** 
	 *  function to close the window
	 * 
	 * */
	@FXML
	private void close_window(ActionEvent event) {
		Stage pop_out_window_stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
		pop_out_window_stage.close();	
	}


}
