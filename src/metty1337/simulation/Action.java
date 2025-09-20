package metty1337.simulation;

import metty1337.simulation.environment.GameMap;

public interface Action {
    void execute(GameMap gameMap);
}
