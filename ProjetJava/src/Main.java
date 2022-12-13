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
        Functions.testPerson();
        System.out.print("-- Testing buildings creation:\n");
        Functions.testBuilding();
        System.out.print("-- Testing relations person and buildings:\n");
        Functions.testRelation1();
        System.out.print("-- Testing instruments creation:\n");
        Functions.testInstrument();
        System.out.print("-- Testing relations store and instruments:\n");
        Functions.testRelation2();
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
}
