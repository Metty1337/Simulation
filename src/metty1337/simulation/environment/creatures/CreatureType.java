package metty1337.simulation.environment.creatures;

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
