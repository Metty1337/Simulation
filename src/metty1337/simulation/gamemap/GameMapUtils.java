package metty1337.simulation.gamemap;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class GameMapUtils {
    public static List<Coordinates> getAllPossibleTargetCoordinates(Entity target, GameMap gameMap) {
        List<Coordinates> allPossibleTargetCoordinates = new ArrayList<>();
        List<Entity> possibleTargets = new ArrayList<>(gameMap.getEntities().values());
        String nameOfTargetClass = target.getClass().getSimpleName();

        for (Entity possibleTarget : possibleTargets) {
            String targetClass = possibleTarget.getClass().getSimpleName();
            if (targetClass.equals(nameOfTargetClass)) {
                allPossibleTargetCoordinates.add(possibleTarget.getCoordinates());
            }
        }
        return allPossibleTargetCoordinates;
    }

    public static int getEntityCount(Entity target, GameMap gameMap) {
        Class<? extends Entity> targetClass = target.getClass();
        int count = 0;
        for (Entity possibleTarget : gameMap.getEntities().values()) {
            if (targetClass.equals(possibleTarget.getClass())) {
                count++;
            }
        }
        return count;
    }

    public static Coordinates getRandomCoordinates(GameMap gameMap) {
        Random random = new Random();
        int row = random.nextInt(gameMap.getHeight());
        int column = random.nextInt(gameMap.getWidth());
        return new Coordinates(row, column);
    }

    private GameMapUtils() {}
}
