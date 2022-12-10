package Buildings;
import Person.Person;
public class House extends Building {
    int nbPart;
    float gardenArea;
    public House(){
    }
    public House(String address, float livingSpace, int nbPart, float gardenArea, Person owner) {
        super(address, livingSpace, owner);
        this.nbPart = nbPart;
        this.gardenArea = gardenArea;
    }
}
