package agh.ics.oop.model;
import agh.ics.oop.model.Vector2d;

import java.security.cert.Extension;
//wyjatek typu checked to taki, ktory dziedziczy po klasie Exception -> wymaga oblugi za pomocą "throws"
public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(Vector2d position){
        super("Position" + position.toString() + "is already occupied");
    }
}
