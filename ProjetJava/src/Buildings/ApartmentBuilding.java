package Buildings;
import Person.Owner;

public class ApartmentBuilding extends Building {
    int nbApart;

    public ApartmentBuilding() {
    }

    public ApartmentBuilding(String address, float livingSpace, int nbApart, Owner owner) {
        super(address, livingSpace, owner);
        this.nbApart = nbApart;
    }
}
