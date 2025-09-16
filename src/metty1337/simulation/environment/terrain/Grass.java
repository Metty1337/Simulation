package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public class Grass extends Entity {
    private static final String SPRITE = "\uD83E\uDD5C";
    private static final int SPAWN_RATE = 2;

    public Grass() {
        super();
    }

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getSprite(){
        return SPRITE;
    }

    @Override
    public int getSpawnRate(){
        return SPAWN_RATE;
    }
}
