package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void testGrassField() {
        GrassField grassField = new GrassField(10);

        assertEquals(10, grassField.getGrass().size());

        Animal animal2 = new Animal(new Vector2d(3, 4));
        // Spróbuj umieścić zwierzę na polu trawy, ale nie oczekuj wyjątku
        assertTrue(grassField.place(animal2));

        // Pozostała część testu bez zmian
        Vector2d grassPosition = grassField.getGrass().get(0).getPosition();
        assertEquals(grassField.getGrass().get(0), grassField.objectAt(grassPosition));
        assertNotNull(grassField.toString());
    }
}