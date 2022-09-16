import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import p4_group_8_repo.game_actor.Log;

public class logTest extends ApplicationTest  {
	
	Pane test_pane = new Pane();
	Log test_log;
	
	
	@Override 
	public void start(Stage stage) {
		test_log = new Log(0, 200, 5, "medium_log");
		test_pane.getChildren().add(test_log);
		Scene scene  = new Scene(test_pane,600,800);
		stage.setScene(scene);
		stage.show();
	}

	@Test
	public void get_speed_test() {
		double test_log_speed = test_log.getSpeed();
		assertEquals((int)test_log_speed, 5);
	}
	
	@Test
	public void get_size_test() {
		double test_log_speed = test_log.get_Size();
		assertEquals((int)test_log_speed, 160);
	}
	
	@Test
	public void get_position_test() {
		double test_log_positionX = test_log.getX();
		double test_log_positionY = test_log.getY();
		assertEquals((int)test_log_positionX, 0);
		assertEquals((int)test_log_positionY, 200);
	}

}
