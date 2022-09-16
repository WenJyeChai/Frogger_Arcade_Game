import static org.junit.Assert.*;
import org.junit.Test;
import p4_group_8_repo.User;

public class userTest {

	User test_player = new User(100,"test");

	@Test
	public void get_name_test() {
		String test_name = test_player.getName();
		assertEquals(test_name, "test");
	}
	
	@Test
	public void set_score_test() {
		test_player.setScore(80);
		int test_score = test_player.getScore();
		assertEquals(test_score, 180);
	}
	
	@Test
	public void set_lives_test() {
		test_player.setLives(1);
		int test_lives = test_player.getLives();
		assertEquals(test_lives, 1);
	}
	
	@Test
	public void reset_lives_test() {
		test_player.resetLives();
		int test_lives = test_player.getLives();
		assertEquals(test_lives, 5);
	}
	
	@Test
	public void reset_score_test() {
		test_player.resetScore();
		int test_score= test_player.getScore();
		assertEquals(test_score, 0);
	}

}
