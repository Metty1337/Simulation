package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public class Rock extends Entity {
    private static final int SPAWN_RATE = 3;

    public Rock() {
        super();
    }

    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public int getSpawnRate() {
        return SPAWN_RATE;
    }
}
