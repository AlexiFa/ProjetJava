/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
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
    @Override
    public String toString() {
        return "AcousticGuitar[" +
                super.toString() +
                " hand=" + hand +
                " pull=" + pull +
                ']';
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof AcousticGuitar)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return hand.equals(((AcousticGuitar)o).hand) &&
                pull == ((AcousticGuitar)o).pull;
    }
}
