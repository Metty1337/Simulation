package metty1337.simulation;

import metty1337.simulation.environment.EntityNavigator;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.creatures.Creature;

import java.util.List;

public class TurnMove extends Turn {
    private final Creature source;
    private final Entity target;
    private final static int SECOND_LAST_INDEX_OFFSET = 2;

    @Override
    public void execute(GameMap gameMap) {
        Coordinates sourceCoordinates = source.getCoordinates();
        Coordinates targetCoordinates = EntityNavigator.findClosestEntityCoordinates(sourceCoordinates, target, gameMap);
        List<Coordinates> path = PathFinder.getShortestPath(sourceCoordinates, targetCoordinates, gameMap);

        if (path.size() != 1) {
            gameMap.removeEntity(sourceCoordinates);
            int lastAvailableIndex = path.size() - SECOND_LAST_INDEX_OFFSET;

            int sourceSpeed = source.getSpeed();
            int stepsToMove = Math.min(lastAvailableIndex, sourceSpeed);

            source.setCoordinates(path.get(stepsToMove));
            gameMap.addEntity(source.getCoordinates(), source);
        }
    }

    public TurnMove(Creature source, Entity target) {
        this.source = source;
        this.target = target;
    }
}
