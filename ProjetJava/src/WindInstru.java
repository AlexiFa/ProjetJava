public class WindInstru extends Instrument{
    protected String type; // maybe change that to "enum" to make it cleaner

    public WindInstru() {
        super();
    }
    public WindInstru(String nameInstru, float purchasePrice, float sellingPrice, String type) {
        super(nameInstru, purchasePrice, sellingPrice);
        this.type = type;
    }
}
