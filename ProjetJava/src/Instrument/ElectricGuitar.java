/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Instrument;

public class ElectricGuitar extends StringInstru {
    private boolean withAmpli;
    private boolean withPedals;

    public ElectricGuitar() {
    }
    public ElectricGuitar(String nom, float purchasePrice, float sellingPrice, int length, int width, boolean withAmpli, boolean withPedals) {
        super(nom, purchasePrice, sellingPrice, length, width);
        this.withAmpli = withAmpli;
        this.withPedals = withPedals;
    }
}
