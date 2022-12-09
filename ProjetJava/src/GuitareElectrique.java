public class GuitareElectrique extends Corde{
    private boolean avecAmpli;
    private boolean avecPedals;

    public GuitareElectrique() {
        super();
    }
    public GuitareElectrique(String nom, float prixAchat, float prixVente, int longueur, int largeur, boolean avecAmpli, boolean avecPedals) {
        super(nom, prixAchat, prixVente, longueur, largeur);
        this.avecAmpli = avecAmpli;
        this.avecPedals = avecPedals;
    }
}
