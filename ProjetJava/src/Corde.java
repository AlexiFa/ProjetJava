public class Corde extends Instrument{
    protected int longueur;
    protected int largeur;

    public Corde() {
        super();
    }
    public Corde(String nom, float prixAchat, float prixVente, int longueur, int largeur) {
        super(nom, prixAchat, prixVente);
        this.longueur = longueur;
        this.largeur = largeur;
    }
}
