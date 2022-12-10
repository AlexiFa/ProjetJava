public abstract class Building {
    protected String address;
    protected float livingSpace;
    public Building(){

    }
    public Building(String address, float livingSpace) {
        this.address = address;
        this.livingSpace = livingSpace;
    }
}
