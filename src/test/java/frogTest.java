import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import p4_group_8_repo.game_actor.Frog;

public class frogTest extends ApplicationTest {
	
	Pane test_pane = new Pane();
	Frog test_frog;
	
	
	@Override 
	public void start(Stage stage) {
		test_frog = new Frog();
		test_pane.getChildren().add(test_frog);
		Scene scene  = new Scene(test_pane,600,800);
		stage.setScene(scene);
		stage.show();
	}

	@Test
	public void reset_position_test() {
		test_frog.reset_position();
		double positionX = test_frog.getX();
		double positionY = test_frog.getY();
		assertEquals((int)positionX, 300);
		assertEquals((int)positionY, 700);
	}
	
	@Test
	public void move_position_UP_test() {
		test_frog.set_movement("UP", true);
		double positionX = test_frog.getX();
		double positionY = test_frog.getY();
		assertEquals((int)positionX, 300);
		assertEquals((int)positionY, 674);
	}
	
	@Test
	public void move_position_DOWN_test() {
		test_frog.set_movement("DOWN", true);
		double positionX = test_frog.getX();
		double positionY = test_frog.getY();
		assertEquals((int)positionX, 300);
		assertEquals((int)positionY, 726);
	}
	
	@Test
	public void move_position_LEFT_test() {
		test_frog.set_movement("LEFT", true);
		double positionX = test_frog.getX();
		double positionY = test_frog.getY();
		assertEquals((int)positionX, 280);
		assertEquals((int)positionY, 700);
	}
	
	@Test
	public void move_position_RIGHT_test() {
		test_frog.set_movement("RIGHT", true);
		double positionX = test_frog.getX();
		double positionY = test_frog.getY();
		assertEquals((int)positionX, 320);
		assertEquals((int)positionY, 700);
	}
	
	@Test
	public void frog_bound_test() {
		test_frog.setX(2000);
		test_frog.setY(2000);
		test_frog.act(0);
		double positionX = test_frog.getX();
		double positionY = test_frog.getY();
		assertEquals((int)positionX, 300);
		assertEquals((int)positionY, 700);
	}
	
	@Test
	public void frog_dead_test() {
		test_frog.waterDeath=true;
		test_frog.act(0);
		test_frog.act(0);
		test_frog.act(0);
		test_frog.act(0);
		test_frog.act(0);
		assertFalse(test_frog.waterDeath);
	}
	
	@Test
	public void frog_end_test() {
		test_frog.end = 5;
		assertTrue(test_frog.getStop());
	}

}
