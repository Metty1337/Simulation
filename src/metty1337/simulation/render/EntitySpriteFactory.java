package metty1337.simulation.render;

import metty1337.simulation.environment.Entity;

public class EntitySpriteFactory {
    public static String getEntitySprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Predator" -> SpriteCollection.SYMBOL_PREDATOR;
            case "Herbivore" -> SpriteCollection.SYMBOL_HERBIVORE;
            case "Grass" -> SpriteCollection.SYMBOL_GRASS;
            case "Tree" -> SpriteCollection.SYMBOL_TREE;
            case "Rock" -> SpriteCollection.SYMBOL_ROCK;
            default -> throw new IllegalArgumentException("Unknown entity type: " + entity.getClass().getSimpleName());
        };
    }
}
