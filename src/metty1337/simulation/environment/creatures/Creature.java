package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;
import metty1337.simulation.Eatable;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;

public abstract class Creature extends Entity implements Eatable {
    private int speed;
    private int hp;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }

    public abstract void makeMove(GameMap gameMap);

    public Creature() {
        this(null, 0, 0);
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public abstract void eat(GameMap gameMap);

    @Override
    public abstract boolean canEat(Entity target);


    public static boolean isEdible(Entity target) {
        for (CreatureType creature : CreatureType.values()){
            if (creature.create().canEat(target)){
                return true;
            }
        }
        return false;
    }
}
