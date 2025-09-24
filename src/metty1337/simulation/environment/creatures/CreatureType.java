package metty1337.simulation.environment.creatures;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.terrain.Grass;
import metty1337.simulation.environment.terrain.Rock;
import metty1337.simulation.environment.terrain.Tree;

import java.util.function.Supplier;

public enum CreatureType {
    PREDATOR(Predator::new),
    HERBIVORE(Herbivore::new);

    private final Supplier<? extends Creature> constructor;

    CreatureType(Supplier<? extends Creature> constructor) {
        this.constructor = constructor;
    }

    public Creature create() {
        return constructor.get();
    }
}
