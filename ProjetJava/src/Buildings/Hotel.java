package Buildings;
import Person.Owner;

public class Hotel extends Building {
    int nbStars;
    int nbRoom;
    int nbSpa; // only for 4 stars hotel (else = 0)
    int nbPool; // only for 5 or 4 stars hotel (else = 0)
    int nbSuite; // idem for 5 stars

    public Hotel() {
    }

    public Hotel(int stars){ // create hotel with default values
        nbStars = stars;
        nbSpa = 0;
        nbPool = 0;
        nbSuite = 0;
        switch (nbStars){
            case 1 : nbRoom = 10;
            case 2 : nbRoom = 15;
            case 3 : nbRoom = 20;
            case 4 : // nbSpa will be set after the constructor in the main
                nbPool = 1;
                nbRoom = 25;
            case 5 :
                nbRoom = 30;
            default:
                System.out.println("Error, number of stars can be 1 to 5");
        }
    }
    public Hotel(String address, float livingSpace, int nbRoom, Owner owner) {
        super(address, livingSpace, owner);
        this.nbRoom = nbRoom;
    }

    /** setters calls after the  contructor in the main when the client select 4 or 5 stars
     *
     */
    public void setNbSpa(int nbSpa) {
        this.nbSpa = nbStars == 4 ? nbSpa : 0; // verification if the hotel is 4 stars
    }
    public void setNbPool(int nbPool) {
        if (nbStars == 4) // set the good number if the fct is called on wong stars number hotel
            this.nbPool = 1;
        else if (nbStars == 5)
            this.nbPool = nbPool;
        else
            this.nbPool = 0;
    }
    public void setNbSuite(int nbSuite) {
        this.nbSuite = nbStars == 5 ? nbSuite : 0; // verification if the hotel is 5 stars
    }
}
