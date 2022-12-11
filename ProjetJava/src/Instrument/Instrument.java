/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Instrument;

public abstract class Instrument {
    protected String nameInstru;
    protected float purchasePrice;
    protected float sellingPrice;

    public Instrument() {
    }
    public Instrument(String nameInstru, float purchasePrice, float sellingPrice) {
        this.nameInstru = nameInstru;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                super.toString() +
                "nameInstru=" + nameInstru +
                "purchasePrice=" + purchasePrice +
                "sellingPrice=" + sellingPrice +

                '}';
    }
}
