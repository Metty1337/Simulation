package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public class Tree extends Entity {
    private static final int SPAWN_RATE_VALUE = 2;


    public Tree() {
        super();
    }

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public int getSpawnRateValue() {
        return SPAWN_RATE_VALUE;
    }
}
