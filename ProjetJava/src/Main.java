/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  The main loop of the application
 */
import Buildings.*;
import Instrument.*;
import Person.*;
import Rental.Rental;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// if not used at the end of the project, we can remove the import
/*
* The main class is used to verify that the whole project is working without errors
*/
public class Main {
    protected static HashMap<String, ArrayList<Building>> residence = new HashMap<String, ArrayList<Building>>();
    protected static HashMap<Person, Person[]> population = new HashMap<Person, Person[]>();
    protected static boolean stay_in_app =true;
    public static void main(String[] args) throws InterruptedException {
        //first, testing that all classes, functions and variables are working correctly. All testing methods are below
        System.out.println("=============================================================");
        System.out.print("               Verifying application structure               \n");
        System.out.println("-------------------------------------------------------------");
        System.out.print("-- Testing profile creation:\n");
        Functions.testPerson();
        System.out.print("-- Testing buildings creation:\n");
        Functions.testBuilding();
        System.out.print("-- Testing relations person and buildings:\n");
        Functions.testRelation1();
        System.out.print("-- Testing instruments creation:\n");
        Functions.testInstrument();
        System.out.print("-- Testing relations store and instruments:\n");
        Functions.testRelation2();
        System.out.println("-------------------------------------------------------------");
        System.out.print("                      Verification over                      \n");
        System.out.println("=============================================================");

        // MAIN LOOP: Start Application
        Scanner sc;
        System.out.println("\n#############################################################");
        while(stay_in_app){
            sc = new Scanner(System.in);
            System.out.println("\nWELCOME TO MELE-MELE ISLAND RESIDENCE\n");
            System.out.println("Please enter your name to log in:"); //registering user, asking his information
            System.out.print("First Name :");
            String name = sc.nextLine();
            System.out.print("Last Name :");
            String lastName = sc.nextLine();
            Person admin = new Person(name, lastName);  //TODO: régler l'apparition de doublons dans Hashmap
            population.putIfAbsent(admin, new Person[]{null,null}); //adding user to rez BUT verify if already registered, old information stays
            System.out.println("\n_____________________________________________________________");
            stay_in_app = mainMenu(sc, admin);
        }
    }
    public static boolean mainMenu(Scanner sc, Person admin) throws InterruptedException {
        boolean loop=true;
        System.out.println(admin.getName()+" "+ admin.getSurname()+", You have been successfully logged in !");
        while(loop){
            System.out.println("\nYOUR MAIN MENU\n");
            System.out.println(">> Enter a digit to choose what to do:\n");
            System.out.println("0. Get a list of all people in Mele-Mele Island Residence");
            System.out.println("1. Own/Create/Buy a building (function incoming)");
            System.out.println("2. Rent an apartment or a hotel room (function incoming)");
            System.out.println("3. Buy an instrument in an existing store (not done)"); //to implement when all is done
            System.out.println("4. Log out\n");
            int choice = sc.nextInt();
            switch (choice) {
            case 0://list all Persons, with reference to owner/occupant information.
                Functions.printAllPerson(population);
                break;
            case 1:
                Owner owner = new Owner(admin);
                population.get(admin)[0] = owner;
                menuCreateBuilding(sc, owner); //function menuCreateBuilding //TODO:
                break;
                case 2:
                Occupant occupant = new Occupant(admin.getName(), admin.getSurname());
                population.get(admin)[1] = occupant;
                menuRentRoom(sc, occupant); //function menuRenting()                     //TODO:
                break;
            case 3:
                menuBuyInStore(sc, admin); //function menuBuyInStore()          //TODO:
                break;
            case 4: //quit the mainMenu() loop
                System.out.println("Do you want to also exit the program? Enter 0 to confirm");
                int q = sc.nextInt();
                if (q == 0) { //PATH TO QUIT PROGRAM
                    System.out.println("\nTHANK YOU FOR VISITING MELE-MELE ISLAND RESIDENCE!\n");
                    System.out.println("#############################################################");
                    stay_in_app = false; //MARK THE BREAK OF THE while() in method main()
                }
                else { //back into while loop in main()
                    System.out.print("\nYou have been successfully logged out !\nGoing back to login space");
                    TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                    TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                    TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                    System.out.println("\n_____________________________________________________________");
                }
                loop = false;
                break;
            }
        }
        return stay_in_app; //return if breaking or not the main application loop
    }

    public static void menuCreateBuilding(Scanner sc, Owner owner){        //TODO:
        System.out.println("Which type of building do you want to own?");
        System.out.println();
        System.out.println("1. Create a house");
        System.out.println("2. Create a hotel");
        System.out.println("3. Create a apartment building");
        System.out.println("4. Create a store");
        int choice = sc.nextInt();
        switch (choice){
            case 1: Functions.mCBHouse(); break;   //Functions.infoBuilding(sc, population); //to redo, since population is not an arraylist anymore
            case 2: Functions.mCBHotel(); break;
            case 3: Functions.mCBApartment();break;
            case 4: Functions.mCBStore(); break;
        }
    }

    private static void menuRentRoom(Scanner sc, Occupant occupant) {
        System.out.println("What do you want to rent?");
        System.out.println();
        System.out.println("1. a Hotel room");
        System.out.println("2. an Apartment");
        int choice = sc.nextInt();
        switch (choice){
            case 1:break;
            case 2: break;
        }
    }
    private static void menuBuyInStore(Scanner sc, Person person){
        //
    }
}
