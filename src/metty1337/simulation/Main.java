package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Herbivore;
import metty1337.simulation.environment.creatures.Predator;

import java.io.Reader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GameMap map = new GameMap();

        InitSpawnEntities.INSTANCE.execute(map);
        GameMapConsoleRenderer.render(map);

        Scanner scanner = new Scanner(System.in);

        var entities = map.getEntities();
//        for (Entity entity : entities.values()) {
//            if (entity instanceof Predator predator) {
//                int flag = 1;
//                while (flag != 0) {
//                    System.out.println(predator.getCoordinates());
//                    predator.makeMove(map);
//                    System.out.println(predator.getCoordinates());
//                    GameMapConsoleRenderer.render(map);
//                    flag = scanner.nextInt();
//                }
//                break;
//            }
//        }

        int a = 1;
        while(a != 0) {
            new TurnMoveAllCreatures().execute(map);
            GameMapConsoleRenderer.render(map);
            a = scanner.nextInt();
        }

    }
}