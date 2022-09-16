package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the snake that spawned on the game_pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Snake extends Obstacle {
	int size = 70; 
	Image snake_2 = new Image("file:src/main/resources/Image/road_object/snake_medium.png", size, size, true, true);
	Image snake_3 = new Image("file:src/main/resources/Image/road_object/snake_up.png", size, size, true, true);
	

	/** 
	 *  construct the instance of the snake with spawn position and moving speed
	 *  @param position_x the horizontal spawn position
	 *  @param position_y the vertical spawn position
	 *  @param speed the moving speed of the snake
	 * 
	 * 
	 * */
	public Snake(int position_x, int position_y, double speed) {
		super(position_x, position_y, speed);
		setImage(snake_2);
		// TODO Auto-generated constructor stub
	}
	
	public void act(long now) {

		super.act(now);
		slitherAnimation(now);
		
		
	}
	
	/** 
	 *  control the moving animation of the snake
	 * 	@param the current time on timer 
	 * 
	 * */
	private void slitherAnimation( long now ) {
		
		switch ((int) (now/900000000  % 2)) {
		case 0:
			setImage(snake_2);
			break;
		case 1:
			setImage(snake_3);
			break;
		}
		
	}
	

}
