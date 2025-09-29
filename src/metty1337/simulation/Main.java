package metty1337.simulation;

import metty1337.simulation.environment.Entity;
import metty1337.simulation.environment.EntityType;
import metty1337.simulation.environment.GameMap;
import metty1337.simulation.environment.creatures.Herbivore;
import metty1337.simulation.environment.creatures.Predator;

import java.io.Reader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation();
        sim.startSimulation();
    }
}