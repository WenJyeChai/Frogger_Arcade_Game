package p4_group_8_repo.game_level;

import java.io.FileNotFoundException;
import p4_group_8_repo.*;
import p4_group_8_repo.game_actor.Crocodile_river;
import p4_group_8_repo.game_actor.Log;
import p4_group_8_repo.game_actor.Obstacle;
import p4_group_8_repo.game_actor.Otter;
import p4_group_8_repo.game_actor.Snake;
import p4_group_8_repo.game_actor.Turtle;
import p4_group_8_repo.game_actor.WetTurtle;

public class Game_Level_8 extends Game_Pane {

	public Game_Level_8(User user) throws FileNotFoundException {
		super(user);
		
		add(new Obstacle(100, 470, 2, "truck_2","right"));			//forth_layer_traffic
		add(new Obstacle(450, 480, 2, "car_2","right"));
		add(new Obstacle(0, 480, 2, "car_1","right"));
		
		add(new Obstacle(0, 505, -2, "truck_1","left"));			//third_layer_traffic
		add(new Obstacle(150, 505, -2, "truck_1","left"));
		add(new Obstacle(500, 505, -2, "truck_1","left"));
		
		add(new Obstacle(50, 590, 10, "car_1","right"));			//second_layer_traffic
		
		add(new Obstacle(50, 639, -1.5, "car_1","left"));			//first_layer_traffic
		add(new Obstacle(150, 639, -1.5, "car_2","left"));
		add(new Obstacle(300, 610, -1.5, "truck_2","left"));
		
		add(new Turtle(500, 376, -0.7));							//first_layer_river
		add(new Turtle(300, 376, -0.7));
		add(new WetTurtle(700, 376, -0.7));

		add(new Log(50, 329, 0.8,"medium_log"));				//second_layer_river	
		add(new Crocodile_river(270, 329, 0.8));
		add(new Otter(500, 329, 0.8));
		
		add(new Log(0, 276, -1,"long_log"));					//third_layer_river
		add(new Log(300, 276, -1,"long_log"));
		
		add(new Log(0, 166, 0.8,"medium_log"));					//forth_layer_river
		add(new Crocodile_river(220, 160, 0.8));
		add(new Log(440, 166, 0.8,"medium_log"));
		
		add(new WetTurtle(600, 214, -0.7));		//fifth_layer_river
		add(new WetTurtle(400, 214, -0.7));
		add(new WetTurtle(200, 214, -0.7));
		
		add(new Snake(220, 440, 0.8));
		add(animal);
		// TODO Auto-generated constructor stub
	}

}
