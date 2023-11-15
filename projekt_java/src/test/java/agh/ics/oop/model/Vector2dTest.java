package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {
    @Test
    void vectorsCanBeAdded(){
        //given
        Vector2d vector1 = new Vector2d(3,5);
        Vector2d vector2 = new Vector2d(4,1);

        //when
        Vector2d vector3 = vector1.add(vector2);

        //then
        assertEquals(7, vector3.getX());
        assertEquals(6, vector3.getY());
    }


    @Test
    void vectorsCanBeSubstracted(){
        //given
        Vector2d vector1 = new Vector2d(3,5);
        Vector2d vector2 = new Vector2d(4,1);

        //when
        Vector2d vector3 = vector1.subtract(vector2);

        //then
        assertEquals(-1, vector3.getX());
        assertEquals(4, vector3.getY());
    }



    @Test
    void testEquals(){
        //given
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(1,2);
        Vector2d vector3 = new Vector2d(3,4);
        String str = "word";


        //when
        boolean result1 = vector1.equals(vector1);
        boolean result2 = vector1.equals(vector2);
        boolean result3 = vector1.equals(vector3);
        boolean result4 = vector1.equals(str);
        boolean result5 = vector1.equals(null);


        //then
        assertTrue(result1); //porownanie wektora z samym soba
        assertTrue(result2); // porownanie wektorow o tych samych wartosciach wspolrzednych
        assertFalse(result3); // porownanie roznych wektorow
        assertFalse(result4); // porownanie obiektow z roznych klas
        assertFalse(result5); // porownanie obiektow z null
    }



    @Test
    void testPrecedes(){
        //given
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(2,3);
        Vector2d vector3 = new Vector2d(1,2);
        Vector2d vector4 = new Vector2d(2,1);
        Vector2d vector5 = new Vector2d(0,3);

        //when
        boolean result1 = vector1.precedes(vector2);
        boolean result2 = vector2.precedes(vector1);
        boolean result3 = vector1.precedes(vector3);
        boolean result4 = vector1.precedes(vector4);
        boolean result5 = vector1.precedes(vector5);


        //then
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertFalse(result5);

    }

    @Test
    void testFollows(){
        //given
        Vector2d vector1 = new Vector2d(1,2);
        Vector2d vector2 = new Vector2d(2,3);
        Vector2d vector3 = new Vector2d(1,2);
        Vector2d vector4 = new Vector2d(2,1);
        Vector2d vector5 = new Vector2d(0,3);

        //when
        boolean result1 = vector1.follows(vector2);
        boolean result2 = vector2.follows(vector1);
        boolean result3 = vector1.follows(vector3);
        boolean result4 = vector1.follows(vector4);
        boolean result5 = vector1.follows(vector5);


        //then
        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertFalse(result4);
        assertFalse(result5);

    }



    @Test
    void testUpperRight(){
        //given
        Vector2d vector1 = new Vector2d(1,1);
        Vector2d vector2 = new Vector2d(2,2);

        //when
        Vector2d result = vector1.upperRight(vector2);

        //then
        assertEquals(2, result.getX());
        assertEquals(2, result.getY());
    }

    @Test
    void testLowerLeft(){
        //given
        Vector2d vector1 = new Vector2d(1,1);
        Vector2d vector2 = new Vector2d(2,2);

        //when
        Vector2d result = vector1.lowerLeft(vector2);

        //then
        assertEquals(1, result.getX());
        assertEquals(1, result.getY());
    }


    @Test
    void testOpposite(){
        //given
        Vector2d vector1 = new Vector2d(1,1);

        //when
        Vector2d result = vector1.opposite();

        //then
        assertEquals(-1, result.getX());
        assertEquals(-1, result.getY());
    }

    @Test
    void testToString(){
        Vector2d vector = new Vector2d(0,0);

        String result = vector.toString();

        assertEquals("(0,0)", result);

    }

    
}
