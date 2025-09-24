package metty1337.simulation.environment.terrain;

import metty1337.simulation.Eatable;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;

public class Grass extends Entity {
    private static final int SPAWN_RATE_VALUE = 2;

    public Grass() {
        super();
    }

    @Override
    public int getSpawnRateValue(){
        return SPAWN_RATE_VALUE;
    }

}
