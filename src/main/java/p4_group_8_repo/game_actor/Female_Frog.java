package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;
import java.util.concurrent.ThreadLocalRandom;

/** 
 *  a class for setting the female frog of the game_pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Female_Frog extends Movable {
	int imgSize = 40;
	Image imgL1 = new Image("file:src/main/resources/Image/frog_sprite/female_froggerLeft.png", imgSize, imgSize, true, true);
	Image imgR1 = new Image("file:src/main/resources/Image/frog_sprite/female_froggerRight.png", imgSize, imgSize, true, true);
	double movementX = 10.666666 * 2;
	Log spawning_log;
	long recently_move = 0;
	
	/** 
	 *  construct the female frog instance with spawn position and the spawning_log which is {@link p4_group_8_repo.game_actor.Log} class
	 *  @param log the log that the female frog spawn on
	 * 
	 * */
	public Female_Frog(Log log) {
		super(log.getX(), log.getY(), log.speed);
		spawning_log = log;
		setImage(imgL1);
		
	}

	@Override
	public void act(long now) {
		
		super.act(now);
		frogMovement(now);

	}
	
	/** 
	 *  control the movement of the female frog to move around on the {@link p4_group_8_repo.game_actor.Log} it is spawned
	 * 	@param the current time on timer 
	 * 
	 * */
	private void frogMovement(long now) {
		
		if (!(getIntersectingObjects(Rideable.class).size() >= 1)) {
			setX(spawning_log.getX()+34);
		}
		if (!(recently_move + 600000000 > now)) {
			
			int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
			switch (randomNum) {
				case 0:
					double end_position_1 = getX()+(2 * movementX);
					if ( end_position_1 < spawning_log.getBoundsInLocal().getMaxX()+spawning_log.getSpeed())
					{
						move(movementX,0);
						setImage(imgR1);
						
					}
					break;
				case 1:
					double end_position_2 = getX()+(-2 * movementX);
					if ( end_position_2 > spawning_log.getBoundsInLocal().getMinX()+spawning_log.getSpeed())
					{
						move(-movementX,0);
						setImage(imgL1);
					}
					break;
				default:
					break;
			}
			recently_move = now;
			
		}
		
	}
	

}
