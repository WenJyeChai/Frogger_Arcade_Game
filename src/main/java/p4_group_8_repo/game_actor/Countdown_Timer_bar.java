package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the countdown timer of the game_pane
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Countdown_Timer_bar extends Responsive_Actor {
	Image bar = new Image("file:src/main/resources/Image/fxml_bg/countdown_bar.png");
	long previous_time=0;
	int  seconds = 60;
	public boolean time_up = false;

	public Countdown_Timer_bar() {
		setX(100);
		setY(762);
		setImage(bar);
		this.setFitWidth(244);
		this.setFitHeight(27);

	}

	@Override
	public void act(long now) {

		countdownAnimation(now);
		if (seconds<=0)
			time_up = true;

	}
	
	/** 
	 *  gets the remaining time of the game
	 * 	@return the time left of the game
	 * 
	 * */
	public int getSeconds() {
		return this.seconds;
	}
	
	/** 
	 *  control the countdown animation of the rectangle
	 * 	@param the current time on timer 
	 * 
	 * */
	private void countdownAnimation(long now) {
		if (((now >= previous_time+1000000000 || previous_time == 0))&&(seconds >= 0))
		{
			if (this.getFitWidth()>4)
				{
				this.setFitWidth(this.getFitWidth()-4);
				}
			previous_time = now;
			seconds-=1;
		}
	}
	

}
