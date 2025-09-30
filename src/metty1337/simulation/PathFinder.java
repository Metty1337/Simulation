package metty1337.simulation;

import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Creature;

import java.util.*;

public final class PathFinder {
    private static final int STEP = 1;

    public static List<Coordinates> getShortestPath(Coordinates start, Coordinates end, GameMap gameMap) {
        Queue<Coordinates> queue = new LinkedList<>();
        Map<Coordinates, Coordinates> parent = new HashMap<>();
        Set<Coordinates> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(parent, start, end);
            }

            List<Coordinates> neighbors = getNeighbors(current, gameMap);

            for (Coordinates neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
         }

        return Collections.emptyList();
    }

    public static List<List<Coordinates>> getAllPathsToCoordinates(Coordinates sourceCoordinates, List<Coordinates> coordinates, GameMap gameMap) {
        List<List<Coordinates>> paths = new ArrayList<>();
        for (Coordinates targetCoordinates : coordinates) {
            List<Coordinates> path = getShortestPath(sourceCoordinates, targetCoordinates, gameMap);
            paths.add(path);
        }
        return paths;
    }

    public static List<Coordinates> selectShortestPath(List<List<Coordinates>> paths) {
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

    private static List<Coordinates> reconstructPath(Map<Coordinates, Coordinates> parent, Coordinates start, Coordinates end) {
        List<Coordinates> path = new ArrayList<>();
        for (Coordinates i = end; i != start; i = parent.get(i)) {
            path.add(i);
        }
        Collections.reverse(path);
        return path;
    }

    private static List<Coordinates> getNeighbors(Coordinates coordinates, GameMap gameMap) {
        List<Coordinates> neighbors = new ArrayList<>();
        List<Coordinates> possibleNeighbors = List.of(
                new Coordinates(coordinates.column(), coordinates.row() + STEP),
                new Coordinates(coordinates.column() + STEP, coordinates.row()),
                new Coordinates(coordinates.column(), coordinates.row() - STEP),
                new Coordinates(coordinates.column() - STEP, coordinates.row())
        );

        for (Coordinates neighbor : possibleNeighbors) {
            if (gameMap.isCoordinatesValid(neighbor)) {
                if (gameMap.isSquareEmpty(neighbor)) {
                    neighbors.add(neighbor);
                } else if (Creature.isEdible(gameMap.getEntity(neighbor))) {
                    neighbors.add(neighbor);
                }
            }
        }

        return neighbors;
    }

    private PathFinder() {
    }

}
