/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  building class with rentable flats
 */
package Buildings;
import Person.Occupant;
import Person.Owner;

import java.util.HashMap;

public class ApartmentBuilding extends Building {
    int nbApart;
    HashMap<Integer, Occupant> rentals; // Int : the number of the apart | Occupant : the occupant of the apart

    public ApartmentBuilding() {
    }

    public ApartmentBuilding(String address, float livingSpace, int nbApart, Owner owner) {
        super(address, livingSpace, owner);
        this.nbApart = nbApart;
        rentals = new HashMap<Integer, Occupant>();
    }

    @Override
    public String toString() {
        return "ApartmentBuilding{" +
                super.toString() +
                ", nbApart=" + nbApart +
                '}';
    }

    //getters
    public int getNbApart(){
        return this.nbApart;
    }

    public HashMap<Integer, Occupant> getRentals() {
        return rentals;
    }

    /**
     * Method to rent an apartment
     * @param occ : the occupant who wants to rent
     * @param nb : the number of the apartment
     * @throws Exception : if the apartment is already rented or the flat doesn't exist
     */
    public void rent(Occupant occ, int nb) throws Exception{
        if (occ.getRent()!=null || rentals.containsKey(nb))
            throw new Exception("occupant already has a rent or the flat is already rented");
        else if (nb > nbApart)
            throw new Exception("the flat doesn't exist");
        else{
            rentals.put(nb, occ); // set the occupant and the room in the Apart class
            occ.setRent(this); // set also in the Occupant class
            occ.setNoRoom(nb);
        }
    }

    /**
     * Method to stop renting an apartment
     * @param occ : the occupant who wants to stop renting
     * @throws Exception : if the occupant doesn't rent an apartment in this building
     */
    public void stopRent(Occupant occ) throws Exception{
        if (occ.getRent() == null || occ.getRent() != this) // in java, it doesn't check the second condition if the first is false, so we can do that
            throw new Exception("occupant has no rent here");
        else{ // because we can't rent a flat when it doesn't exist, we don't need to test if nb < nbApart
            rentals.remove(occ.getNoRoom());
            occ.setRent(null);
            occ.setNoRoom(0);
        }
    }
}
