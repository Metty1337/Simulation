package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;
import metty1337.simulation.Eatable;
import metty1337.simulation.actions.TurnEat;
import metty1337.simulation.actions.TurnMove;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.EntityNavigator;
import metty1337.simulation.environment.GameMap;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature extends Entity implements Eatable {
    private int hp;

    public void makeMove(GameMap gameMap) {
        if (isAlive()) {
            Coordinates targetCoordinates = EntityNavigator.findClosestEntityCoordinates(this.getCoordinates(), this.getFood(), gameMap);
            if (!targetCoordinates.equals(this.getCoordinates())) {
                if (EntityNavigator.isAtTarget(this.getCoordinates(), targetCoordinates, gameMap)) {
                    new TurnEat(this, gameMap.getEntity(targetCoordinates)).execute(gameMap);
                } else {
                    new TurnMove(this, this.getFood()).execute(gameMap);
                }
            }
        }
    }

    public static boolean isEdible(Entity target) {
        for (CreatureType creature : CreatureType.values()) {
            if (creature.create().canEat(target)) {
                return true;
            }
        }
        return false;
    }

    public static List<Entity> getEdibleEntities() {
        List<Entity> edibleEntities = new ArrayList<>();

        for (CreatureType creature : CreatureType.values()) {
            edibleEntities.add(creature.create().getFood());
        }

        return edibleEntities;
    }

    @Override
    public abstract void eat(Coordinates target, GameMap gameMap);

    @Override
    public abstract boolean canEat(Entity target);

    public abstract int getSpeed();

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Creature() {
        this(null, 0);
    }

    private Creature(Coordinates coordinates, int hp) {
        super(coordinates);
        this.hp = hp;
    }
}
