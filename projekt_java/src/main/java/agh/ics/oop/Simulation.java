package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.ArrayList;

import java.util.List;


public class Simulation {
    private List<Animal> animals;
    private List<MoveDirection> directions;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> directions) {
        this.animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            this.animals.add(new Animal(position));
        }
        this.directions = directions;
    }

    public List<Animal> getAnimals() {
        return animals;
    }


    public void run() {
        int numAnimals = animals.size();
        int currentAnimalIndex = 0;

        for (MoveDirection direction : directions) {
            Animal currentAnimal = animals.get(currentAnimalIndex);
            currentAnimal.move(direction);

            // Wyświetlanie informacji o ruchu
            System.out.println("Animal " + currentAnimalIndex + ": " + currentAnimal.toString());

            // Przełączanie na kolejne zwierzę
            currentAnimalIndex = (currentAnimalIndex + 1) % numAnimals;
        }
    }
}

