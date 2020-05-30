package tddmicroexercises.leaderboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tddmicroexercises.leaderboard.TestData.driver1;
import static tddmicroexercises.leaderboard.TestData.driver2;
import static tddmicroexercises.leaderboard.TestData.driver3;

public class LeaderboardTest {

    @Test
    public void itShouldSumThePoints() {
        // setup
        TestData.sampleLeaderboard1.assertScoreForDriver("Lewis Hamilton", 18+18+25);
    }

    @Test
    public void isShouldFindTheWinner() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard1.driverRankings();

        // verify
        assertEquals("Lewis Hamilton", result.get(0));
    }



    @Test
    public void isShouldFindTheWinnerFromLeaderBoardTwo() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard2.driverRankings();
        // verify
        assertEquals("Lewis Hamilton", result.get(0));
        assertEquals("Nico Rosberg", result.get(1));
        assertEquals("Self Driving Car - Acme (1.2)", result.get(2));
        assertEquals("Self Driving Car - Acme (1.3)", result.get(3));
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(driver1.getName(), driver2.getName(), driver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
