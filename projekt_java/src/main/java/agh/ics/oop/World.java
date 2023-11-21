package agh.ics.oop;
import agh.ics.oop.model.*;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("System started");

        List<MoveDirection> directions = OptionsParser.parse(args);

        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        WorldMap map = new RectangularMap(10, 8);

        Animal animal1 = new Animal(new Vector2d(0, 0));
        Animal animal2 = new Animal(new Vector2d(5, 4));
        map.place(animal1);
        map.place(animal2);
        String mapRepresentation = map.toString();
        System.out.println(mapRepresentation);

        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

    }
}