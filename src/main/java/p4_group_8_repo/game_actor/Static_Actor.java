package p4_group_8_repo.game_actor;
import javafx.scene.image.ImageView;
import p4_group_8_repo.game_level.Game_Pane;

/** 
 *  a base abstract class for all objects in the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public abstract class Static_Actor extends ImageView {
	
	/** 
	 *  accesses the parent of the actor currently being added to
	 *  @return the parent of the current actor
	 * 
	 * */
	public Game_Pane getGamePane() {
        return (Game_Pane) getParent();
    }
	
	/**
	 * accesses the width of the actor
	 * @return the width value of the current actor
	 * 
	 * */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    
    /**
     * accesses the height of the actor 
     * @return the height value of the current actor
     * 
     * */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

}
