package metty1337.simulation;

public final class MoveCounterView {
    private MoveCounterView() {}

    public static void display(MoveCounter moveCounter) {
        System.out.println("Move counter: " + moveCounter.getCounter());
    }
}
