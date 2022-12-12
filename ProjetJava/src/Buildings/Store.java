/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Buildings;
import Instrument.Instrument; // because a store have a stock of instrument
import Person.Owner;
import java.util.ArrayList;

public class Store extends Building {
    ArrayList<Instrument> instruments;

    public Store(){
        // super() is called by default if we don't call any constructor from super (if there is a default constructor)
        instruments = new ArrayList<Instrument>();
    }

    public Store(String address, float livingSpace, Owner owner, ArrayList<Instrument> instruments) {
        super(address, livingSpace, owner);
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "Store{" +
                super.toString() +
                "instruments=" + instruments +
                '}';
    }
    //getters
    public ArrayList<Instrument> getInstruments(){
        return this.instruments;
    }
}
