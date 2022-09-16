package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the turtle spawned on the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Turtle extends Rideable{
	private int size = 150;
	Image turtle1 = new Image("file:src/main/resources/Image/river_object/TurtleAnimation1_new.png", size, size, true, true);
	Image turtle2 = new Image("file:src/main/resources/Image/river_object/TurtleAnimation2_new.png", size, size, true, true);
	Image turtle3 = new Image("file:src/main/resources/Image/river_object/TurtleAnimation3_new.png", size, size, true, true);
	
	/** 
	 *  construct the instance of the turtle with spawned position and speed
	 *  @param position_X the horizontal position when spawned
	 *  @param position_Y the vertical position when spawned
	 *  @param speed the moving speed of the turtle
	 * 
	 * 
	 * */
	public Turtle(int position_X, int position_Y, double speed) {
		super(position_X, position_Y, speed);
		setImage(turtle2);
	}
	
	@Override
	public void act(long now) {

		super.act(now);
		floatAnimation(now);
		
	}
	
	/** 
	 *  control the floating animation of the turtle
	 * 	@param now the current time on timer 
	 * 
	 * */
	protected void floatAnimation(long now) {
		
		switch ((int) (now/900000000  % 3)) {
		case 0:
			setImage(turtle2);
			break;
		case 1:
			setImage(turtle1);
			break;
		case 2:
			setImage(turtle3);
			break;
		}
		
	}
	
}
