package metty1337.simulation;

import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.Entity;
public abstract class Turn implements Action {
    protected Entity entity;
    @Override
    public abstract void execute(GameMap gameMap);
}
