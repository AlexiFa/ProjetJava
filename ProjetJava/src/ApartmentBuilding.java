public class ApartmentBuilding extends Building {
    int nbApart;
    public ApartmentBuilding(){
        super();
    }
    public ApartmentBuilding(String address, float livingSpace, int nbApart) {
        super(address, livingSpace);
        this.nbApart = nbApart;
    }
}
