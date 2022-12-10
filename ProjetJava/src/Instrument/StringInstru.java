package Instrument;

import Instrument.Instrument;

public class StringInstru extends Instrument {
    protected int length;
    protected int width;

    public StringInstru() {
        super();
    }
    public StringInstru(String nameInstru, float purchasePrice, float sellingPrice, int length, int width) {
        super(nameInstru, purchasePrice, sellingPrice);
        this.length = length;
        this.width = width;
    }
}
