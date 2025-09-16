package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityType;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.PropertiesStorage;

import java.util.Map;
import java.util.Random;

import static metty1337.simulation.environment.GameMap.getEntitySprite;

public class InitSpawnEntities extends Init {
    private static final int PROBABILITY_TO_SPAWN_ENTITY = 3;
    private static final int TOTAL_PROBABILITY = 10;
    private static final Random rand = new Random();

    public static final InitSpawnEntities INSTANCE = new InitSpawnEntities();

    public void execute(GameMap gameMap) {
        Map<Coordinates, Entity> entities = gameMap.entities;
        for (int row = 0; row <= PropertiesStorage.SIZE_Y; row++) {
            for (int col = 0; col <= PropertiesStorage.SIZE_X; col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (gameMap.IsSquareEmpty(coordinates)) {
                    Entity e = EntityOrEmptySpawner();
                    if (e != null) {
                        e.coordinates = coordinates;
                        entities.put(coordinates, e);
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

            for (EntityType e : EntityType.values()) {
                sum += e.create().getSpawnRate();
                if (roll < sum) {
                    chosen = e.create();
                    break;
                }
            }
            return chosen;
        } else {
            return null;
        }

    }

    private static boolean wouldSquareBeEmpty() {
        return !(rand.nextInt(TOTAL_PROBABILITY) < PROBABILITY_TO_SPAWN_ENTITY);
    }

    private static int sumOfSpawnRateOfAllEntities() {
        int sum = 0;
        for (EntityType e : EntityType.values()) {
            sum += e.create().getSpawnRate();
        }
        return sum;
    }
}
