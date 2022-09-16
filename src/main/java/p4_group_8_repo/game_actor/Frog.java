package p4_group_8_repo.game_actor;

import javafx.scene.image.Image;

/** 
 *  a class for the main actor - frog in the game pane
 *  @author Chai Wen Jye
 * 
 * 
 * */

public class Frog extends Responsive_Actor {
	int imgSize = 40;
	Image imgW1 = new Image("file:src/main/resources/Image/frog_sprite/FrogUp.png", imgSize, imgSize, true, true);
	Image imgA1 = new Image("file:src/main/resources/Image/frog_sprite/FrogLeft.png", imgSize, imgSize, true, true);
	Image imgS1 = new Image("file:src/main/resources/Image/frog_sprite/FrogDown.png", imgSize, imgSize, true, true);
	Image imgD1 = new Image("file:src/main/resources/Image/frog_sprite/FrogRight.png", imgSize, imgSize, true, true);
	Image imgW2 = new Image("file:src/main/resources/Image/frog_sprite/FrogUpJump.png", imgSize, imgSize, true, true);
	Image imgA2 = new Image("file:src/main/resources/Image/frog_sprite/FrogLeftJump.png", imgSize, imgSize, true, true);
	Image imgS2 = new Image("file:src/main/resources/Image/frog_sprite/FrogDownJump.png", imgSize, imgSize, true, true);
	Image imgD2 = new Image("file:src/main/resources/Image/frog_sprite/FrogRightJump.png", imgSize, imgSize, true, true);
	Image imgFW1 = new Image("file:src/main/resources/Image/frog_sprite/froggerUp_with_femaleFrog.png", imgSize, imgSize, true, true);
	Image imgFA1 = new Image("file:src/main/resources/Image/frog_sprite/froggerLeft_with_femaleFrog.png", imgSize, imgSize, true, true);
	Image imgFS1 = new Image("file:src/main/resources/Image/frog_sprite/froggerDown_with_femaleFrog.png", imgSize, imgSize, true, true);
	Image imgFD1 = new Image("file:src/main/resources/Image/frog_sprite/froggerRight_with_femaleFrog.png", imgSize, imgSize, true, true);
	Image imgFW2 = new Image("file:src/main/resources/Image/frog_sprite/froggerUpJump_with_femaleFrog.png", imgSize, imgSize, true, true);
	Image imgFA2 = new Image("file:src/main/resources/Image/frog_sprite/froggerLeftJump_with_femaleFrog.png", imgSize, imgSize, true, true);
	Image imgFS2 = new Image("file:src/main/resources/Image/frog_sprite/froggerDownJump_with_femaleFrog.png", imgSize, imgSize, true, true);
	Image imgFD2 = new Image("file:src/main/resources/Image/frog_sprite/froggerRightJump_with_femaleFrog.png", imgSize, imgSize, true, true);
	public int end = 0;
	public boolean noMove = false;
	private double movement = 26;
	private double movementX = 20;
	public boolean carDeath = false;
	public boolean waterDeath = false;
	public boolean deduct_live = false;
	private int carD = 0;
	public double w = 800;
	public boolean has_female_frog = false;
	
	/** 
	 * construct a instance of Frog and reset its position
	 * 
	 * */
	public Frog() {
		reset_position();

	}
	
	/** 
	 * set the movement of the frog actor
	 * @param direction the direction of the frog actor moving
	 * @param is_Second to detect whether to perform jump animation
	 * 
	 * */
	public void set_movement(String direction,boolean is_Second) {
	
		switch (direction) {
		case "UP":
			move(0,-movement);
			if(has_female_frog) {
				if(is_Second)
					setImage(imgFW1);
				else
					setImage(imgFW2);
			}
			else {
				if(is_Second)
					setImage(imgW1);
				else
					setImage(imgW2);
			}
			break;
			
		case "DOWN":
			move(0,movement);
			if(has_female_frog) {
				if(is_Second)
					setImage(imgFS1);
				else
					setImage(imgFS2);
			}
			else {
				if(is_Second)
					setImage(imgS1);
				else
					setImage(imgS2);
			}
			break;
			
		case "LEFT":
			move(-movementX,0);
			if(has_female_frog) {
				if(is_Second)
					setImage(imgFA1);
				else
					setImage(imgFA2);
			}
			else {
				if(is_Second)
					setImage(imgA1);
				else
					setImage(imgA2);
			}
			break;
			
		case "RIGHT":
			move(movementX,0);
			if(has_female_frog) {
				if(is_Second)
					setImage(imgFD1);
				else
					setImage(imgFD2);
			}
			else {
				if(is_Second)
					setImage(imgD1);
				else
					setImage(imgD2);
			}
			break;
			
		}

	}
	
	/** 
	 * reset the position of the frog actor
	 * */
	public void reset_position() {
		setX(300);
		setY(700);
		setImage(imgW1);
		has_female_frog = false;
	}
	
	
	/** 
	 * operation to run when the frog died
	 * 
	 * */
	public void death() {
		reset_position();
		carDeath = false;
		waterDeath = false;
		noMove = false;
		carD = 0;
		deduct_live = true;
	}
	
	@Override
	public void act(long now) {
		
		frogBound(now);
		deathAnimation(now);
		
	}
	
	/** 
	 * to detect whether the frog has accomplish the level
	 * @return whether frog has reached all five end position
	 * 
	 * */
	public boolean getStop() {
		return end==5;
	}
	
	/** 
	 *  control the death animation of the frog when it is dead
	 * 	@param the current time on timer 
	 * 
	 * */
	private void deathAnimation(long now) {
		
		if (carDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				carD++;
			}
			switch (carD) {
				case 1:
					setImage(new Image("file:src/main/resources/Image/Frog_sprite/death_Sprite/cardeath1.png", imgSize, imgSize, true, true));
					break;
				case 2:
					setImage(new Image("file:src/main/resources/Image/Frog_sprite/death_Sprite/cardeath2.png", imgSize, imgSize, true, true));
					break;
				case 3:
					setImage(new Image("file:src/main/resources/Image/Frog_sprite/death_Sprite/cardeath3.png", imgSize, imgSize, true, true));
					break;
				case 4:
					death();
					break;
			}
		}
		
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 == 0) {
				carD++;
			}
			switch (carD) {
			case 1:
				setImage(new Image("file:src/main/resources/Image/Frog_sprite/death_Sprite/waterdeath1.png", imgSize,imgSize , true, true));
				break;
			case 2:
				setImage(new Image("file:src/main/resources/Image/Frog_sprite/death_Sprite/waterdeath2.png", imgSize,imgSize , true, true));
				break;
			case 3:
				setImage(new Image("file:src/main/resources/Image/Frog_sprite/death_Sprite/waterdeath3.png", imgSize,imgSize , true, true));
				break;
			case 4:
				setImage(new Image("file:src/main/resources/Image/Frog_sprite/death_Sprite/waterdeath4.png", imgSize,imgSize , true, true));
				break;
			case 5:
				death();
				break;
			}
		}
		
	}
	
	/** 
	 *  make sure the frog is always bounded within the game pane
	 * 	@param the current time on timer 
	 * 
	 * */
	private void frogBound(long now) {
		
		if (getY()<0 || getY()>734) {
			reset_position();
		}
		
		if (getX()>560) {
			move(-movement*2, 0);
		}
		
		if (getX()<0) {
			move(movement*2, 0);
		}
		
	}
	
}
