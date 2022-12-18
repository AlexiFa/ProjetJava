/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Instrument;

public class Piano extends StringInstru {
    private int nbKey;

    public Piano(){
        super();
        this.nbKey = 88;
    } //default constructor

    public Piano(String nameInstru, float purchasePrice, float sellingPrice, int length, int width, int nbKey){
        super(nameInstru,purchasePrice,sellingPrice,length,width);
        this.nbKey =nbKey;
    }

    @Override
    public String toString() {
        return "Piano{" +
                super.toString() +
                "nbKey=" + nbKey +
                '}';
    }
}
