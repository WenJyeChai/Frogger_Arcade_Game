package p4_group_8_repo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/** 
 *  a class for setting the controller that control the leaderboard
 * 
 * 
 * */
public class Leaderboard_Controller {
	Map<String, Integer> sorted_leaderboard ;
	MediaPlayer mediaPlayer;
	
	@FXML
	Label player_1_name;
	
	@FXML
	Label player_2_name;
	
	@FXML
	Label player_3_name;

	@FXML
	Label player_4_name;

	@FXML
	Label player_5_name;

	@FXML
	Label player_1_score;

	@FXML
	Label player_2_score;

	@FXML
	Label player_3_score;

	@FXML
	Label player_4_score;

	@FXML
	Label player_5_score;
	
	@FXML
	TextField search_query;
	
	@FXML
	Button back_button;

	/** 
	 *  construct the controller and play the music
	 * 
	 * 
	 * */
	public Leaderboard_Controller() {
		playMusic();
		// TODO Auto-generated constructor stub
	}
	
	/** 
	 *  initialize function for linking controller with fxml file
	 * 
	 * */
	@FXML
	private void initialize() throws FileNotFoundException
	{
		sorted_leaderboard = read_score_from_file();
		Object[] player_name = sorted_leaderboard.keySet().toArray();
		player_1_name.setText((String) player_name[0]);
		player_2_name.setText((String) player_name[1]);
		player_3_name.setText((String) player_name[2]);
		player_4_name.setText((String) player_name[3]);
		player_5_name.setText((String) player_name[4]);
		player_1_score.setText(Integer.toString(sorted_leaderboard.get(player_1_name.getText())));
		player_2_score.setText(Integer.toString(sorted_leaderboard.get(player_2_name.getText())));
		player_3_score.setText(Integer.toString(sorted_leaderboard.get(player_3_name.getText())));
		player_4_score.setText(Integer.toString(sorted_leaderboard.get(player_4_name.getText())));
		player_5_score.setText(Integer.toString(sorted_leaderboard.get(player_5_name.getText())));
	}
	
	/** 
	 *  function to read the score from the txt file
	 *  @return the unsorted leaderboard in the form of hashmap
	 * 
	 * */
	public static Map<String, Integer> read_score_from_file() {
			Map<String, Integer> unsorted_leaderboard = new HashMap<String, Integer>();
			
			File file = new File("src/main/java/p4_group_8_repo/player_Score.txt");
			Scanner scanner = null;
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(scanner.hasNextLine()) {
					String[] arrOfStr =  scanner.nextLine().split(" ");
					if(arrOfStr.length>0) {
						unsorted_leaderboard.put(arrOfStr[0], Integer.parseInt(arrOfStr[1]));	
					}
				}
			
			return sortByValue(unsorted_leaderboard);
			
			}
	
	/** 
	 *  function to arrange the score in descending order
	 *  @param unsortMap the map of the leaderboard
	 *  @return the sorted leaderboard in the form of hashmap
	 * 
	 * */
	public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

	    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() 
	    {
	        public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) 
	        {
	            return (o2.getValue()).compareTo(o1.getValue());
	        }
	    });

	   
	    Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
	    for (Map.Entry<String, Integer> entry : list) {
	        sortedMap.put(entry.getKey(), entry.getValue());
	    }

	    return sortedMap;
	}
	
	/** 
	 *  function to execute if user perform search for score 
	 * 
	 * */
	@FXML
	private void search_rank() throws IOException {
//		mediaPlayer.stop();
		Stage stage = new Stage();
		FXMLLoader fx = new FXMLLoader();
		URL url = fx.getClassLoader().getResource("p4_group_8_repo/fxml/pop_out_leaderoard_search.fxml");
		if (sorted_leaderboard.get(search_query.getText()) != null)
			fx.setController(new LeaderboardSearch_Controller(search_query.getText(),sorted_leaderboard.get(search_query.getText()),true));
		else
			fx.setController(new LeaderboardSearch_Controller(search_query.getText(),0,false));
		fx.setLocation(url);
		AnchorPane root= (AnchorPane)fx.load();
		stage.initStyle(StageStyle.TRANSPARENT);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

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
	 *  function to initiate and switch back current pane to main menu 
	 * 
	 * */
	@FXML
	private void back_to_menu() throws IOException {
		
		Stage current_stage = (Stage) back_button.getScene().getWindow();
		mediaPlayer.stop();
		FXMLLoader fx = new FXMLLoader();
		URL url = fx.getClassLoader().getResource("p4_group_8_repo/fxml/start.fxml");
		fx.setLocation(url);
		AnchorPane root= (AnchorPane)fx.load();
		Scene scene = new Scene(root);
		current_stage.setScene(scene);
		current_stage.show();
		
	}

}
