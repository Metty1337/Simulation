package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;

public class Predator extends Creature {
    private static final int SPAWN_RATE_VALUE = 1;


    public Predator() {
        super();
    }

    public Predator(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }

    @Override
    public int getSpawnRateValue() {
        return SPAWN_RATE_VALUE;
    }
}
