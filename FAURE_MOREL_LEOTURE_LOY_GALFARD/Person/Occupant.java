/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 */

package Person;
import Buildings.Building;

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
    public Occupant(String name, String surname){
        super(name, surname);
        noRoom = 0;
        rent = null;
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
        return super.toString() + (rent != null ? ": has rented the number "+ this.noRoom + " in " + this.rent.toString() : " has no rent");
    }
}