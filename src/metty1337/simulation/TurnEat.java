package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Creature;

public class TurnEat extends Turn {

    @Override
    public void execute(GameMap gameMap) {
        source.eat(target.getCoordinates(), gameMap);
    }


    public TurnEat(Creature source, Entity target) {
        super(source, target);
    }
}
