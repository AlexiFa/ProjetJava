package Buildings;
import Person.Person;

public abstract class Building {
    protected String address;
    protected float livingSpace;
    protected Person owner;
    public Building(){

    }
    public Building(String address, float livingSpace, Person owner) {
        this.address = address;
        this.livingSpace = livingSpace;
        this.owner = owner;
    }
}
