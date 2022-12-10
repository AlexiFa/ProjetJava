package Instrument;

public class ElectricGuitar extends StringInstru {
    private boolean avecAmpli;
    private boolean avecPedals;

    public ElectricGuitar() {
    }
    public ElectricGuitar(String nom, float prixAchat, float prixVente, int longueur, int largeur, boolean avecAmpli, boolean avecPedals) {
        super(nom, prixAchat, prixVente, longueur, largeur);
        this.avecAmpli = avecAmpli;
        this.avecPedals = avecPedals;
    }
}
