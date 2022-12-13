/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;
import Buildings.Building;
import Rental.Rental;

public class Occupant extends Person {
    Rental rental;
    Building rent;
    int noRoom;
    public Occupant() {
        super();
        this.rental = null;
    }
    public Occupant(String name, String surname, Rental rental) {
        super(name, surname);
        this.rental = rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
    public Rental getRental(){
        return this.rental;
    }

    public Building getRent() {
        return rent;
    }

    public void setRent(Building rent) {
        this.rent = rent;
    }

    public int getNoRoom() {
        return noRoom;
    }

    public void setNoRoom(int noRoom) {
        this.noRoom = noRoom;
    }

    @Override
    public String toString() {
        return super.toString() +
                ": has rented " + rental.getRent().toString();
    }
}