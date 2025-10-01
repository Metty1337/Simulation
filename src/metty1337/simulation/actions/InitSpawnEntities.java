package metty1337.simulation.actions;

import metty1337.simulation.Coordinates;
import metty1337.simulation.SpawnManager;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;

public class InitSpawnEntities implements Action {

    @Override
    public void execute(GameMap gameMap) {
        for (int row = 0; row <= gameMap.getWidth(); row++) {
            for (int col = 0; col <= gameMap.getHeight(); col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (gameMap.isSquareEmpty(coordinates)) {
                    Entity entity = SpawnManager.entityOrEmptySpawner();
                    if (entity != null) {
                        entity.setCoordinates(coordinates);
                        gameMap.addEntity(coordinates, entity);
                    }
                }
            }
        }
    }

    public InitSpawnEntities() {
    }

}
