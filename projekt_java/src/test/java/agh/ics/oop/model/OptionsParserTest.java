package agh.ics.oop.model;
import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class OptionsParserTest {
    @Test
    void testOptionsParser(){
        //given
        String[] args = {"f", "b", "l", "r", "x"};

        //when
        List<MoveDirection> directions = OptionsParser.parse(args);
        //then

        assertEquals(4, directions.size());
        assertEquals(MoveDirection.FORWARD, directions.get(0));
        assertEquals(MoveDirection.BACKWARD, directions.get(1));
        assertEquals(MoveDirection.LEFT, directions.get(2));
        assertEquals(MoveDirection.RIGHT, directions.get(3));
    }
    @Test
    void isIllegalArgumentExceptionWorks(){
        String[] invalidArgs = {"f", "b", "l", "r", "r", "x"};

        assertThrows(IllegalArgumentException.class, () -> {
            OptionsParser.parse(invalidArgs);
        });
    }
}
