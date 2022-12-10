package Instrument;

public abstract class StringInstru extends Instrument {
    protected int length;
    protected int width;

    public StringInstru() {
    }
    public StringInstru(String nameInstru, float purchasePrice, float sellingPrice, int length, int width) {
        super(nameInstru, purchasePrice, sellingPrice);
        this.length = length;
        this.width = width;
    }
}
