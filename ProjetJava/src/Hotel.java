public class Hotel extends Batiment {
    int nbChambre;
    public Hotel(){
        super();
    }

    public Hotel(String adresse, float surfaceHab, int nbChambre) {
        super(adresse, surfaceHab);
        this.nbChambre = nbChambre;
    }
}
