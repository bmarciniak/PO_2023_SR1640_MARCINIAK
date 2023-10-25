package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];
        for (int i = 0; i < args.length; i++) {
            if ("f".equals(args[i])) {
                directions[i] = MoveDirection.FORWARD;
            } else if ("b".equals(args[i])) {
                directions[i] = MoveDirection.BACKWARD;
            } else if ("r".equals(args[i])) {
                directions[i] = MoveDirection.RIGHT;
            } else if ("l".equals(args[i])) {
                directions[i] = MoveDirection.LEFT;
            } else {
                // Ignorujemy nieznane argumenty
            }
        }
        return directions;
    }
}

