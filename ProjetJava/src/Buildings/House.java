/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Buildings;
import Person.Owner;
public class House extends Building {
    int nbPart;
    float gardenArea;
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
}
