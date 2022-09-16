package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;
import java.util.concurrent.ThreadLocalRandom;

/** 
 *  a class for setting the goal on the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class End extends Responsive_Actor{
	int size = 80;
	Image crocodile_end = new Image("file:src/main/resources/Image/river_object/crocodile_end_new.png", size, size, true, true);
	Image bug_end = new Image("file:src/main/resources/Image/river_object/End_bug.png", size, size, true, true);
	Image normal_lilypad = new Image("file:src/main/resources/Image/river_object/End_lilypad.png", size, size, true, true);
	Image frog_End = new Image("file:src/main/resources/Image/frog_End.png", size, size, true, true);
	public boolean has_crocodile = false;
	public boolean has_ladybird = false;
	boolean activated = false;
	long recently_changed = 0;
	
	/** 
	 *  construct the goal with position
	 *  @param position_x the horizontal position of goal
	 *  @param position_y the vertical position of goal
	 * 
	 * */
	public End(int position_x, int position_y) {
		setX(position_x);
		setY(position_y);
		setImage(normal_lilypad);
	}
	
	@Override
	public void act(long now) {
		
		randomEndCondition(now);
		
	}
	
	/** 
	 *  activate the goal and change the image of the goal
	 * 
	 * */
	public void setEnd() {
		setImage(frog_End);
		activated = true;
	}
	
	/** 
	 *  check the activation state of the goal
	 *  @return true if the goal is activated
	 * 
	 * */
	public boolean isActivated() {
		return activated;
	}
	
	/** 
	 *  control the end goal of the game to switch between a normal lilypad, a lilypad with ladybird and crocodidle
	 * 	@param the current time on timer 
	 * 
	 * */
	private void randomEndCondition(long now) {
		
			if(!activated) {
			
				if ( recently_changed + 3000000000L > now) {	
				}
				else {
						int randomNum = ThreadLocalRandom.current().nextInt(0, 5 + 1);
						switch (randomNum) {
							case 0:
								has_ladybird = false;
								has_crocodile = true;
								setImage(crocodile_end);
								break;
							case 1:
								has_crocodile = false;
								has_ladybird = true;
								setImage(bug_end);
								break;
							default:
								has_crocodile = false;
								has_ladybird = false;
								setImage(normal_lilypad);
								break;
						}
						recently_changed = now;
						
				
				}	
		
		}
		
	}

}
