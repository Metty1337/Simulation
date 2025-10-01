package metty1337.simulation.actions;

import metty1337.simulation.MissingEntitiesSpawner;
import metty1337.simulation.PopulationChecker;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Creature;

import java.util.List;

public class PopulationRestorer implements Action {

    @Override
    public void execute(GameMap gameMap) {
        List<Entity> edibleEntities = Creature.getEdibleEntities();
        for (Entity edibleEntity : edibleEntities) {
            if (PopulationChecker.shouldSpawnMore(edibleEntity, gameMap)) {
                MissingEntitiesSpawner.spawn(edibleEntity, gameMap);
            }
        }

    }
}
