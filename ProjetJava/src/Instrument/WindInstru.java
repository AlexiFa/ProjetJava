/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Instrument;

public class WindInstru extends Instrument {
    private enum WindI {
        FLUTE("flute, with a beveled side"),
        CLARINET("clarinet, with a single reed"),
        OBOE("oboe, with a double reed");
        private final String t;
        WindI(String twind) {
            this.t = twind;
        }
        public String getT(){
            return this.t;
        }
    } //restricted possibilities of wind instrument types
    protected WindI type; //variable to store the type of wind instrument from enum
    public WindInstru() {} //default constructor
    public WindInstru(String nameInstru, float purchasePrice, float sellingPrice, String type) {
        super(nameInstru, purchasePrice, sellingPrice);
        this.type = WindI.valueOf(type);
    }
    @Override
    public String toString() {
        return type.getT() + " :" +
                super.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof WindInstru)) {
            return false;
        }
        return super.equals(o) &&
                type == ((WindInstru)o).type;
    }
}
