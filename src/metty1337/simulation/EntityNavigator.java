package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;

import java.util.List;

public final class EntityNavigator {
    private EntityNavigator() {
    }

    public static Coordinates findClosestEntityCoordinates(Coordinates sourceCoordinates, Entity target, GameMap gameMap) {
        List<Coordinates> allPossibleTargetCoordinates = gameMap.getAllPossibleTargetCoordinates(target);
        List<List<Coordinates>> pathsToAllPossibleTargets = PathFinder.getAllPathsToCoordinates(sourceCoordinates, allPossibleTargetCoordinates, gameMap);

        List<Coordinates> closestPossibleTargetPath = PathFinder.selectShortestPath(pathsToAllPossibleTargets);

        if (closestPossibleTargetPath.isEmpty()) {
            return sourceCoordinates;
        }
        return closestPossibleTargetPath.getLast();
    }

    public static boolean isAtTarget(Coordinates sourceCoordinates, Coordinates targetCoordinates, GameMap gameMap) {
        List<Coordinates> path = PathFinder.getShortestPath(sourceCoordinates, targetCoordinates, gameMap);
        return path.size() == 1;
    }
}
