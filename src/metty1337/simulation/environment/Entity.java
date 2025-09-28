package metty1337.simulation.environment;

import metty1337.simulation.Coordinates;

import java.util.Objects;

public abstract class Entity {
    private Coordinates coordinates;

    public abstract int getSpawnRateValue();

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Entity() {
        this(null);
    }

    public Coordinates getCoordinates() {
        return new Coordinates(coordinates.column(), coordinates.row());
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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
