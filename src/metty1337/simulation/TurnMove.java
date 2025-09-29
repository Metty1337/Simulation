package metty1337.simulation;

import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.creatures.Creature;

import java.util.List;

public class TurnMove implements Action {
    private static final int SECOND_LAST_INDEX_OFFSET = 2;
    private static final int ZERO_INDEX_OFFSET = 1;
    private final Creature source;
    private final Entity target;

    public TurnMove(Creature source, Entity target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public void execute(GameMap gameMap) {
        Coordinates sourceCoordinates = source.getCoordinates();
        Coordinates targetCoordinates = EntityNavigator.findClosestEntityCoordinates(sourceCoordinates, target, gameMap);
        List<Coordinates> path = PathFinder.getShortestPath(sourceCoordinates, targetCoordinates, gameMap);

        if (path.size() > 1) {
            gameMap.removeEntity(sourceCoordinates);
            int lastAvailableIndex = path.size() - SECOND_LAST_INDEX_OFFSET;

            int sourceSpeed = source.getSpeed();
            int stepsToMove = Math.min(lastAvailableIndex, sourceSpeed - ZERO_INDEX_OFFSET);

            source.setCoordinates(path.get(stepsToMove));
            gameMap.addEntity(source.getCoordinates(), source);
        }
    }

}
