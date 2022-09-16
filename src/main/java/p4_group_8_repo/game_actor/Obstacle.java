package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a base class for all obstacle objects in the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */

public class Obstacle extends Movable {
	private int size;
	private Image imageVehicle;
	
	/** 
	 * construct a instance of vehicle obstacle actor with spawn position and speed
	 * @param position_x horizontal position when spawned
	 * @param position_y vertical position when spawned
	 * @param speed speed of the actor when moving
	 * @param vehicle_type determines whether the vehicle is truck or car (car_1,car_2,truck_1 or truck_2)
	 * @param direction the direction of the obstacle moving (left or tight)
	 * 
	 * */
	public Obstacle(int position_x, int position_y, double speed,String vehicle_type, String direction) {
		super(position_x,position_y,speed);
		switch (vehicle_type) {
		case "car_1":
		case "car_2":
			size = 60;
			break;
		case "truck_1":
		case "truck_2":
			size = 110;
			break;
		}
		imageVehicle = new Image("file:src/main/resources/Image/road_object/"+vehicle_type+"_"+direction+".png", size,size, true, true);
		setImage(imageVehicle);
	}
	
	/** 
	 * construct a instance of obstacle actor other than vehicle with spawn position and speed
	 * @param xpos horizontal position when spawned
	 * @param ypos vertical position when spawned
	 * @param s speed of the obstacle when moving
	 * 
	 * 
	 * */
	public Obstacle(int xpos, int ypos, double s) {
		super(xpos,ypos,s);
	}
	
}
