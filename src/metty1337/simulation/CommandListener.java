package metty1337.simulation;

import java.util.Scanner;

public class CommandListener implements Runnable {
    Simulation simulation;
    MessagePrinter printer;

    public CommandListener(Simulation simulation) {
        this.simulation = simulation;
        printer = new MessagePrinter();
    }

    @Override
    public void run() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String command = scanner.nextLine().toLowerCase();
            if (!simulation.isPaused()) {
                if (!command.isEmpty()) {
                    simulation.pauseSimulation();
                    printer.printMessage(UserMessages.COMMANDS);
                }
            } else if (command.equals("unpause")) {
                simulation.unpauseSimulation();
            } else if (command.equals("stop")) {
                simulation.stopSimulation();
                running = false;
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
        scanner.close();
    }
}
