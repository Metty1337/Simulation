package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;
import metty1337.simulation.Eatable;
import metty1337.simulation.config.CreatureConfig;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.config.EntityConfig;
import metty1337.simulation.environment.EntityType;
import metty1337.simulation.gamemap.GameMap;

public class Predator extends Creature implements Eatable {
    private static final int SPAWN_RATE_VALUE = EntityConfig.PREDATOR_SPAWN_VALUE;
    private static final int speed = CreatureConfig.PREDATOR_SPEED;
    private static final int damage = CreatureConfig.PREDATOR_DAMAGE;

    public Predator() {
        super();
        setHp(CreatureConfig.PREDATOR_HP);
    }

    public int getDamage(){
        return damage;
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
        Entity meal = gameMap.getEntity(target);
        if (meal instanceof Creature creature) {
            creature.setHp(creature.getHp() - this.getDamage());

            if (creature.getHp() <= 0) {
                gameMap.removeEntity(target);
            }
        }
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

