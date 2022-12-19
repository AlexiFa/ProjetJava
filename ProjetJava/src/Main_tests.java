import Buildings.*;
import Person.*;
import Instrument.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main_tests {
    // created to test the methods which just print, so we check manually if it works
    protected static HashMap<String, ArrayList<Building>> residence = new HashMap<String, ArrayList<Building>>();
    protected static HashMap<Person, Person[]> population = new HashMap<Person, Person[]>();
    public static void main(String[] args) throws InterruptedException {
        //first, testing that all classes, functions and variables are working correctly. All testing methods are in Functions
        Functions_tests.LaunchingTests(); //TODO: tests functions not complete
        // Setup to test the print methods
        Scanner sc;
        System.out.println("\n#############################################################");
        residence.put("House",new ArrayList<Building>()); //create empty residence
        residence.put("Hotel", new ArrayList<Building>());
        residence.put("Apartment Building", new ArrayList<Building>());
        residence.put("Store", new ArrayList<Building>());

        // test afficher les buildings d'un owner
        Owner owner = new Owner("Alexis", "Faure");
        ApartmentBuilding a1 = new ApartmentBuilding("a1", 10, 100, owner);
        Hotel h2 = new Hotel("h2", 100, 2, owner);
        Hotel h3 = new Hotel("h3", 100, 5, owner);
        h3.setNbSuite(10); // 30 rooms and 10 suites
        residence.get("Apartment Building").add(a1);
        residence.get("Hotel").add(h2);
        residence.get("Hotel").add(h3);
        Occupant occupant = new Occupant("Rebecca", "Morel");
        Occupant occupant2 = new Occupant("Marion", "Galfard");
        Occupant occupant3 = new Occupant("Vinciane", "Loy");
        Occupant occupant4 = new Occupant("Romain", "Léoture");
        try{
            h2.rent(occupant, 1);
            h2.rent(occupant2, 2);
            a1.rent(occupant3, 1);
            a1.rent(occupant4, 2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Functions.printAllRented(residence);
        Functions.printRoomsAvailable(h2); // test for a 2 stars hotel
        Functions.printRoomsAvailable(h3); // test for a 5 stars hotel
    }
}
