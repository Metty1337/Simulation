package metty1337.simulation.environment;

import metty1337.simulation.Coordinates;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private final Map<Coordinates, Entity> entities;

    public GameMap() {
        this.entities = new HashMap<>();
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        entities.put(coordinates, entity);
    }

    public boolean IsSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }
}
