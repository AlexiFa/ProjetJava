public class Vent extends Instrument{
    String type; // ptre changer ça en enum pour plus de propreté

    public Vent() {
        super();
    }
    public Vent(String nom, float prixAchat, float prixVente, String type) {
        super(nom, prixAchat, prixVente);
        this.type = type;
    }
}
