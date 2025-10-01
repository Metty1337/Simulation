package metty1337.simulation;

public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        CommandListener commandListener = new CommandListener(sim);
        Thread CommandListenerThread = new Thread(commandListener, "CommandListener");
        sim.startSimulation();
        CommandListenerThread.start();
    }
}