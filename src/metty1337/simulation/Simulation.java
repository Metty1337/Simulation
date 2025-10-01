package metty1337.simulation;

import metty1337.simulation.actions.Action;
import metty1337.simulation.actions.InitSpawnEntities;
import metty1337.simulation.actions.PopulationRestorer;
import metty1337.simulation.actions.TurnMoveAllCreatures;
import metty1337.simulation.gamemap.GameMap;
import metty1337.simulation.render.GameMapConsoleRenderer;

import java.util.List;

public class Simulation implements Runnable {
    private static final int TIME_TO_PAUSE = 800;
    private volatile boolean running = true;
    private volatile boolean paused = false;
    GameMap gameMap;
    MoveCounter moveCounter;
    MessagePrinter printer;
    GameMapConsoleRenderer gameMapConsoleRenderer;
    List<Action> initActions;
    List<Action> turnActions;

    public Simulation() {
        this.gameMap = new GameMap();
        this.moveCounter = new MoveCounter();
        this.printer = new MessagePrinter();
        this.gameMapConsoleRenderer = new GameMapConsoleRenderer();
        this.initActions = List.of(new InitSpawnEntities());
        this.turnActions = List.of(new PopulationRestorer(), new TurnMoveAllCreatures());
    }

    public void nextTurn() {
        moveCounter.increment();
        if (gameMap.isGameMapEmpty()) {
            for (Action initAction : initActions) {
                initAction.execute(gameMap);
            }
        }

        for (Action turnAction : turnActions) {
            turnAction.execute(this.gameMap);
        }

        gameMapConsoleRenderer.render(gameMap);
        MoveCounterView.display(moveCounter);
        printer.printMessage(UserMessages.ENTER_ANYTHING);

    }

    public boolean isPaused() {
        return paused;
    }
    public void startSimulation() {
        Thread simulationThread = new Thread(this, "SimulationThread");
        simulationThread.start();
    }

    public void pauseSimulation() {
        paused = true;
    }

    public void unpauseSimulation() {
        paused = false;
    }

    public void stopSimulation() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            while (!paused) {
                nextTurn();
                try {
                    Thread.sleep(TIME_TO_PAUSE);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        printer.printMessage(UserMessages.EXIT);
    }
}