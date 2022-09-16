package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the turtle that will sunk spawned on the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class WetTurtle extends Turtle{
	private int size = 150;
	Image turtle4 = new Image("file:src/main/resources/Image/river_object/TurtleAnimation3Wet_new.png", size, size, true, true);
	Image turtle5 = new Image("file:src/main/resources/Image/river_object/TurtleAnimation4Wet.png", size, size, true, true);
	boolean sunk = false;
	
	/** 
	 *  construct the instance of the turtle with spawned position and speed
	 *  @param position_X the horizontal position when spawned
	 *  @param position_Y the vertical position when spawned
	 *  @param speed the moving speed of the turtle
	 * 
	 * 
	 * */
	public WetTurtle(int position_X, int position_Y, double speed) {
		super(position_X,position_Y,speed);
		
	}
	
	/** 
	 *  checked if the turtle is sunk
	 *  @return true when the turtle is at sunk status
	 * 
	 * 
	 * */
	public boolean isSunk() {
		return sunk;
		
	}
	
	/** 
	 *  control the floating animation of the turtle and being able to switch to sink status
	 * 	@param now the current time on timer 
	 * 
	 * */
	@Override
	protected void floatAnimation(long now) {
		
		switch ((int) (now/900000000  % 5)) {
		case 0:
			setImage(turtle1);
			sunk = false;
			break;
		case 1:
			setImage(turtle2);
			sunk = false;
			break;
		case 2:
			setImage(turtle3);
			sunk = false;
			break;
		case 3:
			setImage(turtle4);
			sunk = false;
			break;
		case 4:
			setImage(turtle5);
			sunk = true;
			break;
		}
		
	}

}
