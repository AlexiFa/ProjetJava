import java.util.ArrayList;

public class Magasin extends Batiment{
    ArrayList<Instrument> instruments;
    Personne proprio;

    public Magasin(){
        super();
        instruments = new ArrayList<Instrument>();
    }
    public Magasin(Personne proprietaire){
        super();
        instruments = new ArrayList<Instrument>();
        this.proprio = proprietaire;
    }

}
