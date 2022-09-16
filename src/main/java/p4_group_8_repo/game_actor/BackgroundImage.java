package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the background image of the game_pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class BackgroundImage extends Static_Actor{
	/** 
	 *  construct the background image 
	 *  @param imageLink the path of the image
	 * 
	 * 
	 * */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
