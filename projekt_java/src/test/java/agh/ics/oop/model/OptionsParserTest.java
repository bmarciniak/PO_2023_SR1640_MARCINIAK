package agh.ics.oop.model;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {
    @Test
    void testOptionsParser(){
        //given
        String[] args = {"f", "b", "l", "r", "x"};

        //when
        MoveDirection[] directions = OptionsParser.parse(args);
        //then
        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT, null}, directions);
        assertNull(directions[4]);
    }
}
