package agh.ics.oop.model;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.Collection;
import java.util.*;

public class GrassField extends AbstractWorldMap {
   // private final Map<Vector2d, Animal> animals = new HashMap<>();

private final List<Grass> grassFields = new ArrayList<>();
private final int width;
private final int height;



    public GrassField(int grassCount){
        this.width = (int) Math.sqrt(grassCount*10);
        this.height = (int) Math.sqrt(grassCount*10);
        addGrass(grassCount);
}

public Collection<WorldElement> getElements(){
        List<WorldElement> elements = new ArrayList<>();
        elements.addAll(animals.values());
        elements.addAll(grassFields);
        return elements;
}

private void addGrass(int grassCount){
        Random random = new Random();
        for (int i=0; i<grassCount; i++){
            Vector2d position = generateRandomPosition(random);
            while (isOccupied(position)){
                position = generateRandomPosition(random);
            }
            Grass grass = new Grass(position);
            grassFields.add(grass);
        }
}

private Vector2d generateRandomPosition(Random random){
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        return new Vector2d(x,y);
}

    @Override
    public boolean place(Animal animal) {
        return false;
    }
    public boolean place(Grass grass) {
        Vector2d grassPosition = grass.getPosition();
        if (!isOccupied(grassPosition)) {
            grassFields.add(grass);
            System.out.println("Dodano trawę na pozycji: " + grassPosition);
            return true;
        } else {
            System.out.println("Pozycja jest zajęta: " + grassPosition);
            return false;
        }
    }
    @Override
    public void move(Animal animal, MoveDirection direction) {
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        //WorldElement element = super.objectAt(position);

        //Grass grass = null;
        for (Grass g : grassFields) {
            if (g.getPosition().equals(position)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Grass grass : grassFields) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    //metodę String toString(), która rysuje fragment mapy, na którym znajdują się wszystkie elementy (zwierzęta oraz trawa)
    @Override
    public String toString() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Animal animal : animals.values()) {
            Vector2d position = animal.getPosition();
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }

        for (Grass grass : grassFields) {
            Vector2d position = grass.getPosition();
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }

        Vector2d lowerLeft = new Vector2d(minX, minY);
        Vector2d upperRight = new Vector2d(maxX, maxY);
        MapVisualizer visualizer = new MapVisualizer(this);

        return visualizer.draw(lowerLeft, upperRight);
    }
}
