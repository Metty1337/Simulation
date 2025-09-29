package metty1337.simulation;

import metty1337.simulation.environment.GameMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    GameMap gameMap;
    MoveCounter moveCounter;
    GameMapConsoleRenderer gameMapConsoleRenderer;
    List<Action> initActions;
    List<Action> turnActions;

    public Simulation() {
        this.gameMap = new GameMap();
        this.moveCounter = new MoveCounter();
        this.gameMapConsoleRenderer = new GameMapConsoleRenderer();
        this.initActions = List.of(new InitSpawnEntities());
        this.turnActions = List.of(new PopulationRestorer(), new TurnMoveAllCreatures());
    }

    public void nextTurn() {
        if (gameMap.isGameMapEmpty()) {
            for (Action initAction : initActions) {
                initAction.execute(gameMap);
            }
        }

        for (Action turnAction : turnActions) {
            turnAction.execute(this.gameMap);
        }

        gameMapConsoleRenderer.render(gameMap);
    }

    public void startSimulation() {
        while (true) {
            nextTurn();
        }
    }
}