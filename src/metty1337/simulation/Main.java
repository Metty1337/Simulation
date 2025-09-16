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


        Map<Coordinates, Entity> entities = new HashMap<>();

        GameMap map = new GameMap(entities);
        InitSpawnEntities.INSTANCE.execute(map);
        GameMapConsoleRenderer.render(map);



    }
}