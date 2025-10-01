package metty1337.simulation.gamemap;

import metty1337.simulation.Coordinates;
import metty1337.simulation.PathFinder;
import metty1337.simulation.environment.Entity;

import java.util.ArrayList;
import java.util.List;

public final class EntityNavigator {
    private EntityNavigator() {
    }

    public static Coordinates findClosestEntityCoordinates(Coordinates sourceCoordinates, Entity target, GameMap gameMap) {
        List<Coordinates> allPossibleTargetCoordinates = GameMapUtils.getAllPossibleTargetCoordinates(target, gameMap);
        List<List<Coordinates>> pathsToAllPossibleTargets = getAllPathsToCoordinates(sourceCoordinates, allPossibleTargetCoordinates, gameMap);

        List<Coordinates> closestPossibleTargetPath = selectShortestPath(pathsToAllPossibleTargets);

        if (closestPossibleTargetPath.isEmpty()) {
            return sourceCoordinates;
        }
        return closestPossibleTargetPath.getLast();
    }

    public static boolean isAtTarget(Coordinates sourceCoordinates, Coordinates targetCoordinates, GameMap gameMap) {
        List<Coordinates> path = PathFinder.getShortestPath(sourceCoordinates, targetCoordinates, gameMap);
        return path.size() == 1;
    }

    private static List<Coordinates> selectShortestPath(List<List<Coordinates>> paths) {
        int sizeCount = Integer.MAX_VALUE;
        List<Coordinates> closestPossibleTargetPath = new ArrayList<>();
        for (List<Coordinates> path : paths) {
            if (path.size() < sizeCount) {
                sizeCount = path.size();
                closestPossibleTargetPath = path;
            }
        }
        return closestPossibleTargetPath;
    }

    private static List<List<Coordinates>> getAllPathsToCoordinates(Coordinates sourceCoordinates, List<Coordinates> coordinates, GameMap gameMap) {
        List<List<Coordinates>> paths = new ArrayList<>();
        for (Coordinates targetCoordinates : coordinates) {
            List<Coordinates> path = PathFinder.getShortestPath(sourceCoordinates, targetCoordinates, gameMap);
            paths.add(path);
        }
        return paths;
    }
}
