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

    public void rent(Occupant occ, int nb) throws Exception{
        if (occ.getRent()!=null || rentals.containsKey(nb))
            throw new Exception("occupant already has a rent or the flat is already rented");
        else {
            rentals.put(nb, occ); // set the occupant and the room in the Apart class
            occ.setRent(this); // set also in the Occupant class
            occ.setNoRoom(nb);
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
