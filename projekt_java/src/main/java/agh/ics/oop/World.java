package agh.ics.oop;
import agh.ics.oop.model.*;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("System started");

        List<MoveDirection> directions = OptionsParser.parse(args);

        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        //WorldMap worldMap = new RectangularMap(10, 10);
        GrassField grassField = new GrassField(10);


        WorldMap worldMap = grassField;


        Simulation simulation = new Simulation(positions, directions, worldMap);
        simulation.run();
        System.out.println("System ended");

    }

    public static void run(MoveDirection[] parsedArgs) {
        for (MoveDirection moveDirection : parsedArgs) {
            switch (moveDirection) {
                case FORWARD -> System.out.println("Animal is going forward");
                case BACKWARD -> System.out.println("Animal is going backward");
                case LEFT -> System.out.println("Animal is turning left");
                case RIGHT -> System.out.println("Animal is turning right");
            }
        }
    }
}