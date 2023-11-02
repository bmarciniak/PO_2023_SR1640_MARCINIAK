package agh.ics.oop.model;
import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;


//konstruktor:
    public Vector2d(int x, int y){
        this.x=x; //this wskazuje na ten konkretny obiekt (cos typu referencja) - chodzi nam o tego x z atrybutu!
        this.y=y;
    }


    public int getX(){ //funkcja
        return x;
    }
    public int getY(){
        return y;
    }

    public String toString(){
    return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }
    public Vector2d add(Vector2d other){
       int newX = this.x + other.x;
       int newY = this.y + other.y;
       return new Vector2d(newX, newY);
    }
    public Vector2d substract(Vector2d other){
        int newX = this.x - other.x;
        int newY = this.y - other.y;
        return new Vector2d(newX, newY);
    }
    public Vector2d upperRight(Vector2d other){
        int upperRightX = Math.max(this.x, other.x);
        int upperRightY = Math.max(this.y, other.y);
        return new Vector2d(upperRightX, upperRightY);
    }
    public Vector2d lowerLeft(Vector2d other){
        int lowerLeftX = Math.min(this.x, other.x);
        int lowerLeftY = Math.min(this.y, other.y);
        return new Vector2d(lowerLeftX, lowerLeftY);
    }
    public Vector2d opposite(){
        int oppositeX = -this.x;
        int oppositeY = -this.y;
        return new Vector2d(oppositeX, oppositeY);
    }
    public boolean equals(Object other){
        if(this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return x == that.x && y == that.y; //uwzgledniam porownanie skladowych obiektow
    }
    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

}
