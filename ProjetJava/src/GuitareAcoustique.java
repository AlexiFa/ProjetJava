public class GuitareAcoustique extends Corde{
    String position;
    int tirant;
    public GuitareAcoustique(){
        super();
    }
    public GuitareAcoustique(String nom, float prixAchat, float prixVente, int longueur, int largeur, String position, int tirant) {
        super(nom, prixAchat, prixVente, longueur, largeur);
        this.position = position;
        this.tirant = tirant;
    }
}
