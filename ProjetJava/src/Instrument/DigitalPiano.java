package Instrument;

public class DigitalPiano extends Piano{
    private enum sQuality {ONE, TWO, THREE};
    protected boolean heavyTouch;
    protected sQuality sampQ;
    public DigitalPiano(){} //default constructor
    public DigitalPiano(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, int nbKey) {
        super(nameInstru, purchasePrice, sellingPrice, length, width, nbKey);
    }

    @Override
    public String toString() {
        return "DigitalPiano{" +
                super.toString() +
                '}';
    }
    public void setHeavyTouch(boolean ht){
        this.heavyTouch = ht;
    }

    public void setsQuality(int sampling) {
        switch (sampling){
            case 1: this.sampQ = sQuality.ONE;break;
            case 2: this.sampQ = sQuality.TWO; break;
            case 3: this.sampQ = sQuality.THREE; break;
            default: System.out.println("Error: Please choose an existing sampling quality: 1, 2, or 3.");
        }
    }
}
