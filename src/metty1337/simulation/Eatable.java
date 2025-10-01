package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.gamemap.GameMap;

public interface Eatable {
    void eat(Coordinates target, GameMap gameMap);

    Entity getFood();

    boolean canEat(Entity target);
}
