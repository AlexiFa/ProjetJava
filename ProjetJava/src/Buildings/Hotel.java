package Buildings;
import Person.Person;

public class Hotel extends Building {
    int nbRoom;
    public Hotel(){
        super();
    }

    public Hotel(String address, float livingSpace, int nbRoom, Person owner) {
        super(address, livingSpace, owner);
        this.nbRoom = nbRoom;
    }
}
