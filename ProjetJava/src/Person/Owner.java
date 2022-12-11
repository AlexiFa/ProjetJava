package Person;

public class Owner {
    Batiment batiment;
    public Owner() {
    }
    public Owner(String name, String surname, Batiment batiment) {
        super(name, surname);
        this batiment= batiment;
    }