package agh.ics.oop;
import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;


public class Simulation {
    private final WorldMap map;
    private final List<Animal> animals;
    private final List<MoveDirection> moves;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> moves, WorldMap worldMap) {
        this.moves = moves;
        this.map = worldMap;
        this.animals = createAnimals(initialPositions);
    }

    public List<Animal> createAnimals(List<Vector2d> initialPositions) {
        List<Animal> animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            map.place(new Animal(position));
            animals.add(new Animal(position));
        }
        return animals;
    }

    public void run() {
        int numAnimals = animals.size();
        int numMoves = moves.size();

        System.out.println(animals);

        for (int i=0; i < numMoves; i++) {
            Animal currentAnimal = animals.get(i % numAnimals);
            MoveDirection currentMove = moves.get(i);

           map.place(currentAnimal);
           map.move(currentAnimal, currentMove);
           map.place(currentAnimal);
           String mapRepresentation = map.toString();
            System.out.println(mapRepresentation);

    }
    }
}