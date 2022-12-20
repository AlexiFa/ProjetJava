/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;
import Buildings.Building;

import java.util.ArrayList;

public class Owner extends Person{
    private ArrayList<Building> buildings;
    public Owner() {
        super();
        buildings = new ArrayList<Building>();
    }
    public Owner(Person person){
        super(person);
        buildings = new ArrayList<Building>();
    }
    public Owner(String name, String surname) {
        super(name, surname);
        buildings = new ArrayList<Building>();
    }
    @Override
    public String toString() {
        return super.toString() +
                ": owns " + buildings.size() +
                " buildings";
    }

    /**
     * Function to add a building to the list of the buildings he own
     * @param building : building to add
     */
    public void addBuilding(Building building){
        for (Building building1 : buildings){
            if (building1==building){
                return; // if the building is already in the array return false of maybe don't do anything (we can change that after)
            }
        }
        buildings.add(building);
    }

    /**
     * Function to remove a building of the list (if someone else buys it)
     * @param building : building to remove
     */
    public void removeBuilding(Building building){
        buildings.remove(building);
    }

    // getter
    public ArrayList<Building> getBuildings() {
        return buildings;
    }
}