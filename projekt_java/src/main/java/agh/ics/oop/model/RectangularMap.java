package agh.ics.oop.model; //hashMap to pythonowski slownik

import agh.ics.oop.model.util.MapVisualizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    private final int width; //definiujemy prostokat, ktory ma szerokosc i wysokosc
    private final int height;
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    //konstruktor
    public RectangularMap(int width, int height){
        this.height = height;
        this.width = width;
    }

    @Override
    public Collection<WorldElement> getElements(){
        List<WorldElement> elements = new ArrayList<>(animals.values());
        return elements;
    }

    @Override //dokad moze sie poruszac (prostokat)
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0))
                && position.precedes(new Vector2d(width, height));
    }


    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(animals.containsKey(animal.getPosition())){
            Vector2d oldPosition = animal.getPosition();
            MoveValidator validator = this;
            animal.move(direction, validator);
            Vector2d newPosition = animal.getPosition();

            if(!oldPosition.equals(newPosition) && canMoveTo(newPosition) && !isOccupied(newPosition)){
                animals.remove(oldPosition);
                animals.put(newPosition, animal);
            }
        }
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        return null;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public boolean place(Grass grass) {
        return false;
    }
    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position) && !isOccupied(position)) {
            animals.put(position, animal);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(width, height);
        return visualizer.draw(lowerLeft, upperRight);
    }


}