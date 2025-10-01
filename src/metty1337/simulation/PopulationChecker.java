package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.gamemap.GameMap;
import metty1337.simulation.gamemap.GameMapUtils;

public final class PopulationChecker {
    public static boolean shouldSpawnMore(Entity target, GameMap gameMap) {
        int countOfTarget = GameMapUtils.getEntityCount(target, gameMap);
        return countOfTarget <= 1;
    }

    private PopulationChecker() {
    }
}
