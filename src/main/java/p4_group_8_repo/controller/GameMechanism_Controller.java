package p4_group_8_repo.controller;

import java.io.FileNotFoundException;

import p4_group_8_repo.game_actor.Countdown_Timer_bar;
import p4_group_8_repo.game_actor.Crocodile_river;
import p4_group_8_repo.game_actor.End;
import p4_group_8_repo.game_actor.Female_Frog;
import p4_group_8_repo.game_actor.Obstacle;
import p4_group_8_repo.game_actor.Rideable;
import p4_group_8_repo.game_actor.WetTurtle;
import p4_group_8_repo.game_level.Game_Pane;

/** 
 *  a class for setting the controller that control the player's interaction in {@link p4_group_8_repo.game_level.Game_Pane}
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class GameMechanism_Controller {
	static GameMechanism_Controller game__Mechanism_Controller_instance;

	/** 
	 * construct the instance of gameMechanism controller
	 * 
	 * */
	private GameMechanism_Controller() {
	}
	
	/** 
	 * actions that run throughout the game as long as the timer is running
	 * @param now the timestamp of the current time 
	 * @throws FileNotFoundException when the fxml file not found
	 * 
	 * */
	public void act(long now) throws FileNotFoundException  {
		
		Game_Pane game_pane = Game_Controller.game_pane;		
		FrogMovement(game_pane);		
		FrogInteraction(game_pane);
			
		}
	
	/** 
	 * function to detect player's key pressed and control the {@link p4_group_8_repo.game_actor.Frog} movement
	 * @param game_pane the game scene that are currently shown
	 * 
	 * */
	private void FrogMovement( Game_Pane game_pane ) {
		if (game_pane.move_up) {
			
			if (game_pane.second) {
				game_pane.animal.set_movement("UP",true);
			}
			else if (!game_pane.second) {
				game_pane.animal.set_movement("UP",false);
			}
			game_pane.move_up = false;

		}
		
		if (game_pane.move_down) {
			
			if (game_pane.second) {
				game_pane.animal.set_movement("DOWN",true);
			}
			else if (!game_pane.second) {
				game_pane.animal.set_movement("DOWN",false);
			}
			game_pane.move_down = false;
		}
		
		if (game_pane.move_left) {
			
			if (game_pane.second) {
				game_pane.animal.set_movement("LEFT",true);
			}
			else if (!game_pane.second) {
				game_pane.animal.set_movement("LEFT",false);
			}
			game_pane.move_left = false;
		}
		
		if (game_pane.move_right) {
			
			if (game_pane.second) {
				game_pane.animal.set_movement("RIGHT",true);
			}
			else if (!game_pane.second) {
				game_pane.animal.set_movement("RIGHT",false);
			}
			game_pane.move_right = false;
		}
		
		if (game_pane.jump_up) {
			game_pane.animal.set_movement("UP",true);
			if (game_pane.animal.getY() < game_pane.animal.w) {
				try {
					game_pane.changeScore();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game_pane.animal.w = game_pane.animal.getY();
				game_pane.player.setScore(10);
			}
			game_pane.jump_up = false;
		}
		
		if (game_pane.jump_down) {
			game_pane.animal.set_movement("DOWN",true);
			game_pane.jump_down = false;
		}
		
		if (game_pane.jump_left) {
			game_pane.animal.set_movement("LEFT",true);		
			game_pane.jump_left = false;
		}
		
		if (game_pane.jump_right) {
			game_pane.animal.set_movement("RIGHT",true);
			game_pane.jump_right = false;
		}
	}

	/** 
	 * function to control the interactions between the {@link p4_group_8_repo.game_actor.Frog},the map and other {@link p4_group_8_repo.game_actor.Static_Actor} that spawned
	 * @param game_pane the game scene that are currently shown
	 * @throws FileNotFoundException
	 * 
	 * */
	private void FrogInteraction( Game_Pane game_pane ) throws FileNotFoundException {
		
		if(game_pane.countdown_Timer.time_up) {
			game_pane.animal.carDeath = true;
			Game_Controller.lost_lives();
		}
		
		if(game_pane.animal.carDeath||game_pane.animal.waterDeath) {	
			game_pane.changeScore();
			game_pane.remove(game_pane.countdown_Timer);
			game_pane.countdown_Timer = new Countdown_Timer_bar();
			game_pane.add(game_pane.countdown_Timer);
		}
		
		if(game_pane.animal.deduct_live) {	
			game_pane.animal.deduct_live = false;
			Game_Controller.lost_lives();
		}
		
		if (game_pane.animal.getIntersectingObjects(Female_Frog.class).size() >= 1) {
			game_pane.remove(game_pane.animal.getIntersectingObjects(Female_Frog.class).get(0));
			game_pane.animal.has_female_frog = true;
		}
		
		if (game_pane.animal.getIntersectingObjects(Obstacle.class).size() >= 1) {
			game_pane.animal.carDeath = true;
		}
		
		else if (game_pane.animal.getIntersectingObjects(WetTurtle.class).size() >= 1 && game_pane.animal.getIntersectingObjects(WetTurtle.class).get(0).isSunk()){
			game_pane.animal.waterDeath = true;
		}
		
		else if ((game_pane.animal.getIntersectingObjects(Crocodile_river.class).size() >= 1 && game_pane.animal.getIntersectingObjects(Crocodile_river.class).get(0).isMouth_Open())) {
			game_pane.animal.waterDeath = true;
		}
		
		else if (game_pane.animal.getIntersectingObjects(Rideable.class).size() >= 1 && !game_pane.animal.noMove) {
			double ride_speed = game_pane.animal.getIntersectingObjects(Rideable.class).get(0).getSpeed();
			game_pane.animal.move(ride_speed,0);
		}
		
		else if (game_pane.animal.getIntersectingObjects(End.class).size() >= 1) {
			if(game_pane.animal.getIntersectingObjects(End.class).get(0).has_crocodile) {
				game_pane.animal.waterDeath = true;
			}
			else if (!game_pane.animal.getIntersectingObjects(End.class).get(0).isActivated()) {
				game_pane.player.setScore(50);
				game_pane.animal.end++;
				game_pane.changeScore();
				if (game_pane.animal.getIntersectingObjects(End.class).get(0).has_ladybird) {
					game_pane.player.setScore(70);
					game_pane.changeScore();
				}
				if (game_pane.animal.has_female_frog) {
					game_pane.player.setScore(50);
					game_pane.changeScore();
				}
				game_pane.animal.getIntersectingObjects(End.class).get(0).setEnd();
				game_pane.show_time_left();
				game_pane.animal.w=800;
				game_pane.animal.reset_position();
			}
			
		}
		
		else if (game_pane.animal.getY()<370){
			game_pane.animal.waterDeath = true;
		}
	}	
	
	/** 
	 *  function to get only controller instance from the class (singleton)
	 *  @return the only controller instance that being construct
	 * 
	 * */
	public static GameMechanism_Controller getGameMechanismController(){
			
			if (game__Mechanism_Controller_instance == null) {
				
				game__Mechanism_Controller_instance = new GameMechanism_Controller();
				
			}
			
			return game__Mechanism_Controller_instance;
			
		}

}
