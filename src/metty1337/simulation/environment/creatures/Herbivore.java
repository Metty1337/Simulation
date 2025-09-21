package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;

public class Herbivore extends Creature {
    private static final int SPAWN_RATE_VALUE = 1;

    public Herbivore() {
        super();
    }

    public Herbivore(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }



    @Override
    public int getSpawnRateValue(){
        return SPAWN_RATE_VALUE;
    }

}
