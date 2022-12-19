/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Buildings;
import Instrument.*; // because a store have a stock of instrument
import Person.Owner;
import java.util.ArrayList;
import java.util.Scanner;

public class Store extends Building {
    ArrayList<Instrument> instruments;

    public Store(){
        // super() is called by default if we don't call any constructor from super (if there is a default constructor)
        instruments = new ArrayList<Instrument>();
    }

    public Store(String address, float livingSpace, Owner owner, ArrayList<Instrument> instruments) {
        super(address, livingSpace, owner);
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "Store{" +
                super.toString() +
                ", instruments=" + instruments +//todo: corriger apparition (on voit rien dans console)
                '}';
    }
    //getters
    public ArrayList<Instrument> getInstruments(){
        return this.instruments;
    }
    //setter
    /**
     * Function to implement instruments inside a store
     *
     * @param sc : the scanner to get the user's input
     */
    public void addInstruments(Scanner sc) {
        System.out.print("> How many instruments do you want to add ? Enter a number: ");
        int nb = sc.nextInt();
        sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
        for (int i = 0; i < nb; i++) {
            System.out.println("Instrument " + (i + 1)+"\n");
            System.out.print("> Give it a name: ");
            String name = sc.nextLine();
            System.out.print("> Give out its purchase price: ");
            float purchase_p = sc.nextFloat();
            System.out.print("> Give it a selling price: ");
            float selling_p = sc.nextFloat();
            System.out.println("> Please chose your instrument type: ");
            System.out.println("1. Electric Guitar");
            System.out.println("2. Acoustic Guitar");
            System.out.println("3. Upright Piano");
            System.out.println("4. Digital Piano");
            System.out.println("5. Grand Piano");
            System.out.println("6. Flute");
            System.out.println("7. Clarinet");
            System.out.println("8. Oboe");
            int intr = sc.nextInt();
            sc.nextLine();//PRIMORDIAL, to be able to read strings after reading an int/float
            int length;
            int width;
            int keys;
            switch (intr) {
                case 1:
                    System.out.print("> Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("> Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("> Does it comes with an amplifier? 1 (yes) or 2 (no): ");
                    boolean with_amplifier = sc.nextInt() == 1;
                    System.out.print("> Does it comes with special-effects pedals? 1 (yes) or 2 (no): ");
                    boolean with_pedals = sc.nextInt() == 1;
                    ElectricGuitar eg = new ElectricGuitar(name, purchase_p, selling_p, length, width, with_amplifier, with_pedals);
                    this.instruments.add(eg);
                    sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
                    break;
                case 2:
                    System.out.print("> Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("> Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("> Is your guitar for a right-handed, or left-handed person? 1 (right) or 2 (left): ");
                    String hand = sc.nextInt() == 1 ? "right-handed" : "left-handed";
                    System.out.print("> Give it a pull between 1, 2 or 3: ");
                    int pull = sc.nextInt();
                    AcousticGuitar ag = new AcousticGuitar(name, purchase_p, selling_p, length, width, hand, pull);
                    this.instruments.add(ag);
                    sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
                    break;
                case 3:
                    System.out.print("> Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("> Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("> Give out its number of keys (minimum 25, maximum 88): ");
                    keys = sc.nextInt();
                    UprightPiano up = new UprightPiano(name, purchase_p, selling_p, length, width, keys);
                    System.out.print("> Does it have a silent option? 1 (yes) or 2 (no): ");
                    up.setSilence(sc.nextInt() == 1);
                    System.out.print("> Does it have straight or crossed strings? 1 (straight) or 2 (crossed)");
                    up.setStrings(sc.nextInt());
                    this.instruments.add(up);
                    sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
                    break;
                case 4:
                    System.out.print("> Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("> Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("> Give out its number of keys (minimum 25, maximum 88): ");
                    keys = sc.nextInt();
                    DigitalPiano dp = new DigitalPiano(name, purchase_p, selling_p, length, width, keys);
                    System.out.print("> Does it have a heavy-touch system? 1 (yes) or 2 (no): ");
                    dp.setHeavyTouch(sc.nextInt() == 1);
                    System.out.print("> Give it the sampling quality of your choice, 1 2 or 3: ");
                    dp.setsQuality(sc.nextInt());
                    this.instruments.add(dp);
                    sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
                    break;
                case 5:
                    System.out.print("> Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("> Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("> Give out its number of keys (minimum 25, maximum 88): ");
                    keys = sc.nextInt();
                    GrandPiano gp = new GrandPiano(name, purchase_p, selling_p, length, width, keys);
                    System.out.print("> Chose the grand size of your choice:\n1. '4/4'\n2. '1/2'\n3. '1/4'\n4. 'Crapaud'");
                    gp.setSize(sc.nextInt());
                    this.instruments.add(gp);
                    sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
                    break;
                case 6:
                    WindInstru flute = new WindInstru(name, purchase_p, selling_p, "FLUTE");
                    this.instruments.add(flute);
                    break;
                case 7:
                    WindInstru clarinet = new WindInstru(name, purchase_p, selling_p, "CLARINET");
                    this.instruments.add(clarinet);
                    break;
                case 8:
                    WindInstru oboe = new WindInstru(name, purchase_p, selling_p, "OBOE");
                    this.instruments.add(oboe);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
            System.out.println("Instrument " + (i + 1) + ", " + name + ", has been added.");
        }
        System.out.println("\nAll instruments have been added.");
    }

    /**
     * Method to remove an instrument from the list of the store
     * @param instrument : the instrument to remove
     */
    public void removeInstrument(Instrument instrument){
            this.instruments.remove(instrument);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }
}
