package Buildings;
import Person.Person;

public class ApartmentBuilding extends Building {
    int nbApart;
    public ApartmentBuilding(){
        super();
    }
    public ApartmentBuilding(String address, float livingSpace, int nbApart, Person owner) {
        super(address, livingSpace, owner);
        this.nbApart = nbApart;
    }
}
