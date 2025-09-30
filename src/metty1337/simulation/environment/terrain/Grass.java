package metty1337.simulation.environment.terrain;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityConfig;

public class Grass extends Entity {
    private static final int SPAWN_RATE_VALUE = EntityConfig.GRASS_SPAWN_VALUE;

    public Grass() {
        super();
    }

    @Override
    public int getSpawnRateValue(){
        return SPAWN_RATE_VALUE;
    }

}
