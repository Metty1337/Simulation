package metty1337.simulation.environment.creatures;

import metty1337.simulation.*;
import metty1337.simulation.environment.*;
import metty1337.simulation.environment.terrain.Grass;

public class Herbivore extends Creature implements Eatable {
    private static final int SPAWN_RATE_VALUE = EntityConfig.HERBIVORE_SPAWN_VALUE;
    private static final int speed = CreatureConfig.HERBIVORE_SPEED;

    public Herbivore() {
        super();
        setHp(CreatureConfig.HERBIVORE_HP);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getSpawnRateValue() {
        return SPAWN_RATE_VALUE;
    }

    @Override
    public void eat(Coordinates target, GameMap gameMap) {
        gameMap.removeEntity(target);
    }

    @Override
    public Entity getFood() {
        return EntityType.GRASS.create();
    }

    @Override
    public boolean canEat(Entity target) {
        Entity food = this.getFood();
        return target.getClass().equals(food.getClass());
    }
}
