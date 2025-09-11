package metty1337.simulation.environment.terrain;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public class Tree extends Entity {
    private static final String SPRITE = "\uD83C\uDF33";

    public Tree() {
        super();
    }

    @Override
    public String getSprite(){
        return SPRITE;
    }
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }
}
