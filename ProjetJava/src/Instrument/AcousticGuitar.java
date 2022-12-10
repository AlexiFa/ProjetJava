package Instrument;

public class AcousticGuitar extends StringInstru {
    private String hand; // left or right (maybe change the name of this var)
    private int pull; // maybe change that also
    public AcousticGuitar(){
    }
    public AcousticGuitar(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, String hand, int pull) {
        super(nameInstru, purchasePrice, sellingPrice, length, width);
        this.hand = hand;
        this.pull = pull;
    }
}
