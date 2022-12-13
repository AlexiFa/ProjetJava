/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;
import Buildings.Building;
import Rental.Rental;

import java.util.HashMap;

public class Occupant extends Person {
//    Rental rental;
    Building rent;
    int noRoom;
    public Occupant() {
        super();
        this.rent = null;
    }
    public Occupant(String name, String surname, Building rent, int noRoom) {
        super(name, surname);
        this.rent = rent;
        this.noRoom = noRoom;
    }

//    public void setRental(Rental rental) {
//        this.rental = rental;
//    }
//    public Rental getRental(){
//        return this.rental;
//    }

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
                ": has rented " + this.rent.toString();
    }
}