package Instrument;

public class Instrument {
    protected String nameInstru;
    protected float purchasePrice;
    protected float sellingPrice;

    public Instrument() {
    }
    public Instrument(String nameInstru, float purchasePrice, float sellingPrice) {
        this.nameInstru = nameInstru;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }
}
