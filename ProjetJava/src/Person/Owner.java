/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;
import Buildings.Building;

import java.util.ArrayList;

public class Owner extends Person{
    ArrayList<Building> buildings;
    public Owner() {
    }
    public Owner(String name, String surname, Building building) {
        super(name, surname);
        this.buildings.add(building);
    }
}