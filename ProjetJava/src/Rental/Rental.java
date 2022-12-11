/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Rental;
import Buildings.Building;
import Person.Occupant;

public class Rental {
    Building rent;
    Occupant occupant;
    int noRoom;
    public Rental(){}
    public Rental(Building rent, Occupant occupant, int noRoom) {
        this.rent = rent;
        this.occupant = occupant;
        this.noRoom = noRoom;
    }

    public void setOccupant(Occupant occupant) {
        if (this.occupant == null){
            this.occupant = occupant;
            occupant.setRental(this);
        }
        else
            System.out.println("error, there is already someone in this rental");
    }
    public void stopRental(){
        this.occupant.setRental(null);
    }
}
