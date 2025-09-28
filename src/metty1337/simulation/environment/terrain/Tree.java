package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityConfig;

public class Tree extends Entity {
    private static final int SPAWN_RATE_VALUE = EntityConfig.TREE_SPAWN_VALUE;


    public Tree() {
        this(null);
    }

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public int getSpawnRateValue() {
        return SPAWN_RATE_VALUE;
    }
}
