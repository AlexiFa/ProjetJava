/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
import Buildings.*;
import Person.*;
import Instrument.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Functions {

    /**
     * Function to print out all people in the residence
     * @param population : all the persons added to the residence
     */
    public static void printAllPerson(HashMap<Person, Person[]> population) {
        System.out.println("\nPopulation List:");
        System.out.println("----------------------------------------------");
        int i = 1;
        for (Person key : population.keySet()) {
            System.out.print(i + ". " + key.getName() + " " + key.getSurname());
            if (population.get(key)[0] != null) System.out.print(" | Owner");
            if (population.get(key)[1] != null) System.out.print(" | Occupant");
            System.out.print("\n");
            i++;
        }
        System.out.println("----------------------------------------------");
    }

    /**
     * Function to print out all building in the residence
     * @param residence : all the buildings added to the residence
     */
    public static void printAllBuildings(HashMap<String, ArrayList<Building>> residence) {
        System.out.println("\nBuildings List:");
        System.out.println("----------------------------------------------");
        for (String key : residence.keySet()) {
            int i = 1;
            System.out.println("All " + key + "s: ");
            for(Building build: residence.get(key)){
                System.out.println(" "+i+". "+ build.toString());
                i++;
            }
            System.out.print("\n");
        }
        System.out.println("----------------------------------------------");
    }

    /**
     * Functions to create all type of buildings in the residence, and assign them to owner
     */
    public static House mCBHouse(Scanner sc, Owner owner) {//creation of a house and return it
        System.out.println("You chose to build a House.\nTo complete your demand, please give us the following information:");
        System.out.print("> The Address: ");
        String address = sc.nextLine();
        System.out.print("> The size of the total living space: ");
        float liv_area = sc.nextFloat();
        System.out.print("> The number of rooms: ");
        int nb_rooms = sc.nextInt();
        System.out.print("> The size of the garden area: ");
        float garden_area = sc.nextFloat();
        System.out.print("Thank you. ");
        return new House(address, liv_area, nb_rooms, garden_area, owner);
    }
    public static Hotel mCBHotel(Scanner sc, Owner owner){ //creation of a hotel and return it //TODO

        return new Hotel();
    }
    public static ApartmentBuilding mCBApartment(Scanner sc, Owner owner){ // creation of an apartment building and return it
        System.out.println("You chose to build an Apartment Building.\nTo complete your demand, please give us the following information:");
        System.out.print("> The Address: ");
        String address = sc.nextLine();
        System.out.print("> The size of the total living space: ");
        float liv_area = sc.nextFloat();
        System.out.print("> The total number of apartments: ");
        int nb_rooms = sc.nextInt();
        System.out.print("Thank you. ");
        return new ApartmentBuilding(address, liv_area, nb_rooms, owner);
    }
    public static Store mCBStore(Scanner sc, Owner owner){ //creation of a store and return it
        System.out.println("You chose to build a Store.\nTo complete your demand, please give us the following information:");
        System.out.print("> The Address: ");
        String address = sc.nextLine();
        System.out.print("> The size of the total living space: ");
        float liv_area = sc.nextFloat();
        System.out.print("Please chose a few instruments to add to your store:\n");
        ArrayList<Instrument> instruments = addInstruments(sc);
        System.out.print("Thank you. ");
        return new Store(address, liv_area, owner, instruments);
    }

    /**
     * Function to implement instruments inside a store
     * @param sc
     * @return arraylist with all instruments that will go with the store
     */
    public static ArrayList<Instrument> addInstruments(Scanner sc){
        ArrayList<Instrument> instruments = new ArrayList<Instrument>();
        System.out.print("How many instruments do you want to add ?\nEnter a number: ");
        int nb = sc.nextInt();
        sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
        for(int i = 0; i < nb; i++){
            System.out.println("Instrument "+(i+1));
            System.out.print("Give it a name: ");
            String name = sc.nextLine();
            System.out.print("Give out its purchase price: ");
            float purchase_p = sc.nextFloat();
            System.out.print("Give it a selling price: ");
            float selling_p = sc.nextFloat();
            System.out.println("Please chose your instrument type: ");
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
            switch(intr){
                case 1:
                    System.out.print("Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("Does it comes with an amplifier? 1 (yes) or 2 (no): ");
                    boolean with_amplifier = sc.nextInt() == 1;
                    System.out.print("Does it comes with special-effects pedals? 1 (yes) or 2 (no): ");
                    boolean with_pedals = sc.nextInt() == 1;
                    ElectricGuitar eg = new ElectricGuitar(name, purchase_p, selling_p, length, width, with_amplifier, with_pedals);
                    instruments.add(eg);
                    break;
                case 2:
                    System.out.print("Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("Is your guitar for a right-handed, or left-handed person? 1 (right) or 2 (left): ");
                    String hand = sc.nextInt() == 1 ? "right-handed" : "left-handed";
                    System.out.print("Give it a pull between 1, 2 or 3: ");
                    int pull = sc.nextInt();
                    AcousticGuitar ag = new AcousticGuitar(name, purchase_p, selling_p, length, width, hand, pull);
                    instruments.add(ag);
                    break;
                case 3:
                    System.out.print("Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("Give out its number of keys (minimum 25, maximum 88): ");
                    keys = sc.nextInt();
                    UprightPiano up = new UprightPiano(name, purchase_p, selling_p, length, width, keys);
                    System.out.print("Does it have a silent option? 1 (yes) or 2 (no): ");
                    up.setSilence(sc.nextInt()==1);
                    System.out.print("Does it have straight or crossed strings? 1 (straight) or 2 (crossed)");
                    instruments.add(up);
                    break;
                case 4:
                    System.out.print("Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("Give out its number of keys (minimum 25, maximum 88): ");
                    keys = sc.nextInt();
                    DigitalPiano dp = new DigitalPiano(name, purchase_p, selling_p, length, width, keys);
                    System.out.print("Does it have a heavy-touch system? 1 (yes) or 2 (no): ");
                    dp.setHeavyTouch(sc.nextInt()==1);
                    System.out.print("Give it the sampling quality of your choice, 1 2 or 3: ");
                    dp.setsQuality(sc.nextInt());
                    instruments.add(dp);
                    break;
                case 5:
                    System.out.print("Give it a length: ");
                    length = sc.nextInt();
                    System.out.print("Give it a width: ");
                    width = sc.nextInt();
                    System.out.print("Give out its number of keys (minimum 25, maximum 88): ");
                    keys = sc.nextInt();
                    GrandPiano gp = new GrandPiano(name, purchase_p, selling_p, length, width, keys);
                    System.out.print("Chose the grand size of your choice:\n1. '4/4'\n2. '1/2'\n3. '1/4'\n4. 'Crapaud'");
                    gp.setSize(sc.nextInt());
                    instruments.add(gp);
                    break;
                case 6:
                    WindInstru flute = new WindInstru(name,purchase_p, selling_p, "FLUTE");
                    instruments.add(flute);
                    break;
                case 7:
                    WindInstru clarinet = new WindInstru(name,purchase_p, selling_p, "CLARINET");
                    instruments.add(clarinet);
                    break;
                case 8:
                    WindInstru oboe = new WindInstru(name,purchase_p, selling_p, "OBOE");
                    instruments.add(oboe);
                    break;
            }
            System.out.println("Instrument "+(i+1)+", "+name+", has been added.");
        }
        System.out.println("All instruments have been added.");
        return instruments;
    }

    /**
     * Functions to do the occupant booking of hotel room or apartment
     * @param sc : scanner to get interaction with user/future occupant
     * @param occupant : occupant objet storing user/future personal info
     * @param hotel : arraylist of all hotel available
     */
    public static void mRRHotel(Scanner sc, Occupant occupant, ArrayList<Building> hotel) { //booking a room for occupant //TODO: after mCBHotel()
    }

    /**
     * @param apartment_building: : arraylist of all apartment buildings available
     */
    public static void mRRApartment(Scanner sc, Occupant occupant, ArrayList<Building> apartment_building) {//booking an apt for occupant //TODO: after mCBHotel()
    }

// TESTS //TODO: ALL TESTS ARE NOT MADE

    //method printing out the result of the test in console: '>' when all is good, '!' when a problem occurs
    private static void printResult(boolean check) throws InterruptedException {
        //TimeUnit.MILLISECONDS.sleep(250);
        if (check) System.out.print(">");
        else System.out.print("!");
    }
    //test method for the profile creation: owners, renters/occupants, and unspecified-role people
    static void testPerson() throws InterruptedException {
        //verify you can create empty profiles
        System.out.print("   ");
        Person p0 = new Person();
        Owner own0 = new Owner();
        Occupant occ0 = new Occupant();
        printResult(p0.getName().equalsIgnoreCase(""));
        printResult(p0.getSurname().equalsIgnoreCase(""));
        printResult(own0.getName().equalsIgnoreCase(""));
        printResult(own0.getBuildings().isEmpty());
        printResult(occ0.getName().equalsIgnoreCase(""));
        printResult(occ0.getRent()==null);
        //verify you can set name-infos
        p0.setName("Maria"); p0.setSurname("Carmen");
        own0.setName("James"); own0.setSurname("Bond");
        occ0.setName("Jack"); occ0.setSurname("Sparrow");
        printResult(p0.getName().equalsIgnoreCase("MARIA"));
        printResult(own0.getSurname().equalsIgnoreCase("BOND"));
        printResult(occ0.getName().equalsIgnoreCase("JACK"));
        //verify full constructors works
        Person p1 = new Person("Santa", "Clous");
        Owner own1 = new Owner("Harry", "Potter");
        Hotel build = new Hotel(1);
        Occupant occ1 = new Occupant("John", "Lennon", build, 8);
        printResult(p1.getSurname().equalsIgnoreCase("CLOUS"));
        printResult(own1.getName().equalsIgnoreCase("HARRY"));
        printResult(occ1.getSurname().equalsIgnoreCase("lennon"));
        printResult(occ1.getNoRoom() == 8);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    // test method for all building creation, with their specificities
    public static void testBuilding() throws InterruptedException {
        System.out.print("   ");
        //verify all buildings can be created empty
        House hou0 = new House();
        Hotel hot0 = new Hotel();
        Store sto0 = new Store();
        ApartmentBuilding flat0 = new ApartmentBuilding();
        printResult(!hou0.toString().isEmpty());
        printResult(!hot0.toString().isEmpty());
        printResult(!sto0.toString().isEmpty());
        printResult(!flat0.toString().isEmpty());
        //verify that with-parameters constructors works, for main and subclasses
        Owner James = new Owner("James", "Bond");
        ArrayList<Instrument> insts = new ArrayList<>();
        House hou1 = new House("21 baker street", 120, 6, 500, James);
        Hotel hot1 = new Hotel("666 devil road", 444, 3, James);
        Store sto1 = new Store("79 holly street", 123, James, insts);
        ApartmentBuilding flat1 = new ApartmentBuilding("911 help boulevard", 218, 6,James);
        printResult(hou1.getAddress().equalsIgnoreCase("21 BAKER STREET"));
        printResult(hou1.getGardenArea() == (float)500);
        printResult(hou1.getNbPart()==6);
        printResult(hot1.getLivingSpace()== (float)444);
        printResult(hot1.getNbStars() == 3);
        printResult(sto1.getInstruments().isEmpty());
        printResult(sto1.getOwner().getName().equalsIgnoreCase("JAMES"));
        printResult(flat1.getNbApart() == 6);
        //verify differences between stars hotels
        hot1.setNbPool(2);hot1.setNbSpa(2); hot1.setNbSuite(2); //should keep everything at 0
        Hotel hot2 = new Hotel(4);
        hot2.setNbPool(5); hot2.setNbSuite(3); hot2.setNbSpa(8); //should only change nbSpa to 8 and nbPool to 1
        Hotel hot3 = new Hotel(5);
        hot3.setNbPool(5); hot3.setNbSuite(3); hot3.setNbSpa(5);//should only change nbPool to 5 and nbSuite to 3
        printResult(hot1.getNbRoom() == 20);
        printResult(hot2.getNbRoom() == 25);
        printResult(hot3.getNbRoom() == 30);
        printResult(hot1.getNbStars()==3 && hot1.getNbPool()==0 && hot1.getNbSpa()==0 && hot1.getNbSuite()==0);
        printResult(hot2.getNbStars()==4 && hot2.getNbPool()==1 && hot2.getNbSuite()==0 && hot2.getNbSpa()==8);
        printResult(hot3.getNbStars()==5 && hot3.getNbPool()==5 && hot3.getNbSuite()==3 && hot3.getNbSpa()==0);
        // test equals :
        // ApartmentBuilding
        Occupant occ1 = new Occupant("John", "Lennon");
        Building Ap1 = new ApartmentBuilding("12 av jsp", 152, 20, James);
        Building Ap2 = new ApartmentBuilding("12 av jsp", 152, 20, James);
        try{
            ((ApartmentBuilding) Ap1).rent(occ1, 5);
        }catch (Exception e){
            System.out.println("Error in testBuilding: "+e.getMessage());
        }
        printResult(Ap1.equals(Ap2));
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }
    //test method for relations between people-rental/owning-building
    static void testRelation1() throws InterruptedException {
        System.out.print("   ");
        // Test that owner has list all the buildings he/she owns
        Person debby = new Owner("Debby", "Lité");
        ArrayList<Instrument> instru = new ArrayList<Instrument>();
        Building B1 = new House("7 av trkl", 120, 5, 500, (Owner)debby);
        Building B2 = new Store("12 bd mele-mele", 50, (Owner)debby, instru);
        Building B3 = new Hotel("45 ad fr", 540, 2, (Owner)debby);
        Building B4 = new ApartmentBuilding("56 st here", 804, 24, (Owner)debby);
        printResult(((Owner) debby).getBuildings().size()==4);
        printResult(((Owner) debby).getBuildings().contains(B1));
        printResult(((Owner) debby).getBuildings().contains(B2));
        printResult(((Owner) debby).getBuildings().contains(B3));
        printResult(((Owner) debby).getBuildings().contains(B4));
        // Test fonction setOwner
        Person test = new Owner("jean", "Paul");
        Person owner2 = new Owner("Luc", "Voila");
        Building building = new House();
        building.setOwner((Owner)test);
        printResult(building.getOwner().getSurname().equalsIgnoreCase("PAUL"));
        printResult(((Owner) test).getBuildings().contains(building) && ((Owner) test).getBuildings().size()==1);
        building.setOwner((Owner)owner2);
        printResult(building.getOwner().getName().equalsIgnoreCase("LUC"));
        printResult(!((Owner) test).getBuildings().contains(building) && ((Owner) test).getBuildings().size()==0);
        printResult(((Owner) owner2).getBuildings().contains(building) && ((Owner) owner2).getBuildings().size()==1);
        // test rental of a Hotel room
        Building H1 = new Hotel("15 av Repu", 500, 3, (Owner)test);
        Building H2 = new Hotel("14 bd Monod", 12, 1, (Owner)test);
        Person voila = new Occupant("Jean", "Dujardin");
        try{
            ((Hotel)H2).rent((Occupant)voila, 10);
            ((Hotel)H2).stopRent((Occupant) voila);
            ((Hotel)H1).rent((Occupant)voila, 10);
        }catch (Exception e){
            printResult(false);
        }
        try{
            ((Hotel)H2).rent((Occupant) voila, 11);
            printResult(false); // if the line bellow don't throw an exception
        }catch (Exception e){
            printResult(true); // suppose to throw an exception
        }
        printResult(((Occupant)voila).getRent() == H1 && ((Occupant)voila).getNoRoom() == 10);
        printResult(((Hotel)H1).getRentals().containsKey(10) && ((Hotel)H1).getRentals().containsValue(voila));
        try{
            ((Hotel)H1).stopRent((Occupant) voila);
        }catch (Exception e){
            printResult(false);
        }
        // test rental in an ApartmentBuilding
        Building A1 = new ApartmentBuilding("15 av Repu", 500, 3, (Owner)test);
        try{
            ((ApartmentBuilding)A1).rent((Occupant)voila, 10); // suppose to throw an exception because the room doesn't exist
        }catch (Exception e){
            printResult(true);
        }
        try{
            ((ApartmentBuilding)A1).rent((Occupant)voila, 2);
            ((ApartmentBuilding)A1).stopRental((Occupant) voila);
            ((ApartmentBuilding)A1).rent((Occupant)voila, 2);
        }catch (Exception e){
            printResult(false);
        }
        System.out.print(" ");
        printResult(false);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for all instrument creation, and their specificities
    static void testInstrument() throws InterruptedException {
        System.out.print("   ");
        Instrument test = new AcousticGuitar();
//        System.out.println(test.toString());
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for relations between  store and instruments
    static void testRelation2() throws InterruptedException {
        System.out.print("   ");
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }
}
