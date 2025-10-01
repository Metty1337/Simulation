package metty1337.simulation;

public final class SpriteColorizer {
    public static String colorizeSprite(String sprite) {
        return SpriteCollection.SYMBOL_GREY_BACKGROUND + sprite + SpriteCollection.SYMBOL_RESET_BACKGROUND;
    }


    private SpriteColorizer() {}
}
