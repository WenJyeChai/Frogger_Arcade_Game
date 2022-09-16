import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import p4_group_8_repo.controller.Leaderboard_Controller;

public class scoreboardTest {

Map<String, Integer> unsorted_leaderboard = Leaderboard_Controller.read_score_from_file();
	
	@Test
	public void readScore_test() {
		
		int test = unsorted_leaderboard.get("Frankie");
		assertEquals(test, 80);
	}
	
	@Test
	public void readtopScore_test() {
		
		List<Integer> unsorted_leaderboard_score = new ArrayList<>(unsorted_leaderboard.values());
		Map<String, Integer> sorted_leaderboard = Leaderboard_Controller.sortByValue(unsorted_leaderboard);
		Collections.sort(unsorted_leaderboard_score, Collections.reverseOrder());
		int a = sorted_leaderboard.get(sorted_leaderboard.keySet().toArray()[0]);
		int test = unsorted_leaderboard_score.get(0);
		assertEquals(test, a);
		
	}
}
