/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Instrument;

public abstract class StringInstru extends Instrument {
    protected int length;
    protected int width;

    public StringInstru() {
    }
    public StringInstru(String nameInstru, float purchasePrice, float sellingPrice, int length, int width) {
        super(nameInstru, purchasePrice, sellingPrice);
        this.length = length;
        this.width = width;
    }
    @Override
    public String toString() {
        return  super.toString() +
                " length=" + length +
                " width=" + width;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof StringInstru)) {
            return false;
        }
        return super.equals(o) &&
                length == ((StringInstru)o).length &&
                width == ((StringInstru)o).width;
    }
}
