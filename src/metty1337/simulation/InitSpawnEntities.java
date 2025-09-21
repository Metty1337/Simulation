package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityType;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.GameMapConfig;

import java.util.Random;

public final class InitSpawnEntities extends Init {
    private static final int ENTITY_SPAWN_RATE_VALUE = 2;
    private static final int TOTAL_PROBABILITY = 10;
    private static final Random rand = new Random();
    public static final InitSpawnEntities INSTANCE = new InitSpawnEntities();

    @Override
    public void execute(GameMap gameMap) {
        for (int row = 0; row <= GameMapConfig.WIDTH; row++) {
            for (int col = 0; col <= GameMapConfig.HEIGHT; col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (gameMap.IsSquareEmpty(coordinates)) {
                    Entity entity = EntityOrEmptySpawner();
                    if (entity != null) {
                        entity.setCoordinates(coordinates);
                        gameMap.setEntity(coordinates, entity);
                    }
                }
            }
        }
    }

    private InitSpawnEntities() {
    }

    private static Entity EntityOrEmptySpawner() {
        if (!wouldSquareBeEmpty()) {
            int roll = rand.nextInt(sumOfSpawnRateOfAllEntities());

            Entity chosen = null;
            int sum = 0;

            for (EntityType entityType : EntityType.values()) {
                sum += entityType.create().getSpawnRateValue();
                if (roll < sum) {
                    chosen = entityType.create();
                    break;
                }
            }
            return chosen;
        } else {
            return null;
        }

    }

    private static boolean wouldSquareBeEmpty() {
        return !(rand.nextInt(TOTAL_PROBABILITY) < ENTITY_SPAWN_RATE_VALUE);
    }

    private static int sumOfSpawnRateOfAllEntities() {
        int sum = 0;
        for (EntityType e : EntityType.values()) {
            sum += e.create().getSpawnRateValue();
        }
        return sum;
    }
}
