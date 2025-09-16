package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;

public class Herbivore extends Creature {
    private static final String SPRITE = "\uD83D\uDC16";
    private static final int SPAWN_RATE = 1;

    public Herbivore() {
        super();
    }

    public Herbivore(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
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
