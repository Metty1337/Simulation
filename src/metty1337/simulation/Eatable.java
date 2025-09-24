package metty1337.simulation;

import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.Entity;
public interface Eatable {
    public void eat(GameMap gameMap);

    public Entity getFood();

    public boolean canEat(Entity target);
}
