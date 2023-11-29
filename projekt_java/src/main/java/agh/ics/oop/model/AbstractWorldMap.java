package agh.ics.oop.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap{
    protected  Map<Vector2d, Animal> animals = new HashMap<>();
    private final List<Grass> grassFields = new ArrayList<>();


    @Override
    public boolean isOccupied(Vector2d position) {
       // return animals.containsKey(position);
        return false;
    }


    @Override
    public abstract WorldElement objectAt(Vector2d position);

    @Override
    public abstract boolean place(Animal animal);

    @Override
    public boolean place(Grass grass) {
        return false;
    }
}
