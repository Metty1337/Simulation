package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.GameMapConfig;

public final class GameMapConsoleRenderer {
    private static final String SYMBOL_GREY_BACKGROUND = "\u001B[48;5;240m";
    private static final String SYMBOL_BLACK_SQUARE = "⬛";
    private static final String SYMBOL_RESET_BACKGROUND = "\u001B[0m";
    private static final String SYMBOL_PREDATOR = "\uD83D\uDC3A";
    private static final String SYMBOL_HERBIVORE = "🐇";
    private static final String SYMBOL_GRASS = "\uD83C\uDF3D";
    private static final String SYMBOL_TREE = "\uD83D\uDFE9";
    private static final String SYMBOL_ROCK = "\uD83D\uDFEB";


    public static void render(GameMap gameMap) {
        for (int row = gameMap.getWidth(); row >= 0; row--) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col <= gameMap.getHeight(); col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (gameMap.isSquareEmpty(coordinates)) {
                    line.append(colorizeSprite(SYMBOL_BLACK_SQUARE));
                } else {
                    line.append(colorizeSprite(getEntitySprite(gameMap.getEntity(coordinates))));
                }
            }
            System.out.println(line);
        }
        System.out.println();
    }

    private static String getEntitySprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Predator" -> SYMBOL_PREDATOR;
            case "Herbivore" -> SYMBOL_HERBIVORE;
            case "Grass" -> SYMBOL_GRASS;
            case "Tree" -> SYMBOL_TREE;
            case "Rock" -> SYMBOL_ROCK;
            default -> throw new IllegalArgumentException("Unknown entity type: " + entity.getClass().getSimpleName());
        };
    }

    private static String colorizeSprite(String sprite) {
        return SYMBOL_GREY_BACKGROUND + sprite + SYMBOL_RESET_BACKGROUND;
    }

    private GameMapConsoleRenderer() {
    }

}
