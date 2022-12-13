package Instrument;

import java.util.Objects;

public class UprightPiano extends Piano{
    private enum stringsType {STRAIGHT, CROSSED};
    protected boolean silence;
    protected stringsType sType;

    public UprightPiano(){} //default constructor

    public UprightPiano(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, int nbKey) {
        super(nameInstru, purchasePrice, sellingPrice, length, width, nbKey);
    }

    @Override
    public String toString() {
        return "UprightPiano{" +
                super.toString() +
                '}';
    }

    public void setSilence(boolean silence){
        this.silence = silence;
    }

    public void setStrings(int strings){
        if (strings == 1) {
            this.sType = stringsType.STRAIGHT;
        }
        else if (strings == 2){
            this.sType = stringsType.CROSSED;
        }
        else System.out.println("Please choose the right type of strings: 'straight' (1) or 'crossed' (2)");
    }
}
