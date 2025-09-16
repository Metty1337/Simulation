package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public class Tree extends Entity {
    private static final String SPRITE = "\uD83C\uDF33";
    private static final int SPAWN_RATE = 2;


    public Tree() {
        super();
    }

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    @Override
    public int getSpawnRate() {
        return SPAWN_RATE;
    }
}
