package metty1337.simulation;

public class MoveCounter {
    private int counter;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public MoveCounter() {
        this.counter = 0;
    }

    @Override
    public String toString() {
        return "Count of moves: " + counter;
    }
}
