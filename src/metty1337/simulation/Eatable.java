package metty1337.simulation;

import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.Entity;

public interface Eatable {
    void eat(Coordinates target, GameMap gameMap);

    Entity getFood();

    boolean canEat(Entity target);
}
