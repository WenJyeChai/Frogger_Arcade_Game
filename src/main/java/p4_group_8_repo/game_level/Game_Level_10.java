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

public class Game_Level_10 extends Game_Pane {

	public Game_Level_10(User user) throws FileNotFoundException {
		super(user);
		
		add(new Obstacle(50, 490, -3.8, "car_1","left"));		//forth_layer_truck
		add(new Obstacle(150, 490, -3.8, "car_1","left"));
		add(new Obstacle(300, 490, -3.8, "car_1","left"));
		
		add(new Obstacle(0, 535, 2.8, "car_2","right"));		//third_layer_truck
		add(new Obstacle(100, 535, 2.8, "car_2","right"));
		add(new Obstacle(250, 535, 2.8, "car_2","right"));
		add(new Obstacle(400, 535, 2.8, "car_2","right"));
		add(new Obstacle(550, 535, 2.8, "car_2","right"));
		
		add(new Obstacle(0, 567, -2.5, "truck_1","left"));		//second_layer_truck
		add(new Obstacle(190, 567, -2.5, "truck_1","left"));
		add(new Obstacle(450, 567, -2.5, "truck_1","left"));
		
		add(new Obstacle(100, 612, -1.5, "truck_2","left"));	//first_layer_truck
		add(new Obstacle(500, 612, -1.5, "truck_2","left"));
		
		add(new Turtle(500, 376, -0.7));							//first_layer_river
		add(new Turtle(300, 376, -0.7));
		add(new WetTurtle(700, 376, -0.7));

		add(new Log(50, 329, 1,"medium_log"));				//second_layer_river	
		add(new Crocodile_river(270, 329, 1));
		add(new Otter(500, 329, 1));
		
		add(new Log(0, 276, -1,"long_log"));					//third_layer_river
		add(new Log(300, 276, -1,"long_log"));
		
		add(new Log(0, 166, 1,"medium_log"));					//forth_layer_river
		add(new Crocodile_river(220, 160, 1));
		add(new Log(440, 166, 1,"medium_log"));
		
		add(new WetTurtle(600, 214, -0.7));		//fifth_layer_river
		add(new WetTurtle(400, 214, -0.7));
		add(new WetTurtle(200, 214, -0.7));
		
		add(new Snake(220, 440, 0.8));
		add(animal);
		// TODO Auto-generated constructor stub
	}

}
