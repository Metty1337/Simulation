package metty1337.simulation.environment.terrain;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityConfig;

public class Rock extends Entity {
    private static final int SPAWN_RATE_VALUE = EntityConfig.ROCK_SPAWN_VALUE;

    public Rock() {
        super();
    }

    @Override
    public int getSpawnRateValue() {
        return SPAWN_RATE_VALUE;
    }
}
