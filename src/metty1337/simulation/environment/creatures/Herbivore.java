package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;

public class Herbivore extends Creature {
    private static final String SPRITE = "\uD83D\uDC16";

    public Herbivore() {
        super();
    }

    @Override
    public String getSprite(){
        return SPRITE;
    }
    public Herbivore(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }
}
