package Buildings;
import Person.Person;

public class Hotel extends Building {
    int nbStars;
    int nbRoom;
    int nbSpa; // only for 4 stars hotel (else = 0)
    int nbPool; // only for 5 stars hotel (else = 0)
    int nbSuite; // idem for 5 stars
    public Hotel(){
    }
    public Hotel(int stars){
        nbStars = stars;
        switch (nbStars){
            case 1 : nb
        }
    }
    public Hotel(String address, float livingSpace, int nbRoom, Person owner) {
        super(address, livingSpace, owner);
        this.nbRoom = nbRoom;
    }
}
