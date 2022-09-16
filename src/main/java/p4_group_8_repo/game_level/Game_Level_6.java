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

public class Game_Level_6 extends Game_Pane {

	public Game_Level_6(User user) throws FileNotFoundException {
		super(user);
	
		add(new Obstacle(50, 485, -1.5, "car_2","left"));		// forth_layer_traffic
		add(new Obstacle(150, 485, -1.5, "car_1","left"));
		add(new Obstacle(300, 485, -1.5, "car_2","left"));
		add(new Obstacle(450, 485, -1.5, "car_1","left"));
		
		add(new Obstacle(0, 530, 6, "car_1","right"));			// third_layer_traffic
		
		add(new Obstacle(0, 565, -2, "truck_1","left"));		// second_layer_traffic
		add(new Obstacle(0, 570, -2, "truck_1","left"));
		add(new Obstacle(0, 570, -2, "truck_1","left"));
		
		add(new Obstacle(120, 615, -1.5, "truck_2","left"));	// first_layer_traffic
		add(new Obstacle(500, 615, -1.5, "truck_2","left"));
		add(new Obstacle(50, 639, -1.5, "car_2","left"));
		add(new Obstacle(370, 639, -1.5, "car_2","left"));
		
		add(new Turtle(500, 376, -0.7));							//first_layer_river
		add(new Turtle(300, 376, -0.7));
		add(new WetTurtle(700, 376, -0.7));

		add(new Log(50, 329, 0.5,"medium_log"));				//second_layer_river	
		add(new Crocodile_river(270, 329, 0.5));
		add(new Otter(500, 329, 0.5));
		
		add(new Log(0, 276, -1,"long_log"));					//third_layer_river
		add(new Log(300, 276, -1,"long_log"));
		
		add(new Log(0, 166, 0.5,"medium_log"));					//forth_layer_river
		add(new Crocodile_river(220, 160, 0.5));
		add(new Log(440, 166, 0.5,"medium_log"));
		
		add(new WetTurtle(600, 214, -0.7));		//fifth_layer_river
		add(new WetTurtle(400, 214, -0.7));
		add(new WetTurtle(200, 214, -0.7));
		
		add(new Snake(220, 440, 0.75));
		add(animal);
		// TODO Auto-generated constructor stub
	}

}
