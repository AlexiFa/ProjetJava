/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  hotel class with the numbers of rooms, spa, pools ... (depends of the type of the hotel)
 */
package Buildings;
import Person.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Hotel extends Building {
    int nbStars;
    int nbRoom;
    int nbSpa; // only for 4 stars hotel (else = 0)
    int nbPool; // only for 5 or 4 stars hotel (else = 0)
    // the number of the suite are nbRoom + (1, 2, ...)
    // for example, if there are 10 rooms, the suite are 11, 12, 13, ...
    int nbSuite; // idem for 5 stars

    HashMap<Integer,Occupant> rentals; // Integer : the number of the room | Occupant : the occupant of the room

    /**
     * Main constructor to set default values
     * @param stars : number of stars of the hotel
     */
    public Hotel(int stars){
        nbStars = stars;
        //roomsOccupied = new ArrayList<Integer>();
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
        rentals = new HashMap<Integer, Occupant>();
    }
    public Hotel(String address, float livingSpace, int stars, Owner owner) {
        super(address, livingSpace, owner);
        rentals = new HashMap<Integer, Occupant>();
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
    public HashMap<Integer, Occupant> getRentals() {
        return rentals;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                super.toString() +
                ", nbStars=" + nbStars +
                ", nbRooms=" + nbRoom +
                '}';
    }

    /**
     * Function to allow someone to rent a room in the hotel and throw an exception if the occupant already has a rent somewhere
     * @param occ : the occupant of the room
     * @param nb : the number of the room
     * @throws Exception : if the occupant already has a rent somewhere, if the room is already occupied, if the number of the room is not in the hotel
     */
    public void rent(Occupant occ, int nb) throws Exception{
        if (occ.getRent()!=null || rentals.containsKey(nb)) // if he already has a rent send an error || if the room is occupied, send an error
            throw new Exception("occupant already has a rent or the room is already rented");
        else if (nb > nbRoom + nbSuite) // if the room doesn't exist, send an error
            throw new Exception("the room doesn't exist");
        else{
            rentals.put(nb,occ); // set the occupant and the room in the Hotel class
            occ.setRent(this); // set the rent of the occupant
            occ.setNoRoom(nb);
        }
    }

    /**
     * Function to end a rental and change the hotel and occupant classes
     * @param occ : the occupant who want to stop his rental
     * @throws Exception : if the occupant doesn't have a rent
     */
    public void stopRent(Occupant occ) throws Exception{
        if (occ.getRent() == null || occ.getRent() != this){
            throw new Exception("error, this occupant don't have any rent here");
        } else {
            rentals.remove(occ.getNoRoom(),occ);
            occ.setRent(null);
            occ.setNoRoom(0);
            // occupants.remove(occ);
            // take the index and remove also in the room array or make hashmap (but personally idk how to do hashmap so ask the others)
        }
    }

    /**
     * Function to get the tax of the hotel
     * @Override to only use this function instead of the one in the parent class
     * @return : the tax of the hotel
     */
    @Override
    public float getTax() {
        if (nbStars == 5){
            return super.getTax() + RATEB * nbPool;
        }else if (nbStars == 4) {
            return super.getTax() + RATEB * (nbSpa + 1);
        }else{
            return super.getTax();
        }
    }
}
