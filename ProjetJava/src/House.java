public class House extends Building {
    int nbPart;
    float gardenArea;
    public House(){
        super();
    }
    public House(String address, float livingSpace, int nbPart, float gardenArea) {
        super(address, livingSpace);
        this.nbPart = nbPart;
        this.gardenArea = gardenArea;
    }
}
