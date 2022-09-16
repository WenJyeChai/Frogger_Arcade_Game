package p4_group_8_repo.game_level;

import java.io.FileNotFoundException;
import p4_group_8_repo.*;
import p4_group_8_repo.game_actor.Crocodile_river;
import p4_group_8_repo.game_actor.Female_Frog;
import p4_group_8_repo.game_actor.Log;
import p4_group_8_repo.game_actor.Obstacle;
import p4_group_8_repo.game_actor.Snake;
import p4_group_8_repo.game_actor.Turtle;
import p4_group_8_repo.game_actor.WetTurtle;

public class Game_Level_7 extends Game_Pane {

	public Game_Level_7(User user) throws FileNotFoundException {
		super(user);
		
		add(new Obstacle(50, 485, -1.5, "car_2","left"));			//forth_layer_traffic
		add(new Obstacle(150, 485, -1.5, "car_1","left"));
		add(new Obstacle(300, 460, -1.5, "truck_2","left"));
		
		add(new Obstacle(0, 510, -1.7, "truck_1","left"));			//third_layer_traffic
		add(new Obstacle(400, 510, -1.7, "truck_1","left"));
		
		add(new Obstacle(0, 587, 8, "car_1","right"));				//second_layer_traffic
		
		add(new Obstacle(120, 630, 3, "truck_2","right"));			// first_layer_traffic
		add(new Obstacle(500, 640, 3, "car_2","right"));
		add(new Obstacle(50, 640, 3, "car_1","right"));
		add(new Obstacle(370, 640, 3, "car_1","right"));
		
		add(new Turtle(500, 376, -0.7));							//first_layer_river
		add(new Turtle(300, 376, -0.7));
		add(new WetTurtle(700, 376, -0.7));

		add(new Log(50, 329, 0.5,"medium_log"));					//second_layer_river	
		add(new Crocodile_river(270, 329, 0.5));
		add(new Log(490, 329, 0.5,"medium_log"));
		
		Log log_1 = new Log(0, 276, -1,"long_log");
		add(log_1);	
		add(new Female_Frog(log_1));						//third_layer_river
		add(new Log(300, 276, -1,"long_log"));
		
		add(new Log(0, 166, 0.5,"medium_log"));						//forth_layer_river
		add(new Crocodile_river(220, 160, 0.5));
		add(new Log(440, 166, 0.5,"medium_log"));
		
		add(new WetTurtle(600, 214, -0.7));							//fifth_layer_river
		add(new WetTurtle(400, 214, -0.7));
		add(new WetTurtle(200, 214, -0.7));
		
		add(new Snake(220, 440, 0.75));
		add(animal);
		// TODO Auto-generated constructor stub
	}

}
