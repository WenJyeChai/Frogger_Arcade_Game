package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the digit that show on the game_pane and leaderboard
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Digit extends Static_Actor{
	public boolean is_score_digit;
	int size;
	Image im1;
	
	/** 
	 *  construct the instance of digit with spawn position,the value of digit and the size of it
	 *  @param value the value of the digit
	 *  @param size the size the the digit
	 *  @param position_x the horizontal spawn position
	 *  @param position_y the vertical spawn position
	 *  @param is_score_digit set if it is digit to display player's score
	 * 
	 * */
	
	public Digit(int value, int size, int position_x, int position_y,boolean is_score_digit) {
		im1 = new Image("file:src/main/resources/Image/digit/"+value+".png", size, size, true, true);
		setImage(im1);
		this.is_score_digit = is_score_digit;
		setX(position_x);
		setY(position_y);
	}
	
}
