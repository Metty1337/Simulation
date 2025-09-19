package metty1337.simulation.environment;

import metty1337.simulation.environment.creatures.Herbivore;
import metty1337.simulation.environment.creatures.Predator;
import metty1337.simulation.environment.terrain.Grass;
import metty1337.simulation.environment.terrain.Rock;
import metty1337.simulation.environment.terrain.Tree;

import java.util.function.Supplier;

public enum EntityType { //немного подсмотрел, сам бы не догадался до функциональных интерфейсов
    GRASS(Grass::new),
    ROCK(Rock::new),
    TREE(Tree::new),
    PREDATOR(Predator::new),
    HERBIVORE(Herbivore::new);

    private final Supplier<? extends Entity> constructor;

    EntityType(Supplier<? extends Entity> constructor) {
        this.constructor = constructor;
    }

    public Entity create() {
        return constructor.get();
    }
}
