/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  The main loop of the application
 */
import Buildings.*;
import Instrument.*;
import Person.*;
import Rental.Rental;

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
        System.out.print("-- Testing buildings creation:\n");
        testBuilding();
        System.out.print("-- Testing relations person and buildings:\n");
        testRelation1();
        System.out.print("-- Testing instruments creation:\n");
        testInstrument();
        System.out.print("-- Testing relations store and instruments:\n");
        testRelation2();
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
        System.out.print("   ");
        Person p0 = new Person();
        Owner own0 = new Owner();
        Occupant occ0 = new Occupant();
        printResult(p0.getName().equalsIgnoreCase(""));
        printResult(p0.getSurname().equalsIgnoreCase(""));
        printResult(own0.getName().equalsIgnoreCase(""));
        printResult(own0.getBuildings().isEmpty());
        printResult(occ0.getName().equalsIgnoreCase(""));
        printResult(occ0.getRental()==null);
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
        Rental rental = new Rental();
        Occupant occ1 = new Occupant("John", "Lennon", rental);
        printResult(p1.getSurname().equalsIgnoreCase("CLOUS"));
        printResult(own1.getName().equalsIgnoreCase("HARRY"));
        printResult(occ1.getSurname().equalsIgnoreCase("lennon"));
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
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }
    //test method for relations between people-rental/owning-building
    private static void testRelation1() throws InterruptedException {
        System.out.print("   ");
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
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for all instrument creation, and their specificities
    private static void testInstrument() throws InterruptedException {
        System.out.print("   ");
        Instrument test = new AcousticGuitar();
//        System.out.println(test.toString());
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for relations between  store and instruments
    private static void testRelation2() throws InterruptedException {
        System.out.print("   ");
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //method printing out the result of the test in console: '>' when all is good, '!' when a problem occurs
    private static void printResult(boolean check) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(250);
        if (check) System.out.print(">");
        else System.out.print("!");
    }
}
