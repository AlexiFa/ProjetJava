/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Instrument;

public abstract class WindInstru extends Instrument {
    protected String type; // maybe change that to "enum" to make it cleaner

    public WindInstru() {
    }
    public WindInstru(String nameInstru, float purchasePrice, float sellingPrice, String type) {
        super(nameInstru, purchasePrice, sellingPrice);
        this.type = type;
    }
    @Override
    public String toString() {
        return "WindInstru{" +
                super.toString() +
                "type=" + type +
                '}';
    }
}
