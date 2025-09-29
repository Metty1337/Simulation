package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;

public final class PopulationChecker {
    public static boolean shouldSpawnMore(Entity target, GameMap gameMap) {
        int countOfTarget = gameMap.getEntityCount(target);
        return countOfTarget <= 1;
    }

    private PopulationChecker() {
    }
}
