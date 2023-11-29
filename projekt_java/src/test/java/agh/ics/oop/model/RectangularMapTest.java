package agh.ics.oop.model;

import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.model.util.MapVisualizer;
import org.junit.jupiter.api.Test;

class RectangularMapTest {
    @Test
    void canMoveToWithinBounds() {
        RectangularMap map = new RectangularMap(5, 5);
        assertTrue(map.canMoveTo(new Vector2d(2, 3)));
    }

    @Test
    void canMoveToOutsideBounds() {
        RectangularMap map = new RectangularMap(5, 5);
        assertFalse(map.canMoveTo(new Vector2d(6, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, 6)));
        assertFalse(map.canMoveTo(new Vector2d(-1, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, -1)));
    }

    @Test
    void placeAnimalWithinBounds() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 3));

        assertTrue(map.place(animal));
        assertEquals(animal, map.objectAt(new Vector2d(2, 3)));
    }

    @Test
    void placeAnimalOutsideBounds() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(6, 3));

        assertFalse(map.place(animal));
        assertNull(map.objectAt(new Vector2d(6, 3)));
    }

    @Test
    void moveAnimalWithinBounds() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 3));
        map.place(animal);

        map.move(animal, MoveDirection.FORWARD);

        assertEquals(new Vector2d(2, 4), animal.getPosition());
        assertEquals(animal, map.objectAt(new Vector2d(2, 4)));
    }

    @Test
    void moveAnimalOutsideBounds() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(4, 4));
        map.place(animal);

        map.move(animal, MoveDirection.FORWARD);

        assertEquals(new Vector2d(4, 5), animal.getPosition());
        assertEquals(animal, map.objectAt(new Vector2d(4, 5)));
    }

    @Test
    void isOccupiedByAnimal() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 3));
        map.place(animal);

        assertTrue(map.isOccupied(new Vector2d(2, 3)));
    }

    @Test
    void isNotOccupied() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        map.place(animal);

        assertFalse(map.isOccupied(new Vector2d(2, 3)));
    }

    @Test
    void toStringDrawsMap() {
        RectangularMap map = new RectangularMap(3, 3);
        map.place(new Animal(new Vector2d(1, 1)));

        MapVisualizer visualizer = new MapVisualizer(map);
        String expectedMap = visualizer.draw(new Vector2d(0, 0), new Vector2d(3, 3));

        assertEquals(expectedMap, map.toString());
    }

@Test
    void placeAnimal() {
        // Tworzymy mapę
        WorldMap worldMap = new RectangularMap(10, 10);

        // Umieszczamy zwierzę na mapie
        Animal animal = new Animal(new Vector2d(5, 5));
        assertTrue(worldMap.place(animal)); // Sprawdzamy, czy zwierzę zostało umieszczone na mapie

        // Sprawdzamy, czy próba ponownego umieszczenia tego samego zwierzęcia na tej samej pozycji zwraca false
        assertFalse(worldMap.place(animal));
    }


    @Test
    public void testMoveAnimal() {
        // Tworzymy mapę
        WorldMap worldMap = new RectangularMap(10, 10);

        // Umieszczamy zwierzę na mapie
        Animal animal = new Animal(new Vector2d(5, 5));
        worldMap.place(animal);

        // Próba poruszenia zwierzęcia na mapie
        worldMap.move(animal, MoveDirection.FORWARD);

        // Sprawdzamy, czy po ruchu pozycja zwierzęcia została zmieniona zgodnie z kierunkiem
        assertEquals(new Vector2d(5, 6), animal.getPosition());
    }

    @Test
    public void testIsOccupied() {
        // Tworzymy mapę
        WorldMap worldMap = new RectangularMap(10, 10);

        // Umieszczamy zwierzę na mapie
        Animal animal = new Animal(new Vector2d(5, 5));
        worldMap.place(animal);

        // Sprawdzamy, czy pozycja, na której jest zwierzę, jest zajęta
        assertTrue(worldMap.isOccupied(animal.getPosition()));

        // Sprawdzamy, czy pozycja poza obszarem, na którym jest zwierzę, nie jest zajęta
        assertFalse(worldMap.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    public void testObjectAt() {
        // Tworzymy mapę
        WorldMap worldMap = new RectangularMap(10, 10);

        // Umieszczamy zwierzę na mapie
        Animal animal = new Animal(new Vector2d(5, 5));
        worldMap.place(animal);

        // Sprawdzamy, czy obiekt zwracany na pozycji, gdzie jest zwierzę, faktycznie jest tym zwierzęciem
        assertEquals(animal, worldMap.objectAt(animal.getPosition()));

        // Sprawdzamy, czy obiekt na pozycji, gdzie nie ma zwierzęcia, zwraca null
        assertNull(worldMap.objectAt(new Vector2d(0, 0)));
    }
}