package metty1337.simulation.environment;

import metty1337.simulation.Coordinates;
import metty1337.simulation.config.GameMapConfig;

import java.util.*;

public class GameMap {
    private final Map<Coordinates, Entity> entities;
    private final int height;
    private final int width;

    public GameMap() {
        this.entities = new HashMap<>();
        this.height = GameMapConfig.HEIGHT;
        this.width = GameMapConfig.WIDTH;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addEntity(Coordinates coordinates, Entity entity) {
        if (isCoordinatesValid(coordinates)) {
            entity.setCoordinates(coordinates);
            entities.put(coordinates, entity);
        } else {
            throw new IllegalArgumentException(coordinates + " is not valid");
        }
    }

    public boolean isGameMapEmpty() {
        return entities.isEmpty();
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        if (isCoordinatesValid(coordinates)) {
            return !entities.containsKey(coordinates);
        }
        return false;
    }

    public static boolean isCoordinatesValid(Coordinates coordinates) {
        boolean isPositive = coordinates.column() >= 0 && coordinates.row() >= 0;
        boolean fitsSize = (coordinates.column() <= GameMapConfig.WIDTH) && (coordinates.row() <= GameMapConfig.HEIGHT);
        return isPositive && fitsSize;

    }

    public Entity getEntity(Coordinates coordinates) {
        if (isCoordinatesValid(coordinates)) {
            return entities.get(coordinates);
        } else {
            throw new IllegalArgumentException(coordinates + " is not valid");
        }
    }

    public void removeEntity(Coordinates coordinates) {
        if (isCoordinatesValid(coordinates)) {
            entities.remove(coordinates);
        } else {
            throw new IllegalArgumentException(coordinates + " is not valid");
        }

    }

    public Map<Coordinates, Entity> getEntities() {
        return Collections.unmodifiableMap(entities);
    }

}
