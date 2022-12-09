public class Immeuble extends Batiment {
    int nbAppart;
    public Immeuble(){
        super();
    }
    public Immeuble(String adresse, float surfaceHab, int nbAppart) {
        super(adresse, surfaceHab);
        this.nbAppart = nbAppart;
    }
}
