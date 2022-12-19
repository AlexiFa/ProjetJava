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
     * Function to list all the rooms and flats rented
     * @param residence : all the buildings added to the residence
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
     * TODO : function not finished
     * Function to list all the rooms and flats rented by a specific owner
     * @param hotel : the owner we want to print the buildings
     */
    public static void printRoomsAvailable(Hotel hotel){
        System.out.println("\nAvailable Rooms in " + hotel + ":");
        System.out.println("----------------------------------------------");
        if (hotel.getNbStars()<5){
            for (int i = 1; i <= hotel.getNbRoom(); i++) { // for every room in the hotel
                if (!hotel.getRentals().containsKey(i)) { // if the room isn't in the rented list
                    System.out.println(" " + i);
                }
            }
        } else if (hotel.getNbStars() == 5) {
            System.out.println("Rooms :");
            for (int i = 1; i <= hotel.getNbRoom(); i++) { // for every room in the hotel
                if (!hotel.getRentals().containsKey(i)) { // if the room isn't in the rented list
                    System.out.println(" " + i);
                }
            }
            System.out.println("Suites :");
            //for (int i = hotel.getNbRoom())
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
        ArrayList<Instrument> instruments = new ArrayList<Instrument>();
        Store store = new Store(address, liv_area, owner, instruments);
        store.addInstruments(sc);
        System.out.print("Thank you. ");
        return store;
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