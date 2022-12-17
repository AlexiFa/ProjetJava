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
    //getter for nbAppart
    public int getNbApart(){
        return this.nbApart;
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
     * @throws Exception : if the occupant doesn't rent an apartment or not in this building
     */
    public void stopRental(Occupant occ) throws Exception{
        if (occ.getRent() == null)
            throw new Exception("occupant has no rent");
        else if (occ.getRent() != this)
            throw new Exception("occupant doesn't rent this building");
        else{
            rentals.remove(occ.getNoRoom());
            occ.setRent(null);
            occ.setNoRoom(0);
        }
    }

    /*@Override
    public boolean equals(Object o){
        if (!super.equals(o))
            return false;
        if (o == this)
            return true;
        if (!(o instanceof ApartmentBuilding))
            return  false;
        ApartmentBuilding temp = (ApartmentBuilding) o;
        if (rentals.isEmpty() && temp.rentals.isEmpty())
            return temp.nbApart == nbApart;
        else if (rentals.size() == temp.rentals.size()){
            for (int i = 0; i < rentals.size(); i++){
                if (!rentals.get(i).equals(temp.rentals.get(i)))
                    return false;
            }
            return true;
        }
        else
            return false;
    }*/
}
