package Buildings;
import Instrument.Instrument; // because a store have a stock of instrument
import Person.Person;
import java.util.ArrayList;

public class Store extends Building {
    ArrayList<Instrument> instruments;

    public Store(){
        super();
        instruments = new ArrayList<Instrument>();
    }
}
