package metty1337.simulation;

import metty1337.simulation.environment.GameMap;

public class MapConsoleRenderer {
    private static final String BACKGROUND = "\u001B[40m";
    private static final String BLACK_SQUARE = "⬛";
    private static final String RESET_BACKGROUND = "\u001B[0m";

    public static void render(GameMap gameMap) {
        var entities = gameMap.entities;
        for (int row = 15; row >= 0; row--) {
            for (int col = 0; col <= 15; col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (entities.containsKey(coordinates)) {
                    System.out.printf("%s%s%s", BACKGROUND, entities.get(coordinates).getSprite(), RESET_BACKGROUND);
                } else {
                    System.out.printf("%s%s%s", BACKGROUND, BLACK_SQUARE, RESET_BACKGROUND);
                }
            }
            System.out.println();
        }
    }
}
