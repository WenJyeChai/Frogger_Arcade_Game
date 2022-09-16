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

public class Game_Level_9 extends Game_Pane {

	public Game_Level_9(User user) throws FileNotFoundException {
		super(user);	
		
		add(new Obstacle(0, 485, -4, "car_1","left"));		//forth_layer_traffic
		add(new Obstacle(280, 485, -4, "car_2","left"));
		add(new Obstacle(555, 485, -4, "car_1","left"));
		
		add(new Obstacle(0, 520, 3, "truck_2","right"));	//third_layer_traffic
		add(new Obstacle(400, 520, 3, "truck_2","right"));
		
		add(new Obstacle(0, 585, -7, "car_2","left"));		//second_layer_traffic
		add(new Obstacle(200, 585, -7, "car_1","left"));
		
		add(new Obstacle(50, 644, 3.5, "car_1","right"));		//first_layer_traffic
		add(new Obstacle(250, 644, 3.5, "car_2","right"));
		add(new Obstacle(400, 630, 3.5, "truck_2","right"));
		
		add(new Turtle(500, 376, -0.9));							//first_layer_river
		add(new Turtle(300, 376, -0.9));
		add(new WetTurtle(700, 376, -0.9));

		add(new Log(50, 329, 0.9,"medium_log"));				//second_layer_river	
		add(new Crocodile_river(270, 329, 0.9));
		add(new Log(490, 329, 0.9,"medium_log"));
		
		Log log_1 = new Log(0, 276, -1,"long_log");
		add(log_1);	
		add(new Female_Frog(log_1));					//third_layer_river
		add(new Log(300, 276, -1,"long_log"));
		
		add(new Log(0, 166, 0.9,"medium_log"));					//forth_layer_river
		add(new Crocodile_river(220, 160, 0.9));
		add(new Log(440, 166, 0.9,"medium_log"));
		
		add(new WetTurtle(600, 214, -0.9));		//fifth_layer_river
		add(new WetTurtle(400, 214, -0.9));
		add(new WetTurtle(200, 214, -0.9));
		
		add(new Snake(220, 440, 1.2));
		add(animal);
		// TODO Auto-generated constructor stub
	}

}
