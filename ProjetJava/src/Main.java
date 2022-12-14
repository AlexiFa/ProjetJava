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
            System.out.println("Please enter your name to log in:"); //adding the main guy, asking his infos
            System.out.print("First Name :");
            String name = sc.nextLine();
            System.out.print("Last Name :");
            String lastName = sc.nextLine();
            Person admin = new Person(name, lastName);
            population.add(admin);            //adding him in the overall population of the island
            System.out.println("\n_____________________________________________________________");
            stay_in_app = mainMenu(sc, admin);
        }
    }
    public static boolean mainMenu(Scanner sc, Person admin) throws InterruptedException {
        boolean loop=true;
        while(loop){
            System.out.println("\nWelcome "+ admin.getName()+" "+ admin.getSurname());
            System.out.println("What do you want to do :\n");
            System.out.println("1. Own/Create/Buy a building");
            System.out.println("2. Rent an apartment or hotel room");
            System.out.println("3. Buy an instrument in an existing store");
            System.out.println("4. Log out\n");
            int choice = sc.nextInt();
            switch (choice){
            case 1:
                Owner owner = new Owner(admin);
                menuBuilding(sc, owner);
                break;
            case 2: break; //fonction menuRenting()
            case 3: break; //fonction menuBuyInStore()
            case 4: //quit the mainMenu() loop
                System.out.println("Also quit app? Enter 0 to confirm");
                int q = sc.nextInt();
                if (q == 0) { //PATH TO QUIT PROGRAM
                    System.out.println("THANK YOU FOR VISITING MELE-MELE ISLAND RESIDENCE!\n");
                    System.out.println("#############################################################");
                    stay_in_app = false; //MARK THE BREAK OF THE while() in method main()
                }
                else { //back into while loop in main()
                    System.out.print("\nYou have been successfully logged out,\nGoing back to log-in space");
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

    public static void menuBuilding(Scanner sc, Owner owner){
        System.out.println("Which type of building do you want to own?");
        System.out.println();
        System.out.println("1. Create a house");
        System.out.println("2. Create a hotel");
        System.out.println("3. Create a store");
        System.out.println("4. Create a building");
        int choice = sc.nextInt();
        switch (choice){
            case 1: Functions.infoBuilding(sc, population);// to set the info common to all buildings
            case 2:;
            case 3:;
            case 4:;
        }
    }
}
