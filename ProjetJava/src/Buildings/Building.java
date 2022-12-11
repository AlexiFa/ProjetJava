/**
 *
 */
package Buildings;
import Person.Owner;

public abstract class Building {
    protected String address;
    protected float livingSpace;
    protected Owner owner;
    public Building(){
    }
    public Building(String address, float livingSpace, Owner owner) {
        this.address = address;
        this.livingSpace = livingSpace;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "address='" + address + '\'' +
                ", livingSpace=" + livingSpace +
                ", owner=" + owner;
    }
}
