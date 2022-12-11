package Person;
import Rental.Rental;

public class Occupant extends Person {
    Rental rental;
}
    public Occupant() {
    }
    public Occupant(String name, String surname, Rental rental) {
        super(name, surname);
        this.rental = rental;
    }