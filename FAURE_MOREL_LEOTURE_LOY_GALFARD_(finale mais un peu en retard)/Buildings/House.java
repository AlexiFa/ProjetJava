/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Buildings;
import Person.Owner;
public class House extends Building {
    private int nbPart;
    private float gardenArea;
    public House(){
    }
    public House(String address, float livingSpace, int nbPart, float gardenArea, Owner owner) {
        super(address, livingSpace, owner);
        this.nbPart = nbPart;
        this.gardenArea = gardenArea;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                ", nbPart=" + nbPart +
                ", gardenArea=" + gardenArea +
                '}';
    }
    //getters
    public int getNbPart(){
        return this.nbPart;
    }
    public float getGardenArea(){
        return this.gardenArea;
    }

    /**
     * Function to calculate the tax of the house
     * @Override to use this function instead of the one in the parent class
     * @return : the tax of the house
     */
    @Override
    public float getTax(){
        return super.getTax() + RATEB * gardenArea;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof House)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return address.equals(((House)o).address) &&
                livingSpace == ((House)o).livingSpace &&
                nbPart == ((House)o).nbPart &&
                gardenArea == ((House)o).gardenArea &&
                owner.equals(((House)o).owner);
    }
}
