package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the otter that spawn on the game_pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Otter extends Obstacle {
	int size = 100;
	Image otter = new Image("file:src/main/resources/Image/river_object/otter.png", size, size, true, true);

	/** 
	 * construct the instance of otter with spawn position and speed
	 * @param position_x the horizontal position when spawned
	 * @param position_y the vertical position when spawned
	 * @param speed the moving speed of the otter
	 * 
	 * */
	public Otter(int position_x, int position_y, double speed) {
		super(position_x, position_y, speed);
		setImage(otter);
		// TODO Auto-generated constructor stub
	}

}
