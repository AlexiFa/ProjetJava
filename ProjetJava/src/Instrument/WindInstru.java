package Instrument;

public abstract class WindInstru extends Instrument {
    protected String type; // maybe change that to "enum" to make it cleaner

    public WindInstru() {
    }
    public WindInstru(String nameInstru, float purchasePrice, float sellingPrice, String type) {
        super(nameInstru, purchasePrice, sellingPrice);
        this.type = type;
    }
}
