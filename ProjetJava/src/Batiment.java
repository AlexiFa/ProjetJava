public abstract class Batiment {
    protected String adresse;
    protected float surfaceHab;
    public Batiment(){

    }
    public Batiment(String adresse, float surfaceHab) {
        this.adresse = adresse;
        this.surfaceHab = surfaceHab;
    }
}
