public class Maison extends Batiment{
    int nbPieces;
    float surfaceJardin;
    public Maison(){
        super();
    }
    public Maison(String adresse, float surfaceHab, int nbPieces, float surfaceJardin) {
        super(adresse, surfaceHab);
        this.nbPieces = nbPieces;
        this.surfaceJardin = surfaceJardin;
    }
}
