/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  The main loop of the application
 */
import Buildings.*;
import Instrument.*;
import Person.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// if not used at the end of the project, we can remove the import
/*
* The main class is used to verify that the whole project is working without errors
*/
public class Main {
    protected static ArrayList<Building> residence = new ArrayList<Building>();
    protected static ArrayList<Person> population = new ArrayList<Person>();
    public static void main(String[] args) throws InterruptedException {

        //first, testing that all classes, functions and variables are working correctly. All testing methods are below
        System.out.print("------------ Verifying application structure ------------\n");
        System.out.print("-- Testing profile creation:\n");
        testPerson();
        System.out.print("-- Testing instruments creation:\n");
        testInstrument();
        System.out.print("-- Testing buildings creation:\n");
        testBuilding();
        System.out.print("-- Testing relations:\n");
        testRelation();
        System.out.print("------------------- Verification over -------------------\n");

        // MAIN LOOP: Start Application
        Scanner sc = new Scanner(System.in);
        System.out.println("\n############ WELCOME TO MELE-MELE ISLAND ############\n");
        System.out.println("What is your name, dear real estate developer?"); //adding the main guy, asking his infos
        System.out.print(" First Name :");
        String name = sc.nextLine();
        System.out.print("Last Name :");
        String lastName = sc.nextLine();
        Person admin = new Owner(name, lastName); //he will be the default owner of all buildings created in the future
        population.add(admin); //adding him in the overall population of the island

        while(true){
            System.out.println();
            System.out.println("What do you want to do ?");
            System.out.println();
            System.out.println("1. Create a house");
            System.out.println("2. Create a hotel");
            System.out.println("3. Create a store");
            System.out.println("4. Create a building");
            int choice = sc.nextInt();
            switch (choice){
                case 1 :
                    Functions.infoBuilding(sc, population);// to set the info common to all buildings

            }
            break;
        }
    }

    //test method for the profile creation: owners, renters/occupants, and unspecified-role people


    private static void testPerson() throws InterruptedException {
        //verify you can create empty profiles
        Person p0 = new Person();
        Owner own0 = new Owner();
        Occupant occ0 = new Occupant();
        TimeUnit.MILLISECONDS.sleep(250);System.out.print("   >");

        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" Good To Go!\n");
    }
    //test method for all instrument creation, and their specificities
    private static void testInstrument() throws InterruptedException {
        Instrument test = new AcousticGuitar();
//        System.out.println(test.toString());
        TimeUnit.MILLISECONDS.sleep(250);System.out.print("   >");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" Good To Go!\n");
    }
    // test method for all building creation, with their specificities

    //        // Tests pour le setOwner
//        Person test = new Owner("jean", "Paul");
//        Person owner2 = new Owner("Luc", "Voila");
//        Building building = new House();
//        building.setOwner((Owner)test);
//        building.setOwner((Owner)owner2);
//        // Tests to list all the buildings of an owner
//        Person debby = new Owner("Debby", "Lité");
//        ArrayList<Instrument> instru = new ArrayList<Instrument>();
//        Building B1 = new House("7 av trkl", 120, 5, 500, (Owner)debby);
//        Building B2 = new Store("12 bd mele-mele", 50, (Owner)debby, instru);
//        Building B3 = new Hotel("45 ad fr", 540, 2, (Owner)debby);
//        Building B4 = new ApartmentBuilding("56 st here", 804, 24, (Owner)debby);
//        for (Building own : ((Owner)debby).getBuildings())
//            System.out.println(own.toString());
    public static void testBuilding() throws InterruptedException {
        //verify all buildings can be created empty
        House hou0 = new House();
        Hotel hot0 = new Hotel();
        Store sto0 = new Store();
        ApartmentBuilding flat0 = new ApartmentBuilding();
        TimeUnit.MILLISECONDS.sleep(250);System.out.print("   >");
        //verify you can add info to empty buildings

        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        //verify that with-parameters constructors works, for main and subclasses
        Person James = new Owner("Bond", "James");
        House hou1 = new House("21 baker street", 120, 6, 500, (Owner) James);
//        System.out.println(hou.toString());
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" Good To Go!\n");
    }
    //test method for relations between people-rental-building and store-instruments
    private static void testRelation() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(250);System.out.print("   >");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" Good To Go!\n");
    }
}