package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Herbivore;
import metty1337.simulation.environment.creatures.Predator;
import metty1337.simulation.environment.terrain.Grass;
import metty1337.simulation.environment.terrain.Rock;
import metty1337.simulation.environment.terrain.Tree;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static int wcwidth(int codePoint) {
        // C0/C1 control chars
        if (codePoint == 0) return 0;
        if (codePoint < 32 || (codePoint >= 0x7f && codePoint < 0xa0)) return -1;

        // Диапазоны "широких" символов (CJK, эмодзи, блоки)
        if (codePoint >= 0x1100 && (
                codePoint <= 0x115f || // Hangul Jamo
                        codePoint == 0x2329 || codePoint == 0x232a ||
                        (codePoint >= 0x2e80 && codePoint <= 0xa4cf && codePoint != 0x303f) || // CJK
                        (codePoint >= 0xac00 && codePoint <= 0xd7a3) || // Hangul Syllables
                        (codePoint >= 0xf900 && codePoint <= 0xfaff) || // CJK Compatibility
                        (codePoint >= 0xfe10 && codePoint <= 0xfe19) || // Vertical forms
                        (codePoint >= 0xfe30 && codePoint <= 0xfe6f) || // CJK compatibility forms
                        (codePoint >= 0xff00 && codePoint <= 0xff60) || // Fullwidth forms
                        (codePoint >= 0x1f300 && codePoint <= 0x1f64f) || // Emoticons
                        (codePoint >= 0x1f900 && codePoint <= 0x1f9ff))) // Supplemental Symbols
        {
            return 2;
        }

        return 1;
    }

    public static void main(String[] args) {

        Entity tree = new Tree();
        Entity rock = new Rock();
        Entity herbivore = new Herbivore();
        Entity predator = new Predator();
        Entity grass = new Grass();


//        System.out.println(tree.getSprite());
//        System.out.println(rock.getSprite());
//        System.out.println(herbivore.getSprite());
//        System.out.println(predator.getSprite());
//        System.out.println(grass.getSprite());



        GameMap map = new GameMap();
        InitSpawnEntities.INSTANCE.execute(map);
        GameMapConsoleRenderer.render(map);
        String[] test = {"\uD83D\uDD32", "\uD83D\uDC3A", "🐇", "\uD83E\uDD55", "\uD83C\uDF33", "\uD83D\uDDFB", "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66"};
        for (String s : test) {
            int cp = s.codePointCount(0, s.length());
            System.out.println(s + "->" + cp);
        }


    }
}