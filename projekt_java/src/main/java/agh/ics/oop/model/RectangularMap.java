package agh.ics.oop.model; //hashMap to pythonowski slownik

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {

    private final int width; //definiujemy prostokat, ktory ma szerokosc i wysokosc
    private final int height;
    private Map<Vector2d, Animal> animals = new HashMap<>();

    //konstruktor
    public RectangularMap(int width, int height){
        this.height = height;
        this.width = width;
    }

    @Override //dokad moze sie poruszac (prostokat)
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0))
                && position.precedes(new Vector2d(width, height))
                && !isOccupied(position);
    }

    @Override //uniemozliwienie wystepowania wiecej niz 1 zwierzecia na 1 pozycji
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(!canMoveTo(animalPosition) || isOccupied(animalPosition)){
            return false;
        }
            animals.put(animal.getPosition(), animal);

        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        animal.move(direction);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(width, height);
        return visualizer.draw(lowerLeft, upperRight);

    }
}
