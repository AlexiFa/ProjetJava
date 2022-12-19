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

/**
 * Index of all the functions todo when all the functions are done
 *
 */

public class Functions {

    /**
     * Function to print out all people in the residence
     *
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
     *
     * @param residence : all the buildings added to the residence
     */
    public static void printAllBuildings(HashMap<String, ArrayList<Building>> residence) {
        System.out.println("\nBuildings List:");
        System.out.println("----------------------------------------------");
        for (String key : residence.keySet()) {
            int i = 1;
            System.out.println("All " + key + "s: ");
            for (Building build : residence.get(key)) {
                System.out.println(" " + i + ". " + build.toString());
                i++;
            }
            System.out.print("\n");
        }
        System.out.println("----------------------------------------------");
    }

    /**
     * TODO : this function has been tested in main but hasn't a proper like test auto (don't know if we need to do one, if not : delete this TODO comment)
     * TODO : maybe add the functionality to do it in the main loop
     * Function to printo out the buildings of a specific owner
     *
     * @param owner : the owner we want to print the buildings
     */
    public static void printBuildingsOwned(Owner owner) {
        System.out.println("\nBuildings List of " + owner + ":");
        System.out.println("----------------------------------------------");
        int i = 1;
        for (Building building : owner.getBuildings()) {
            System.out.println(" " + i + ". " + building.toString());
            i++;
        }
        System.out.println("----------------------------------------------");
    }

    /**
     * TODO : function finished i think (check if the tests in main are good enough)
     * TODO : en fait pas sur car dans l'enoncé il met juste les appart et afficher les room/suites dispo (donc le modif pour ne faire que les appart)
     * Function to list all the rooms and flats rented
     */
    public static void printAllRented(HashMap<String, ArrayList<Building>> residence) {
        System.out.println("\nRented Rooms and Flats:");
        System.out.println("----------------------------------------------");
        for (String key : residence.keySet()) {
            int i = 1;
            if (key.equals("Hotel") || key.equals("Apartment Building")) {
                System.out.println("All " + key + "s: ");
                for (Building build : residence.get(key)) { // for each Hotel or Apartment Building in the residence
                    if (build instanceof Hotel) {
                        for (Integer noRoom : ((Hotel) build).getRentals().keySet()) { // for each room rented in the hotel
                            System.out.println(" " + i + ". " + ((Hotel) build).getRentals().get(noRoom).toString());
                            i++;
                        }
                    } else if (build instanceof ApartmentBuilding) {
                        for (Integer noFlat : ((ApartmentBuilding) build).getRentals().keySet()) { // for each flat rented in the apartment building
                            System.out.println(" " + i + ". " + ((ApartmentBuilding) build).getRentals().get(noFlat).toString());
                            i++;
                        }
                    }
                }
                System.out.println();
            }
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

    public static Hotel mCBHotel(Scanner sc, Owner owner) { //creation of a hotel and return it //TODO

        return new Hotel();
    }

    public static ApartmentBuilding mCBApartment(Scanner sc, Owner owner) { // creation of an apartment building and return it
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

    public static Store mCBStore(Scanner sc, Owner owner) { //creation of a store and return it
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
     *
     * @param sc
     * @return arraylist with all instruments that will go with the store
     */
    public static ArrayList<Instrument> addInstruments(Scanner sc) {
        ArrayList<Instrument> instruments = new ArrayList<Instrument>();
        System.out.print("How many instruments do you want to add ?\nEnter a number: ");
        int nb = sc.nextInt();
        sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
        for (int i = 0; i < nb; i++) {
            System.out.println("Instrument " + (i + 1));
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
            switch (intr) {
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
                    up.setSilence(sc.nextInt() == 1);
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
                    dp.setHeavyTouch(sc.nextInt() == 1);
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
                    WindInstru flute = new WindInstru(name, purchase_p, selling_p, "FLUTE");
                    instruments.add(flute);
                    break;
                case 7:
                    WindInstru clarinet = new WindInstru(name, purchase_p, selling_p, "CLARINET");
                    instruments.add(clarinet);
                    break;
                case 8:
                    WindInstru oboe = new WindInstru(name, purchase_p, selling_p, "OBOE");
                    instruments.add(oboe);
                    break;
            }
            System.out.println("Instrument " + (i + 1) + ", " + name + ", has been added.");
        }
        System.out.println("All instruments have been added.");
        return instruments;
    }

    /**
     * Functions to do the occupant booking of hotel room or apartment
     *
     * @param sc       : scanner to get interaction with user/future occupant
     * @param occupant : occupant objet storing user/future personal info
     * @param hotel    : arraylist of all hotel available
     */
    public static void mRRHotel(Scanner sc, Occupant occupant, ArrayList<Building> hotel) { //booking a room for occupant //TODO: after mCBHotel()
    }

    /**
     * @param apartment_building: : arraylist of all apartment buildings available
     */
    public static void mRRApartment(Scanner sc, Occupant occupant, ArrayList<Building> apartment_building) {//booking an apt for occupant //TODO: after mCBHotel()
    }

}