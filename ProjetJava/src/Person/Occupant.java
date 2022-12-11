/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;
import Rental.Rental;

public class Occupant extends Person {
    Rental rental;
    public Occupant() {
        this.rental = null;
    }
    public Occupant(String name, String surname, Rental rental) {
        super(name, surname);
        this.rental = rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}