public class Corde extends Instrument{
    int longueur;
    int largeur;

    public Corde() {
        super();
    }
    public Corde(String nom, float prixAchat, float prixVente, int longueur, int largeur) {
        super(nom, prixAchat, prixVente);
        this.longueur = longueur;
        this.largeur = largeur;
    }
}
