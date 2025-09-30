package metty1337.simulation;

public class Launcher {
    public void launch() {
        Simulation sim = new Simulation();
        CommandListener commandListener = new CommandListener(sim);
        Thread CommandListenerThread = new Thread(commandListener, "CommandListener");
        sim.startSimulation();
        CommandListenerThread.start();
    }

    public Launcher() {
    }
}
