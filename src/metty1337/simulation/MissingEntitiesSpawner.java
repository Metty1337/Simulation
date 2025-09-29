package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityType;
import metty1337.simulation.environment.GameMap;

public final class MissingEntitiesSpawner {
    private static final int LIMIT_TO_ADDITIONAL_SPAWN = 5;

    public static void spawn(Entity target, GameMap gameMap) {
        int toAdd = LIMIT_TO_ADDITIONAL_SPAWN;

        for (int row = 0; row <= gameMap.getWidth(); row++) {
            for (int col = 0; col <= gameMap.getHeight(); col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (gameMap.isSquareEmpty(coordinates)) {
                    if (!SpawnManager.wouldSquareBeEmpty()) {
                        if (toAdd > 0) {
                            String targetClassName = target.getClass().getSimpleName().toUpperCase();
                            EntityType targetType = EntityType.valueOf(targetClassName);
                            Entity targetEntity = targetType.create();
                            targetEntity.setCoordinates(coordinates);
                            gameMap.addEntity(coordinates, targetEntity);
                            toAdd--;
                        } else {
                            return;
                        }

                    }
                }
            }
        }

    }

    private MissingEntitiesSpawner() {
    }
}
