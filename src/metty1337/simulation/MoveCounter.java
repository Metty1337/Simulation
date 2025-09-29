package metty1337.simulation;

public class MoveCounter {
    private int counter;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }

    public MoveCounter() {
        this.counter = 0;
    }
}
