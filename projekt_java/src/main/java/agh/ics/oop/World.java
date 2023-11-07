package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args) {
        System.out.println("System started");
        MoveDirection[] directions = OptionsParser.parse(args);
        run(directions);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        // sprawdzam czy metody z MapDirection dzialaja prawidlowo:
        MapDirection currentDirection = MapDirection.EAST;

        // metoda toString
        System.out.println(currentDirection.toString());

        // metoda next
        MapDirection nextDirection = currentDirection.next();
        System.out.println(nextDirection.toString());

        // metoda previous
        MapDirection previousDirection = currentDirection.previous();
        System.out.println(previousDirection.toString());

        // metoda toUnitVector
        Vector2d unitVector = currentDirection.toUnitVector();
        System.out.println(unitVector);


        System.out.println("System finished");
    }
    public static void run(MoveDirection[] directions){
        for(MoveDirection direction : directions) {
            switch(direction) {
                case FORWARD -> System.out.println("szop is moving forward");
                case BACKWARD -> System.out.println("szop is moving backward");
                case RIGHT -> System.out.println("szop is turning right");
                case LEFT -> System.out.println("szop is turning left");
                default -> { throw new IllegalStateException("Unexpected value: "+ direction);}
            }
        }
    }
}
