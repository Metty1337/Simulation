package metty1337.simulation.environment.creatures;

import metty1337.simulation.Coordinates;
import metty1337.simulation.environment.Entity;

public abstract class Creature extends Entity {
    int speed;
    int hp;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }

    public Creature() {
        this(null, 0, 0);
    }

    void makeMove(){
        // должен делать ход как хз пока
    }
}
