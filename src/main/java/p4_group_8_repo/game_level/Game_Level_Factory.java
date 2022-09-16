package p4_group_8_repo.game_level;

import java.io.FileNotFoundException;

import p4_group_8_repo.User;

public class Game_Level_Factory {
	Game_Pane next_level = null;

	public Game_Level_Factory() {
		// TODO Auto-generated constructor stub
	}
	
	public Game_Pane make_levels(int levels,User user) throws FileNotFoundException {
		switch (levels){
			case 1: next_level =  new Game_Level_1(user);
					break;
			case 2: next_level =  new Game_Level_2(user);
					break;
			case 3: next_level =  new Game_Level_3(user);
					break;
			case 4: next_level =  new Game_Level_4(user);
					break;
			case 5: next_level =  new Game_Level_5(user);
					break;
			case 6: next_level =  new Game_Level_6(user);
					break;
			case 7: next_level =  new Game_Level_7(user);
					break;
			case 8: next_level =  new Game_Level_8(user);
					break;
			case 9: next_level =  new Game_Level_9(user);
					break;
			case 10: next_level =  new Game_Level_10(user);
					break;
		}
		return next_level;
		
	}

}
