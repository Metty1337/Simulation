package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Herbivore;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GameMap map = new GameMap();

        InitSpawnEntities.INSTANCE.execute(map);
        GameMapConsoleRenderer.render(map);

        var entities = map.entities;
        System.out.println(entities);
        for (Entity entity : entities.values()) {
            if (entity instanceof Herbivore herbivore) {
                System.out.println(herbivore.getCoordinates());
                herbivore.makeMove(map);
                System.out.println(herbivore.getCoordinates());
                break;
            }
        }
        GameMapConsoleRenderer.render(map);

    }
}