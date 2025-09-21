package metty1337.simulation;

import metty1337.simulation.environment.GameMap;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GameMap map = new GameMap();
        InitSpawnEntities.INSTANCE.execute(map);
        GameMapConsoleRenderer.render(map);

        Scanner scanner = new Scanner(System.in);
        System.out.println("x1:");
        int x1 = scanner.nextInt();
        System.out.println("y1:");
        int y1 = scanner.nextInt();

        System.out.println("x2:");
        int x2 = scanner.nextInt();
        System.out.println("y2:");
        int y2 = scanner.nextInt();

        Coordinates start = new Coordinates(x1, y1);
        Coordinates end = new Coordinates(x2, y2);

        System.out.println(PathFinder.getShortestPath(start, end, map));

    }
}