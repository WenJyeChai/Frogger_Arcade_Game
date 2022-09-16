package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the crocodile that swim across the river in game_pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Crocodile_river extends Rideable {
	int size = 130;
	Image crocodile1 = new Image("file:src/main/resources/Image/river_object/crocodile_mouth_close_new.png",size, size, true, true);
	Image crocodile2 = new Image("file:src/main/resources/Image/river_object/crocodile_mouth_open_new.png", size, size, true, true);
	boolean mouth_open = false;

	/** 
	 *  construct an instance of crocodile that with spawn position and speed
	 * 	@param position_x the horizontal spawn position
	 *  @param position_y the vertical spawn position
	 *  @param speed the speed of the crocodile moving across the river
	 *  
	 * */
	public Crocodile_river(int position_x, int position_y, double speed) {
		super(position_x, position_y, speed); 
		setImage(crocodile1);
		// TODO Auto-generated constructor stub
	}
	
	public void act(long now) {
	
		super.act(now);
		crocodileAnimation(now);
		
	}
	
	/** 
	 *  check the state of crocodile
	 *  @return true if the crocodile is with mouth open
	 * 
	 * 
	 * */
	public boolean isMouth_Open() {
		return mouth_open;
		
	}
	
	/** 
	 *  control the animation of the crocodile between mouth open or closed
	 * 	@param the current time on timer 
	 * 
	 * */
	private void crocodileAnimation(long now) {
		
		switch ((int) (now/900000000  % 5)) {
		case 0:
		case 1:
		case 2:
		case 3:
			mouth_open = false;
			setImage(crocodile1);
			break;
		case 4:
			mouth_open = true;
			setImage(crocodile2);
			break;
		}
		
	}

}
