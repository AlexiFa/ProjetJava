public class Instrument {
    protected String nom;
    protected float prixAchat;
    protected float prixVente;

    public Instrument() {
    }
    public Instrument(String nom, float prixAchat, float prixVente) {
        this.nom = nom;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }
}
