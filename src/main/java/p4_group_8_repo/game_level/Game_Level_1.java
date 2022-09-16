package p4_group_8_repo.game_level;

import java.io.FileNotFoundException;
import p4_group_8_repo.*;
import p4_group_8_repo.game_actor.Female_Frog;
import p4_group_8_repo.game_actor.Log;
import p4_group_8_repo.game_actor.Obstacle;
import p4_group_8_repo.game_actor.Otter;
import p4_group_8_repo.game_actor.Turtle;
import p4_group_8_repo.game_actor.WetTurtle;

public class Game_Level_1 extends Game_Pane {
	public Game_Level_1(User user) throws FileNotFoundException {
		super(user);
		 
		add(new Obstacle(0, 617, 0.7, "truck_1","right")); 		// first_layer_traffic
		add(new Obstacle(300, 617, 0.7, "truck_1","right")); 
		add(new Obstacle(600, 617, 0.7, "truck_1","right")); 
		add(new Obstacle(720, 617, 0.7, "truck_1","right")); 
		
		add(new Obstacle(100, 585, -0.7, "car_1","left")); 		//second_layer_traffic
		add(new Obstacle(400, 585, -0.7, "car_1","left"));
		add(new Obstacle(550, 585, -0.7, "car_1","left"));
		
		add(new Obstacle(0, 520, 0.7, "truck_2","right"));		//third_layer_traffic
		add(new Obstacle(500, 520, 0.7, "truck_2","right"));	
		
		add(new Obstacle(150, 480, -0.8, "car_1","left"));		//forth_layer_traffic
		add(new Obstacle(300, 480, -0.8, "car_1","left"));
		add(new Obstacle(450, 480, -0.8, "car_1","left"));

		add(new Turtle(500, 376, -0.7));				//first_layer_river
		add(new Turtle(300, 376, -0.7));
		add(new WetTurtle(700, 376, -0.7));

		add(new Log(50, 329, 0.5,"medium_log"));				//second_layer_river	
		add(new Log(270, 329, 0.5,"medium_log"));
		add(new Otter(500, 329, 0.5));
		
		Log log_1 = new Log(0, 276, -1,"long_log");
		add(log_1);	
		add(new Female_Frog(log_1));					//third_layer_river
		add(new Log(300, 276, -1,"long_log"));
		
		add(new Log(0, 166, 0.5,"medium_log"));					//forth_layer_river
		add(new Log(220, 166, 0.5,"medium_log"));
		add(new Log(440, 166, 0.5,"medium_log"));
		
		add(new WetTurtle(600, 214, -0.7));		//fifth_layer_river
		add(new WetTurtle(400, 214, -0.7));
		add(new WetTurtle(200, 214, -0.7));
		
		add(animal);
		// TODO Auto-generated constructor stub
	}

}
