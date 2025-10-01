package metty1337.simulation.actions;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TurnMoveAllCreatures implements Action {

    @Override
    public void execute(GameMap gameMap) {
        Map<Coordinates, Entity> map = gameMap.getEntities();
        List<Entity> snapshot = new ArrayList<>(map.values());
        for (Entity entity: snapshot) {
            if (entity instanceof Creature creature) {
                creature.makeMove(gameMap);
            }
        }
    }

    public TurnMoveAllCreatures() {
    }
}
