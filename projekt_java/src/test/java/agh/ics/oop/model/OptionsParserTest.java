package agh.ics.oop.model;
import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


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
}
