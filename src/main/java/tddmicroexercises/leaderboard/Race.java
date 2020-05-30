package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private static final Integer[] POINTS = new Integer[]{25, 18, 15};

    private final String name;
    private final List<IDriver> results;
    private final Map<IDriver, String> driverNames;

    public Race(String name, IDriver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);
        this.driverNames = new HashMap<>();
        for (IDriver driver : results) {
            String driverName = driver.getIdentity();
            this.driverNames.put(driver, driverName);
        }
    }

    public int position(IDriver driver) {
        return this.results.indexOf(driver);
    }

    public int getPoints(IDriver driver) {
        return Race.POINTS[position(driver)];
    }

    public List<IDriver> getResults() {
        return results;
    }

    public String getDriverName(IDriver driver) {
        return this.driverNames.get(driver);
    }

    @Override
    public String toString() {
        return name;
    }
}
