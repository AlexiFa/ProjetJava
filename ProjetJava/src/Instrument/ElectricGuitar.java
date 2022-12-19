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

    @Override
    public String toString() {
        return "ElectricGuitar[" +
                super.toString() +
                "withAmpli=" + withAmpli +
                "withPedals=" + withPedals +
                ']';
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof ElectricGuitar)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return withAmpli == ((ElectricGuitar)o).withAmpli &&
                withPedals == ((ElectricGuitar)o).withPedals;
    }
}
