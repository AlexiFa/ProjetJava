import java.util.ArrayList;

public class Store extends Building {
    ArrayList<Instrument> instruments;
    Person owner; // we can put it in building directly

    public Store(){
        super();
        instruments = new ArrayList<Instrument>();
    }
    public Store(Person owner){
        super();
        instruments = new ArrayList<Instrument>();
        this.owner = owner;
    }

}
