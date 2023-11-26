package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class GrassFieldTest {
    @Test
    void testIsOccupied() {
        GrassField grassField = new GrassField(10); // Tworzymy pole trawy

        // Umieszczamy trawę na mapie na konkretnej pozycji
        Vector2d grassPosition = new Vector2d(2, 3);
        Grass grass = new Grass(grassPosition);
        assertTrue(grassField.place(grass));

        // Sprawdzamy, czy pozycja, na której znajduje się trawa, jest zajęta
        assertTrue(grassField.isOccupied(grassPosition));

        // Sprawdzamy, czy pozycja, na której nie ma trawy, nie jest zajęta
        Vector2d nonOccupiedPosition = new Vector2d(0, 0);
        assertFalse(grassField.isOccupied(nonOccupiedPosition), "Position " + nonOccupiedPosition + " should be unoccupied");

        // Sprawdzamy, czy na pewno jest trawa na pozycji (2, 3)
        assertNotNull(grassField.objectAt(grassPosition), "Grass should be present at position " + grassPosition);
    }
}