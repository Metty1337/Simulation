package metty1337.simulation.actions;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.gamemap.GameMap;
import metty1337.simulation.environment.creatures.Creature;

public class TurnEat implements Action {
    private final Creature source;
    private final Entity target;

    @Override
    public void execute(GameMap gameMap) {
        source.eat(target.getCoordinates(), gameMap);
    }

    public TurnEat(Creature source, Entity target) {
        this.source = source;
        this.target = target;
    }
}
