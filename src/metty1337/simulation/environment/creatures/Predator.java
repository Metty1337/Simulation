package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;

public class Predator extends Creature {
    private static final String SPRITE = "\uD83D\uDC05";

    public Predator() {
        super();
    }

    @Override
    public String getSprite(){
        return SPRITE;
    }
    public Predator(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }
}
