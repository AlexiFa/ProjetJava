package Instrument;

public class Piano extends StringInstru {
    private int nbKey;

    public Piano(){} //default constructor

    public Piano(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, int nbKey){
        super(nameInstru,purchasePrice,sellingPrice,length,width);
        this.nbKey =nbKey;
    }
}
