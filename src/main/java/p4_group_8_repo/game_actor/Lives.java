package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the remaining lives icon on game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Lives extends Static_Actor {
	Image lives_icon = new Image("file:src/main/resources/Image/Frog_Sprite/frogUp.png", 40, 40, true, true);

	/** 
	 *  construct the remaining lives icon with spawn position
	 *  @param position_x the horizontal position
	 * 
	 * 
	 * */
	public Lives(int position_x) {
		setX(position_x);
		setY(760);
		setImage(lives_icon);
		// TODO Auto-generated constructor stub
	}

}
