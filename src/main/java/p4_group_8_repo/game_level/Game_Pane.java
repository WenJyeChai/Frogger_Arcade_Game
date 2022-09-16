package p4_group_8_repo.game_level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import p4_group_8_repo.*;
import p4_group_8_repo.controller.Game_Controller;
import p4_group_8_repo.game_actor.*;

/** 
 *  a class for setting the controller that control the game scene and game window
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Game_Pane extends Pane{
	MediaPlayer mediaPlayer;
	AnimationTimer timer;
	private BackgroundImage froggerback ;
	public Frog animal = new Frog();
	public User player;
	Button option;
	public Countdown_Timer_bar countdown_Timer = new Countdown_Timer_bar();
	Digit high_score;
	public boolean move_up = false;
	public boolean move_down = false;
	public boolean move_left = false;
	public boolean move_right = false;
	public boolean jump_up = false;
	public boolean jump_down = false;
	public boolean jump_left = false;
	public boolean jump_right = false;
	public boolean second = false;
	public boolean call_option = false;
	
	/** 
	 * construct the instance of {@link p4_group_8_repo.game_level.Game_Pane} with the player's detail
	 * @param user player's information
	 * @throws FileNotFoundException when the background image is not found
	 * 
	 * */
	public Game_Pane(User user) throws FileNotFoundException {
		player = user;
		set_background("file:src/main/resources/Image/bg.png");
		set_end();
		create_option();
		changeScore();
		setLives(player.getLives());
		setNumber(Game_Controller.getHighscore(), 25, 380, 40,true);
		add(countdown_Timer);
		createTimer();
		set_keyEvent();
	}
	
	/** 
	 * function to set the background image of the game based on the directory given
	 * @param dir the directory of the image
	 * 
	 * */
	private void set_background(String dir) {
		froggerback = new BackgroundImage(dir);
		add(froggerback);
		
	}

	/** 
	 * function to initialize the goal to the game scene
	 * 
	 * */
	private void set_end() {
		add(new End(12,73));
		add(new End(138,73));
		add(new End(267,73));
		add(new End(397,73));
		add(new End(530,73));	
	}

	/** 
     *  function to create timer for animation
     * 
     * 
     * */
	private void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                List<Responsive_Actor> actors = getObjects(Responsive_Actor.class);
                
                for (Responsive_Actor anActor: actors) {
                	anActor.act(now);
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
        playMusic();
    }

    /** 
     *  function to stop the timer
     * 
     * 
     * */
    public void stop() {
        timer.stop();
        mediaPlayer.stop();
    }
	
    /** 
	 *  function to initiate digit class and show it on leaderboard
	 *  @param n the score
	 *  @param size the size of the digit 
	 *  @param x position x
	 *  @param y position y
	 *  @param is_Score_Digit true if the number is a score digit
	 * */
	public void setNumber(int n,int size,int x,int y,boolean is_Score_Digit) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  add(new Digit(k, size, x - shift, y,is_Score_Digit));
    		  shift+=25;
    		}
	}
	
	/** 
	 *  function to display the remaining lives of the player based on the input
	 *  @param n remaining lives
	 *  
	 * */
	public void setLives(int n) {
    	int position_x = 544;
    	while (n > 1) {
    		  add(new Lives(position_x));
    		  position_x-=36;
    		  n--;
    		}
	}
	
	/** 
	 *  function to update the player's score and the high score
	 *  @throws FileNotFoundException when the the score file is not found
	 *  
	 * */
	public void changeScore() throws FileNotFoundException {
		
		for (Time_left_notice TL: getObjects(Time_left_notice.class)) {
			remove(TL);
		}
		for (Digit D: getObjects(Digit.class)) {
			remove(D);
		}
		if (player.getScore()>Game_Controller.getHighscore()) {
			setNumber(player.getScore(), 25, 380, 40,true);
		}
		else {
			setNumber(Game_Controller.getHighscore(), 25, 380, 40,true);
		}
		setNumber(player.getScore(),25,145,40,true);
		
		
	}

	/** 
	 *  function to show the remaining time after player reach end 
	 *  
	 * */
	public void show_time_left() {
		add(new Time_left_notice());
		setNumber(countdown_Timer.getSeconds(),36,363,441,false);
		remove(countdown_Timer);
		countdown_Timer = new Countdown_Timer_bar();
		add(countdown_Timer);
		
	}
	
	/** 
	 *  function to initiate and play the music
	 * 
	 * */
	public void playMusic() {
		String musicFile = "src/main/resources/Music/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/** 
	 *  function to add new {@link p4_group_8_repo.game_actor.Static_Actor} into the game scene 
	 *  @param static_actor the {@link p4_group_8_repo.game_actor.Static_Actor} that need to be added
	 *  
	 * */
	public void add(Static_Actor static_actor) {
        getChildren().add(static_actor);
    }

    /** 
     *  function to add {@link javafx.scene.control.Button} into the game
     *  @param button the button that need to be added
     * 
     * 
     * */
    public void add(Button button) {
        getChildren().add(button);
    }

    /** 
     *  function to remove {@link p4_group_8_repo.game_actor.Static_Actor} from game
     *  @param static_actor the {@link p4_group_8_repo.game_actor.Static_Actor} that need to be added
     * 
     * 
     * */
    public void remove(Static_Actor static_actor) {
        getChildren().remove(static_actor);
    }
    
    /** 
	 *  function to get the actors included in the scene based on the object's class
	 *  @param cls the class name of the object
	 *  @param <A> {@link p4_group_8_repo.game_actor.Static_Actor}
	 *  @return the {@link p4_group_8_repo.game_actor.Static_Actor} that is included inside the game pane
	 *  
	 * */
    public <A extends Static_Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }
    
    /** 
	 *  function to create the option button inside the game
	 *  
	 * */
    private void create_option() {
    	option = new Button();
		option.setPrefSize(40, 40);
		option.setLayoutY(20);
		option.setLayoutX(534);
		option.setOpacity(0);
		option.setCursor(Cursor.HAND);
		option.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				call_option = true;		
			}

		});
		add(option);
    }
    
    /** 
	 *  function to set the keyEvent when player pressed the keys on keyboard
	 *  
	 * */
    private void set_keyEvent() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (animal.noMove) {}
				else if (event.getCode() == KeyCode.W) {
					move_up=true;  	
					second = !second;
					
	            }
	            else if (event.getCode() == KeyCode.A) {
	            	move_left=true;
	            	second = !second;
	            	
	            }
	            else if (event.getCode() == KeyCode.S) {
	            	move_down=true;
	            	second = !second;

	            }
	            else if (event.getCode() == KeyCode.D) {
	            	move_right = true;
	            	second = !second;

	            }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (animal.noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {
					jump_up=true;
					
	            }
	            else if (event.getCode() == KeyCode.A) {
	            	jump_left=true;
	            	
	            }
	            else if (event.getCode() == KeyCode.S) {	
	            	jump_down=true;
	            	
	            }
	            else if (event.getCode() == KeyCode.D) {
	            	jump_right=true;
	            	
	            }
	        }
			}
		
		});
	}	

    



}
