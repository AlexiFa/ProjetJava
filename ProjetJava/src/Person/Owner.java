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
        buildings = new ArrayList<Building>();
    }
    public Owner(String name, String surname) {
        super(name, surname);
        buildings = new ArrayList<Building>();
    }
}