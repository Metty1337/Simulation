package metty1337.simulation.environment;

import metty1337.simulation.Coordinates;

import java.util.Objects;

public abstract class Entity {
    public Coordinates coordinates;
    public abstract int getSpawnRate();
    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Entity() {
        this(null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;
        return Objects.equals(coordinates, entity.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinates);
    }
}
