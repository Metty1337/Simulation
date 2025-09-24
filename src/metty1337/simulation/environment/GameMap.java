package metty1337.simulation.environment;

import metty1337.simulation.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {
    public final Map<Coordinates, Entity> entities; //сделать private в будущем

    public GameMap() {
        this.entities = new HashMap<>();
    }

    public void addEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        entities.put(coordinates, entity);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        if (isCoordinatesValid(coordinates)) {
            return !entities.containsKey(coordinates);
        }
        return false;
    }

    public boolean isCoordinatesValid(Coordinates coordinates) {
        boolean isPositive = coordinates.column() >= 0 && coordinates.row() >= 0;
        boolean fitsSize = (coordinates.column() <= GameMapConfig.WIDTH) && (coordinates.row() <= GameMapConfig.HEIGHT);
        return isPositive && fitsSize;

    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public Map<Coordinates, Entity> getEntities() {
        return new HashMap<>(entities);
    }

    public List<Coordinates> getAllPossibleTargetCoordinates(Entity target) {
        List<Coordinates> allPossibleTargetCoordinates = new ArrayList<>();
        List<Entity> possibleTargets = new ArrayList<>(this.getEntities().values());
        String nameOfTargetClass = target.getClass().getSimpleName();

        for (Entity possibleTarget : possibleTargets) {
            String targetClass = possibleTarget.getClass().getSimpleName();
            if (targetClass.equals(nameOfTargetClass)) {
                allPossibleTargetCoordinates.add(possibleTarget.getCoordinates());
            }
        }
        return allPossibleTargetCoordinates;
    }

    public boolean isEntityExist(Coordinates coordinates) {
        return entities.containsKey(coordinates);
    }
}
