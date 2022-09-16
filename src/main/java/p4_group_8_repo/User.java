package p4_group_8_repo;

/** 
 *  a class for setting the player
 *  @author Chai Wen Jye
 * 
 * 
 * */
public class User {
	int score;
	int lives = 5 ;
	String name;

	/** 
	 *  construct the instance of user with score
	 *  @param score the score of user
	 *  @param name the name of user
	 * 
	 * 
	 * */
	public User(int score, String name) {
		this.score = score;
		this.name = name;
	}
	
	/** 
	 *  function to set score of player
	 *  @param x the increment
	 * 
	 * 
	 * */
	public void setScore(int x) {
		this.score += x;
	}
	
	/** 
	 *  function to get the score of player
	 *  @return score the current score of player
	 * 
	 * 
	 * */
	public int getScore() {
		return score;
	}
	
	/** 
	 *  function to get the remaining lives of player
	 *  @return score the current remaining lives of player
	 * 
	 * 
	 * */
	public int getLives() {
		return lives;
	}
	
	/** 
	 *  function to set the lives of the player
	 *  @param x the lives of player
	 * 
	 * 
	 * */
	public void setLives(int x) {
		this.lives = x;
	}

	/** 
	 *  function to reset the player's score
	 * 
	 * 
	 * */
	public void resetScore() {
		this.score=0;
		
	}
	
	/** 
	 *  function to reset the player's lives
	 * 
	 * 
	 * */
	public void resetLives() {
		this.lives=5;
		
	}
	
	/** 
	 *  function to get the player's name
	 *  @return name the player's name
	 * 
	 * 
	 * */
	public String getName() {
		return name;
	}

}
