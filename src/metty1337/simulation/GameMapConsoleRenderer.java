package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.PropertiesStorage;

import java.util.Map;

import static metty1337.simulation.environment.GameMap.*;

public class GameMapConsoleRenderer {
    private static final String ANSI_GREY_BACKGROUND = "\u001B[48;5;240m";
    private static final String BLACK_SQUARE = "⬛";
    private static final String ANSI_RESET_BACKGROUND = "\u001B[0m";

    public static void render(GameMap gameMap) {
        Map<Coordinates, Entity> entities = gameMap.entities;
        for (int row = PropertiesStorage.SIZE_Y; row >= 0; row--) {
            for (int col = 0; col <= PropertiesStorage.SIZE_X; col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (gameMap.IsSquareEmpty(coordinates)) {
                    System.out.print(colorizeSprite(BLACK_SQUARE));
                } else {
                    System.out.print(colorizeSprite(getEntitySprite(gameMap.getEntity(coordinates))));
                }
            }
            System.out.println();
        }
    }

    private static String colorizeSprite(String sprite) {
        return ANSI_GREY_BACKGROUND + sprite + ANSI_RESET_BACKGROUND;
    }

}
