package Instrument;

public class GrandPiano extends Piano{
    private enum sizeType {FULL, HALF, QUARTER, CRAPAUD}
    protected sizeType size;
    public GrandPiano(){} //default constructor

    public GrandPiano(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, int nbKey) {
        super(nameInstru, purchasePrice, sellingPrice, length, width, nbKey);
    }

    @Override
    public String toString() {
        return "GrandPiano [" +
                super.toString() +
                ']';
    }

    public void setSize(int s){
        switch (s) {
            case 1: this.size = sizeType.FULL;break;
            case 2: this.size = sizeType.HALF;break;
            case 3: this.size = sizeType.QUARTER;break;
            case 4: this.size= sizeType.CRAPAUD; break;
            default: System.out.println("Please choose the right type of size: '4/4' (1), '1/2' (2), '1/4' (3) or 'Crapaud' (4)");
        }
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof GrandPiano)) {
            return false;
        }
        return super.equals(o) &&
                size == ((GrandPiano)o).size;
    }
}
