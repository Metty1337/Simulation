package metty1337.simulation;

import metty1337.simulation.environment.GameMap;

public abstract class Init implements Action {
    public abstract void execute(GameMap gameMap);
}
