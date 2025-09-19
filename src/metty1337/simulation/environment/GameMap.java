package metty1337.simulation.environment;

import metty1337.simulation.Coordinates;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    public Map<Coordinates, Entity> entities;

    public GameMap(Map<Coordinates, Entity> entities) {
        entities = new HashMap<>();
        this.entities = entities;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public boolean IsSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }
}
