package p4_group_8_repo.game_actor;
import java.util.ArrayList;

/** 
 *  an abstract class extends from Static_Actor class - actors that are able to interact or perform animation as times goes by
 *  @author Chai Wen Jye
 * 
 * 
 * */

public abstract class Responsive_Actor extends Static_Actor{

	
	/** 
	 *  allow the actor to move around
	 *  @param dx steps to move horizontally
	 * 	@param dy steps to move vertically
	 * 
	 * */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
	 *  allow to check the actors that are intersecting with the current actor
	 *  @param <A> the array list of Responsive_Actor class
	 *  @param cls the class of the actor intersecting
	 *  @return the array that includes all the actors intersecting with current actor
	 * 
	 * */
    public <A extends Responsive_Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getGamePane().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    /**
	 *  behavior of the actor as times goes
	 *  @param now the current time since the animation timer starts
	 * 
	 * */
    public abstract void act(long now);

}
