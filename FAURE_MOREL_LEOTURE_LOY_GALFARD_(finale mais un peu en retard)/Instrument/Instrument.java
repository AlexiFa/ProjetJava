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
        return " nameInstru=" + nameInstru +
                " purchasePrice=" + purchasePrice +
                " sellingPrice=" + sellingPrice ;
    }

    public String getNameInstru(){
        return this.nameInstru;
    }

    public float getSellingPrice(){
        return this.sellingPrice;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof Instrument)) {
            return false;
        }
        return nameInstru.equals(((Instrument)o).nameInstru) &&
                purchasePrice == ((Instrument)o).purchasePrice &&
                sellingPrice == ((Instrument)o).sellingPrice;
    }
}
