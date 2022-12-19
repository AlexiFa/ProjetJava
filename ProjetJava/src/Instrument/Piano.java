/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Instrument;

public  abstract class Piano extends StringInstru {
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
        return  super.toString() +
                "nbKey=" + nbKey;
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof Piano)) {
            return false;
        }
        return super.equals(o) &&
                nbKey == ((Piano)o).nbKey;
    }
}
