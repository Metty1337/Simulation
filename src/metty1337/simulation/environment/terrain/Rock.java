package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public class Rock extends Entity {
    private static final String SPRITE = "⛰\uFE0F";

    public Rock() {
        super();
    }

    @Override
    public String getSprite(){
        return SPRITE;
    }
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }
}
