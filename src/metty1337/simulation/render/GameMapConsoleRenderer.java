package metty1337.simulation.render;

import metty1337.simulation.Coordinates;
import metty1337.simulation.gamemap.GameMap;

public class GameMapConsoleRenderer {
    public void render(GameMap gameMap) {
        for (int row = gameMap.getWidth(); row >= 0; row--) {
            for (int col = 0; col <= gameMap.getHeight(); col++) {
                Coordinates coordinates = new Coordinates(col, row);
                if (gameMap.isSquareEmpty(coordinates)) {
                    System.out.print(SpriteColorizer.colorizeSprite(SpriteCollection.SYMBOL_BLACK_SQUARE));
                } else {
                    System.out.print(SpriteColorizer.colorizeSprite(EntitySpriteFactory.getEntitySprite(gameMap.getEntity(coordinates))));
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public GameMapConsoleRenderer() {
    }

}
