/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  hotel class with the numbers of rooms, spa, pools ... (depends of the type of the hotel)
 */
package Buildings;
import Person.Owner;

public class Hotel extends Building {
    int nbStars;
    int nbRoom;
    int nbSpa; // only for 4 stars hotel (else = 0)
    int nbPool; // only for 5 or 4 stars hotel (else = 0)
    int nbSuite; // idem for 5 stars

    /**
     * Main constructor to set default values
     * @param stars : number of stars of the hotel
     */
    public Hotel(int stars){
        nbStars = stars;
        nbSpa = 0; // first set the special attributes to 0 and change them after depending on stars number
        nbPool = 0;
        nbSuite = 0;
        switch (nbStars){
            case 1 : nbRoom = 10;break;
            case 2 : nbRoom = 15;break;
            case 3 : nbRoom = 20;break;
            case 4 : // nbSpa will be set after the constructor in the main
                nbPool = 1;
                nbRoom = 25;
                break;
            case 5 :
                nbRoom = 30;
                break;
            default:
                System.out.println("Error, number of stars can be 1 to 5");
                break;
        }
    }
    public Hotel() {
    }
    public Hotel(String address, float livingSpace, int stars, Owner owner) {
        super(address, livingSpace, owner);
        nbStars = stars;
        nbSpa = 0; // first set the special attributes to 0 and change them after depending on stars number
        nbPool = 0;
        nbSuite = 0;
        switch (nbStars){
            case 1 : nbRoom = 10;break;
            case 2 : nbRoom = 15;break;
            case 3 : nbRoom = 20;break;
            case 4 : // nbSpa will be set after the constructor in the main
                nbPool = 1;
                nbRoom = 25;
                break;
            case 5 :
                nbRoom = 30;
                break;
            default:
                System.out.println("Error, number of stars can be 1 to 5");
                break;
        }
    }

    /**
     * Setters calls after the constructor in the main loop when the client select 4 or 5 stars
     */
    public void setNbSpa(int nbSpa) {
        this.nbSpa = nbStars == 4 ? nbSpa : 0; // verification if the hotel is 4 stars
    }
    public void setNbPool(int nbPool) {
        if (nbStars == 4)
            this.nbPool = 1; // set the good number if the fct is called on wong stars number hotel
        else if (nbStars == 5)
            this.nbPool = nbPool;
        else
            this.nbPool = 0;
    }
    public void setNbSuite(int nbSuite) {
        this.nbSuite = nbStars == 5 ? nbSuite : 0; // verification if the hotel is 5 stars
    }
    //getters
    public int getNbStars(){
        return this.nbStars;
    }
    public int getNbRoom(){
        return this.nbRoom;
    }
    public int getNbPool(){
        return this.nbPool;
    }
    public int getNbSpa() {
        return this.nbSpa;
    }
    public int getNbSuite() {
        return this.nbSuite;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                super.toString() +
                ", nbStars=" + nbStars +
                ", nbRooms=" + nbRoom +
                '}';
    }
}
