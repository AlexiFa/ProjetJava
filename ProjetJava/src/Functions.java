/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
import Buildings.*;
import Person.*;
import Instrument.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
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
        if (owner == null) {
            System.out.println("You don't have any buildings");
        }
        else {
            System.out.println("\nYour Buildings List:");
            System.out.println("----------------------------------------------");
            int i = 1;
            for (Building building : owner.getBuildings()) {
                System.out.println(" " + i + ". " + building.toString());
                i++;
            }
            System.out.println("----------------------------------------------");
        }
    }
    private static ArrayList<Owner> printAllExistingOwners(HashMap<Person,Person[]> population) {
        ArrayList<Owner> owners = new ArrayList<Owner>();
        int i=1;
        for (Person person : population.keySet()){
            if (population.get(person)[0] != null) {
                owners.add((Owner) population.get(person)[0]);
                System.out.println(" "+i+". "+ population.get(person)[0].toString());
                i++;
            }
        }
        return owners;
    }

    public static void GiveOutBuilding(Scanner sc, Owner owner, HashMap<Person,Person[]> population) {
        printBuildingsOwned(owner);
        if(owner != null) {
            System.out.println("Choose your building to hand over (Enter the corresponding digit): ");
            int chosen_b = sc.nextInt();
            Building building = owner.getBuildings().get(chosen_b - 1);
            ArrayList<Owner> owners = printAllExistingOwners(population);
            System.out.println("Chose the owner you want to hand the building over to (Enter the corresponding digit): ");
            int chosen_o = sc.nextInt();
            Owner new_owner = owners.get(chosen_o - 1);
            building.setOwner(new_owner);
            System.out.println("Your building has been successfully assigned to " + new_owner.getName() + " "
                    + new_owner.getSurname() + " !");
        }
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
     * Function to list all the available flats in a building
     * @param aptBuilding : building targeted
     */
    public static void printAptsAvailable(ApartmentBuilding aptBuilding) {
        System.out.println("\nAvailable Apartments:");
        System.out.println("----------------------------------------------");
        for (int i = 1; i <= aptBuilding.getNbApart()-1; i++) {
            if (!aptBuilding.getRentals().containsKey(i)) {
                System.out.print(" " + i + ",");
            }
        }
        System.out.println(" " + aptBuilding.getNbApart());
        System.out.println("----------------------------------------------");
    }

    /**
     * Function to list all the rooms and flats rented by a specific owner
     * @param hotel : the hotel we want to print the rooms available
     */
    public static void printRoomsAvailable(Hotel hotel){
        System.out.println("\nAvailable Rooms in " + hotel + ":");
        System.out.println("----------------------------------------------");
        if (hotel.getNbStars()<5){
            for (int i = 1; i <= hotel.getNbRoom()-1; i++) { // for every room in the hotel
                if (!hotel.getRentals().containsKey(i)) { // if the room isn't in the rented list
                    System.out.print(" " + i + ",");
                }
            }
            System.out.println((!hotel.getRentals().containsKey(hotel.getNbRoom())) ? " " + hotel.getNbRoom() : "");
        } else if (hotel.getNbStars() == 5) {
            System.out.println("Rooms :");
            for (int i = 1; i <= hotel.getNbRoom()-1; i++) { // for every room in the hotel
                if (!hotel.getRentals().containsKey(i)) { // if the room isn't in the rented list
                    System.out.print(" " + i + ",");
                }
            }
            System.out.println((!hotel.getRentals().containsKey(hotel.getNbRoom())) ? " " + hotel.getNbRoom() : "");
            System.out.println("Suites :");
            for (int i = hotel.getNbRoom() + 1; i <= hotel.getNbRoom() + hotel.getNbSuite() - 1; i++) { // for every suite in the hotel
                if (!hotel.getRentals().containsKey(i)) { // if the suite isn't in the rented list
                    System.out.print(" " + i + ",");
                }
            }
            System.out.println((!hotel.getRentals().containsKey(hotel.getNbRoom() + hotel.getNbSuite())) ? " " + (hotel.getNbRoom() + hotel.getNbSuite()) : "");
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
        System.out.println("You chose to build a Hotel.\nTo complete your demand, please give us the following information:");
        System.out.print("> The Address: ");
        String address = sc.nextLine();
        System.out.print("> The size of the total living space: ");
        float liv_area = sc.nextFloat();
        System.out.print("> The number of stars your hotel has (between 1 and 5): ");
        int stars = sc.nextInt();
        if(stars > 5 || stars <1){
            System.out.print("An hotel with "+stars+" stars cannot exist in the rez. Please enter the right digit: ");
            stars = sc.nextInt();
        }
        Hotel hotel = new Hotel(address, liv_area, stars,owner);
        switch(stars){
            case 4:
                System.out.println("Since your hotel has 4 stars, we need a few more details.");
                System.out.print("> The number of spas: ");
                int spas = sc.nextInt();
                hotel.setNbSpa(spas);
                hotel.setNbPool(1);
                hotel.setNbSuite(0);
                break;
            case 5:
                System.out.println("Since your hotel has 5 stars, we need a few more details.");
                System.out.print("> The number of suites: ");
                int suites = sc.nextInt();
                System.out.print("> The number of pools: ");
                int pools = sc.nextInt();
                hotel.setNbSuite(suites);
                hotel.setNbPool(pools);
                hotel.setNbSpa(0);
                break;
            default:
                break;
        }
        System.out.print("Thank you. ");
        return hotel;
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
        System.out.print("> Please chose a few instruments to add to your store:\n");
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
    public static void mRRHotel(Scanner sc, Occupant occupant, ArrayList<Building> hotel) throws Exception{ //booking a room for occupant //TODO: after mCBHotel()
        System.out.println("You chose to book a room in a hotel.\nHere are all the hotels with rooms available:");
        System.out.println("----------------------------------------------");
        int i = 1;
        for (Building hotel1 : hotel){
            System.out.println(" " + i + " " + hotel1);
            i++;
        }
        System.out.println("----------------------------------------------");
        System.out.println("Please enter the number of the hotel you want to book a room in:");
        int hotelChoice = sc.nextInt();
        sc.nextLine();
        printRoomsAvailable((Hotel) hotel.get(hotelChoice - 1)); // print all the rooms available in the hotel
        System.out.println("Please enter the number of the room you want to book:");
        int roomChoice = sc.nextInt();
        sc.nextLine();
        ((Hotel)hotel.get(hotelChoice - 1)).rent(occupant, roomChoice); // book the room
    }

    /**
     * Functions to do the occupant booking of an apartment
     * @param sc : scanner to get interaction with user/future occupant
     * @param occupant : occupant who book the flat
     * @param apartment_building: : arraylist of all apartment buildings available
     * @throws Exception : if the user enter a string instead of a number (for example)
     */
    public static void mRRApartment(Scanner sc, Occupant occupant, ArrayList<Building> apartment_building) throws Exception{//booking an apt for occupant //TODO: after mCBHotel()
        System.out.println("You chose to book an apartment in an apartment building.\nHere are all the apartment buildings:");
        System.out.println("----------------------------------------------");
        int i = 1;
        for (Building apartment_building1 : apartment_building){
            System.out.println(" " + i + " " + apartment_building1);
            i++;
        }
        System.out.println("----------------------------------------------");
        System.out.println("Please enter the number of the apartment building you want to book an apartment in:");
        int apartmentBuildingChoice = sc.nextInt();
        //sc.nextLine();

        printAptsAvailable((ApartmentBuilding) apartment_building.get(apartmentBuildingChoice - 1)); // print all the apartments available in the apartment building
        System.out.println("Please enter the number of the apartment you want to book:");
        int aptChoice = sc.nextInt();
        sc.nextLine();
        ((ApartmentBuilding)apartment_building.get(apartmentBuildingChoice - 1)).rent(occupant, aptChoice); // book the apartment
    }

    public static void mBISPrintAllStores(ArrayList<Building> stores) {
        int i=1;
        System.out.println("----------------------------------------------");
        for(Building store : stores){
            System.out.println(" "+i+". "+store.toString());
            i++;
        }
        System.out.println("----------------------------------------------");
    }
    public static void mBISPrintInstruInStore(ArrayList<Instrument> instruments) {
        int i=1;
        System.out.println("----------------------------------------------");
        for(Instrument instrument : instruments){
            System.out.println(" "+i+". "+instrument.toString());
            i++;
        }
        System.out.println("----------------------------------------------");
    }

    public static boolean mBISTry2Sell(Person person, Store store, Instrument chosen_one) {
        float i_price = chosen_one.getSellingPrice();
        float p_budget = person.getBudget();
        if (i_price > p_budget) {
            return false;
        }
        else {
            store.removeInstrument(chosen_one);
            float new_budget = p_budget - i_price;
            person.setBudget(new_budget);
            person.addInstrument(chosen_one);
            return true;
        }
    }
}