package Instrument;

public class DigitalPiano extends Piano{
    public DigitalPiano(){} //default constructor
    boolean heavyTouch;
    int sQuality;

    public DigitalPiano(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, int nbKey) {
        super(nameInstru, purchasePrice, sellingPrice, length, width, nbKey);
    }
    public void setHeavyTouch(boolean ht){
        this.heavyTouch = ht;
    }

    public void setsQuality(int sampling) {
        if (sampling <= 3 && sampling >= 1) this.sQuality = sampling;
        else System.out.println("Error: Sampling of "+sampling+" impossible." +
                " Please enter a sampling quality between 1 and 3");
    }
}
