package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;
import metty1337.simulation.Eatable;
import metty1337.simulation.TurnEat;
import metty1337.simulation.TurnMove;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.EntityNavigator;
import metty1337.simulation.environment.GameMap;

public abstract class Creature extends Entity implements Eatable {
    private int hp;

    public abstract int getSpeed();

    private Creature(Coordinates coordinates, int hp) {
        super(coordinates);
        this.hp = hp;
    }

    public void makeMove(GameMap gameMap) {
        if (isAlive()) {
            Coordinates targetCoordinates = EntityNavigator.findClosestEntityCoordinates(this.getCoordinates(), this.getFood(), gameMap);

            if (EntityNavigator.isAtTarget(this.getCoordinates(), targetCoordinates, gameMap)) {
                new TurnEat(this, gameMap.getEntity(targetCoordinates)).execute(gameMap);
            } else {
                new TurnMove(this, this.getFood()).execute(gameMap);
            }
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public Creature() {
        this(null, 0);
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public abstract void eat(Coordinates target, GameMap gameMap);

    @Override
    public abstract boolean canEat(Entity target);


    public static boolean isEdible(Entity target) {
        for (CreatureType creature : CreatureType.values()) {
            if (creature.create().canEat(target)) {
                return true;
            }
        }
        return false;
    }
}
