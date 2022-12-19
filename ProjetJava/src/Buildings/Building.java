/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  Parent class of every building with the common attributes
 */
package Buildings;
import Person.Owner;

public abstract class Building {
    final float RATEA = (float) 5.6;
    final float RATEB = (float) 1.5;
    protected String address;
    protected float livingSpace;
    protected Owner owner;
    public Building(){
    }
    public Building(String address, float livingSpace, Owner owner) {
        this.address = address;
        this.livingSpace = livingSpace;
        this.owner = owner;
        owner.addBuilding(this); // to also add the building in the owner's list
    }

    @Override
    public String toString() {
        return "address='" + address + '\'' +
                ", livingSpace=" + livingSpace +
                ", owner=" + owner +
                ", tax=" + getTax();
    }

    /**
     * Function to set the owner of the building (if there is already an owner, it changes it also in the old owner's list)
     * @param owner : new owner
     */
    public void setOwner(Owner owner) {
        if (this.owner!=null){
            this.owner.removeBuilding(this); // if the owner change, we need to remove this building from the buildings owned by this owner
        }
        this.owner = owner;
        this.owner.addBuilding(this); // add this building in the properties of the owner
    }
//getters for parameters
    public String getAddress(){
        return this.address;
    }
    public float getLivingSpace(){
        return this.livingSpace;
    }
    public Owner getOwner(){
        return this.owner;
    }
    public float getTax(){
        return RATEA * livingSpace;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof Building))
            return  false;
        Building temp = (Building) o;
        return temp.address.equals(address) && temp.livingSpace == livingSpace && temp.owner.equals(owner);
    }
}
