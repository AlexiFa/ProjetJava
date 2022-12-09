public class GuitareAcoustique extends Corde{
    private String position;
    private int tirant;
    public GuitareAcoustique(){
        super();
    }
    public GuitareAcoustique(String nom, float prixAchat, float prixVente, int longueur, int largeur, String position, int tirant) {
        super(nom, prixAchat, prixVente, longueur, largeur);
        this.position = position;
        this.tirant = tirant;
    }
}
