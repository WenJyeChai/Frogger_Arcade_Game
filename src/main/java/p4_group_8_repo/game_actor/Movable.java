package p4_group_8_repo.game_actor;

/** 
 *  a base class for all movable objects in the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */

public abstract class Movable extends Responsive_Actor {

	protected double speed;
	
	/** 
	 * construct a instance of movable actor with spawn position and speed
	 * @param d horizontal position when spawned
	 * @param e vertical position when spawned
	 * @param speed speed of the actor when moving
	 * 
	 * */
	public Movable(double d, double e,double speed) {
		setX(d);
		setY(e);
		this.speed = speed;
	}

	@Override
	public void act(long now) {
		movement(now);
	}

	/** 
	 *  control the moving animation of the movable actor and make sure it will back to spawned point when it get out of bound
	 * 	@param the current time on timer 
	 * 
	 * */
	private void movement(long now) {
		
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
		
	}
		

}
