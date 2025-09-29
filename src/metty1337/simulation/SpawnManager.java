package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityType;

import java.util.Random;

public final class SpawnManager {
    private static final int ENTITY_SPAWN_RATE_VALUE = 2;
    private static final int TOTAL_PROBABILITY = 10;
    private static final Random rand = new Random();

    public static Entity entityOrEmptySpawner() {
        if (!wouldSquareBeEmpty()) {
            int roll = rand.nextInt(sumOfSpawnRateOfAllTypesOfEntity());

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
        }
        return null;
    }

    public static boolean wouldSquareBeEmpty() {
        return !(rand.nextInt(TOTAL_PROBABILITY) < ENTITY_SPAWN_RATE_VALUE);
    }

    private static int sumOfSpawnRateOfAllTypesOfEntity() {
        int sum = 0;
        for (EntityType e : EntityType.values()) {
            sum += e.create().getSpawnRateValue();
        }
        return sum;
    }

    private SpawnManager() {}
}
