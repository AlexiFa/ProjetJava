package Person;
import Buildings.Building;

public class Owner extends Person{
    Building building;
    public Owner() {
    }
    public Owner(String name, String surname, Building building) {
        super(name, surname);
        this.building = building;
    }
}