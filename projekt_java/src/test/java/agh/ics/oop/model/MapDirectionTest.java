package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MapDirectionTest {
    @Test
    void testNext(){
        //given
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        //when
        MapDirection nextNorth = north.next();
        MapDirection nextEast = east.next();
        MapDirection nextSouth = south.next();
        MapDirection nextWest = west.next();

        //then
        assertEquals(MapDirection.EAST, nextNorth);
        assertEquals(MapDirection.SOUTH, nextEast);
        assertEquals(MapDirection.WEST, nextSouth);
        assertEquals(MapDirection.NORTH, nextWest);
    }


    @Test
    void testPrevious(){
        //given
        MapDirection north = MapDirection.NORTH;
        MapDirection east = MapDirection.EAST;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;


        //when
        MapDirection previousNorth = north.previous();
        MapDirection previousEast = east.previous();
        MapDirection previousSouth = south.previous();
        MapDirection previousWest = west.previous();


        //then
        assertEquals(MapDirection.WEST, previousNorth);
        assertEquals(MapDirection.NORTH, previousEast);
        assertEquals(MapDirection.EAST, previousSouth);
        assertEquals(MapDirection.SOUTH, previousWest);

    }


}
