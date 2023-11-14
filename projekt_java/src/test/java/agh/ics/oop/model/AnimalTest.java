package agh.ics.oop.model;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {
    @Test
    public void isDefaultCorrect(){
        Animal animal = new Animal();
        assertEquals(new Vector2d(2, 2), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void isOrientationCorrect(){
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertEquals(new Vector2d(2, 2), animal.getPosition());
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    public void isMovingCorrect(){
        Animal animal = new Animal(); //domyslnie ma (2,2)

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3), animal.getPosition());

        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,2), animal.getPosition()); // (z 2,3 znizamy sie do 2,2)

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getOrientation());


        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void isGoingOutsideMapv1(){
        Animal animal = new Animal(new Vector2d(4, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 4), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    public void isGoingOutsideMapv2(){
        Animal animal = new Animal(new Vector2d(0, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(0, 0), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

}
