package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public class Grass extends Entity {
    private static final String SPRITE = "\uD83E\uDD5C";

    public Grass() {
        super();
    }

    @Override
    public String getSprite(){
        return SPRITE;
    }

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }
}
