/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  hotel class with the numbers of rooms, spa, pools ... (depends of the type of the hotel)
 */
package Buildings;
import Person.Owner;
import Person.*;

import java.util.ArrayList;

public class Hotel extends Building {
    int nbStars;
    int nbRoom;
    int nbSpa; // only for 4 stars hotel (else = 0)
    int nbPool; // only for 5 or 4 stars hotel (else = 0)
    int nbSuite; // idem for 5 stars
    ArrayList<Integer> roomsOccupied; // to stock every room which are occupied
    ArrayList<Occupant> occupants; // list of all occupants (find a way to link each occupant with his noRoom) (maybe the index in the array is the same in the rooms array)
    /**
     * Main constructor to set default values
     * @param stars : number of stars of the hotel
     */
    public Hotel(int stars){
        nbStars = stars;
        roomsOccupied = new ArrayList<Integer>();
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
        roomsOccupied = new ArrayList<Integer>();
    }
    public Hotel(String address, float livingSpace, int stars, Owner owner) {
        super(address, livingSpace, owner);
        roomsOccupied = new ArrayList<Integer>();
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

    public void rent(Occupant occ, int nb){
        if (occ.getRent()!=null){ // if he already has a rent send an error
            System.out.println("error, this occupant already have a rent");
        }else if(roomsOccupied.contains(nb)){ // if the room is occupied, send an error
            System.out.println("error, this room is already occupied");
        }else{
            occupants.add(occ); // set the occupant and the room in the Hotel class
            roomsOccupied.add(nb);
            occ.setRent(this); // set also in the Occupant class
            occ.setNoRoom(nb);
        }
    }

    /**
     * TODO : function not finished yet
     * @param occ
     */
    public void stopRent(Occupant occ){
        if (occ.getRent()==null || occ.getRent() != this){
            System.out.println("error, this occupant don't have any rent here");
        } else {
            // occupants.remove(occ);
            // take the index and remove also in the room array or make hashmap (but personally idk how to do hashmap so ask the others)
        }
    }
}
