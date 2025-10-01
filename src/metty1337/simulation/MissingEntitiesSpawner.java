package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityType;
import metty1337.simulation.environment.GameMap;

public final class MissingEntitiesSpawner {
    private static final int LIMIT_TO_ADDITIONAL_SPAWN = 5;

    public static void spawn(Entity target, GameMap gameMap) {
        int toAdd = LIMIT_TO_ADDITIONAL_SPAWN;

        while (toAdd > 0) {
            Coordinates coordinates = GameMapUtils.getRandomCoordinates(gameMap);
            if (gameMap.isSquareEmpty(coordinates)) {
                String targetClassName = target.getClass().getSimpleName().toUpperCase();
                EntityType targetType = EntityType.valueOf(targetClassName);
                Entity targetEntity = targetType.create();
                targetEntity.setCoordinates(coordinates);
                gameMap.addEntity(coordinates, targetEntity);
                toAdd--;
            }
        }

    }

    private MissingEntitiesSpawner() {
    }
}
