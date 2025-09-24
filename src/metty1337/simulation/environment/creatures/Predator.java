package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;
import metty1337.simulation.Eatable;
import metty1337.simulation.TurnMove;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityType;
import metty1337.simulation.environment.GameMap;

public class Predator extends Creature implements Eatable {
    private static final int SPAWN_RATE_VALUE = 1;
    private static final int speed = 2;

    public Predator() {
        super();
    }

    @Override
    public void makeMove(GameMap gameMap) {
        new TurnMove(this, this.getFood()).execute(gameMap);
    }
    @Override
    public int getSpeed(){
        return speed;
    }

    @Override
    public int getSpawnRateValue() {
        return SPAWN_RATE_VALUE;
    }

    @Override
    public void eat(GameMap gameMap) {

    }

    @Override
    public Entity getFood() {
        return EntityType.HERBIVORE.create();
    }

    @Override
    public boolean canEat(Entity target) {
        Entity food = this.getFood();
        return target.getClass().equals(food.getClass());
    }
}

