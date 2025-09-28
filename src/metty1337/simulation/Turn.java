package metty1337.simulation;

import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.creatures.Creature;

public abstract class Turn implements Action {
    protected final Creature source;
    protected final Entity target;

    public Turn(Creature source, Entity target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public abstract void execute(GameMap gameMap);
}
