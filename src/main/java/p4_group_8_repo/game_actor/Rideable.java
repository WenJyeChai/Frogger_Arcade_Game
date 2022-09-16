package p4_group_8_repo.game_actor;

/** 
 *  a base class for all rideable objects in the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */

public abstract class Rideable extends Movable {

	/** 
	 * construct a instance of rideable actor with spawn position and speed
	 * @param position_x horizontal position when spawned
	 * @param position_y vertical position when spawned
	 * @param speed speed of the actor when moving
	 * 
	 * */
	public Rideable(int position_x, int position_y,double speed) {
		super(position_x,position_y,speed);
	}
	
	/** 
	 * gets the current speed of the actor
	 * @return the speed value of the actor
	 * 
	 * */
	public double getSpeed() {
		return speed;
	}

}
