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

    public void setDefaultMapApprentice() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {

            }
        }
    }
}
