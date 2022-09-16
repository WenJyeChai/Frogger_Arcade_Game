package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the time left notice on game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Time_left_notice extends Static_Actor {
	Image time_left_border;
	
	/** 
	 *  construct an instance of Time_left_notice
	 * 
	 * */
	public Time_left_notice() {
		time_left_border = new Image("file:src/main/resources/Image/digit/time.png", 350,350, true, true);
		setImage(time_left_border);
		setX(120);
		setY(348);
	}
	
}
