import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import p4_group_8_repo.game_actor.Crocodile_river;

public class crocodileriverTest  extends ApplicationTest  {
	
	Pane test_pane = new Pane();
	Crocodile_river test_crocodileriver;
	
	@Override 
	public void start(Stage stage) {
		test_crocodileriver = new Crocodile_river(0, 250, 2);
		test_pane.getChildren().add(test_crocodileriver);
		Scene scene  = new Scene(test_pane,600,800);
		stage.setScene(scene);
		stage.show();
	}

	@Test
	public void mouth_open_test()  {
		test_crocodileriver.act(3600000000L);
		assertTrue(test_crocodileriver.isMouth_Open());
	}
	
	@Test
	public void get_position_test() {
		double test_crocodileriver_positionX = test_crocodileriver.getX();
		double test_crocodileriver_positionY = test_crocodileriver.getY();
		assertEquals((int)test_crocodileriver_positionX, 0);
		assertEquals((int)test_crocodileriver_positionY, 250);
	}

}
