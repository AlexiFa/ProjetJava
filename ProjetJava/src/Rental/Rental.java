package Rental;
import Buildings.Building;
import Person.Occupant;

public class Rental {
    Building rent;
    Occupant occupant;
    int noRoom;

    public Rental(Building rent, Occupant occupant, int noRoom) {
        this.rent = rent;
        this.occupant = occupant;
        this.noRoom = noRoom;
    }
}
