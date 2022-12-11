package Instrument;

public class GrandPiano extends Piano{
    enum sizeType {FULL, HALF, QUARTER, CRAPAUD}
    sizeType size;
    public GrandPiano(){} //default constructor

    public GrandPiano(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, int nbKey) {
        super(nameInstru, purchasePrice, sellingPrice, length, width, nbKey);
    }

    public void setSize(int s){
        switch (s) {
            case 1: this.size = sizeType.FULL;break;
            case 2: this.size = sizeType.HALF;break;
            case 3: this.size = sizeType.QUARTER;break;
            case 4: this.size= sizeType.CRAPAUD; break;
            default: System.out.println("Please choose the right type of size: 4/4, 1/2, 1/4 or Crapaud");
        }
    }
}
