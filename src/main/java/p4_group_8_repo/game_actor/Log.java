package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for setting the log that spawn on the river
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class Log extends Rideable {
	private int size;
	private Image imageLog;

	/** 
	 *  construct the instance of log with spawn position, the moving speed and type of the log
	 *  @param position_X the horizontal spawn position
	 *  @param position_Y the vertical spawn position
	 *  @param speed the moving speed of the log
	 *  @param log_type the type of the log (long_log or medium_log)
	 * 
	 * 
	 * */
	public Log(int position_X, int position_Y, double speed,String log_type) {
		super(position_X,position_Y,speed);
		switch (log_type) {
		case "long_log":
			size = 250;
			break;
		case "medium_log":
			size = 160;
			break;
		}
		imageLog = new Image("file:src/main/resources/Image/river_object/"+log_type+".png", size,size, true, true);
		setImage(imageLog);
		
	}
	
	public int get_Size(){
		return this.size;
	}

}
