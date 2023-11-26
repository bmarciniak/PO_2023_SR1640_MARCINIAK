package agh.ics.oop;
import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final WorldMap map;
    private final List<Animal> animals;
    private final List<MoveDirection> moves;
   // private final GrassField grassField;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap map) {
       // this.grassField = grassField;
        this.animals = new ArrayList<>();
        this.moves = moves;
        this.map = map;
        createAnimals(positions);
    }

    private void createAnimals(List<Vector2d> positions) {
        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            animals.add(animal);
            map.place(animal);
        }
    }

    public void run() {
        int numAnimals = animals.size();
        int numMoves = moves.size();
        for (int index=0; index < numMoves; index++) {
            MoveDirection currentMove = moves.get(index);
            int animalIndex = index % numAnimals;
            Animal currentAnimal = animals.get(animalIndex);


            map.move(currentAnimal, currentMove);
            System.out.println(map);

    }
    }
}