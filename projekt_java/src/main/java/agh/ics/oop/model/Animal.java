package agh.ics.oop.model;

import java.util.Vector;

public class Animal {
    private MapDirection orientation; //atrybut okreslajacy obecna orientacje
    private Vector2d position; //atrybut okreslajacy polozenie


    // definiuje zakres obsaru, poza ktory nie mozna wyjsc:
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final Vector2d upperRight = new Vector2d(4,4);

//konstruktor domyslny
    public Animal(){
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;

    }


    //konstruktor przyjmujacy i ustawiajacy pozycje podana z zewnatrz
    public Animal(Vector2d initialPosition){
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH; //orientacja poczatkowa
    }

    @Override
    public String toString(){
        return "Position: " + position + "Orientation: " + orientation;
    }
    //tutaj nie trzeba definiowac posistion i orientation jako string, poniewaz Vector2d oraz
    // MapDirection zawieraja metody toString() - jest to automatycznie dostarczane dla kazdej klasy w Javie

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
        //wtedy zwraca true!
    }


    public Vector2d getPosition(){
        return position;
    }
    public MapDirection getOrientation() {
        return orientation;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if (newPosition.follows(lowerLeft) && newPosition.precedes(upperRight)){
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(orientation.toUnitVector());
                if (newPosition.follows(lowerLeft) && newPosition.precedes(upperRight)){
                    position = newPosition;
                }
            }

        }
    }





}