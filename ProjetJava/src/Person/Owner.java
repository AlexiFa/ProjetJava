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

    public boolean addBuilding(Building building){
        for (Building building1 : buildings){
            if (building1==building){
                return false; // if the building is already in the array return false of maybe don't do anything (we can change that after)
            }
        }
        return buildings.add(building);
    }
    public void removeBuilding(Building building){
        buildings.remove(building);
    }
}