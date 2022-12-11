/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  The main loop of the application
 */
import Buildings.*;
import Instrument.*;
import Person.*;

import java.util.ArrayList;
import java.util.Scanner;
// if not used at the end of the project, we can remove the import
/*
* The main class is used to verify that the whole project is working without errors
*/
public class Main {
    protected static ArrayList<Building> residence = new ArrayList<Building>();
    protected static ArrayList<Person> population = new ArrayList<Person>();
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println();
        Building hot = new Hotel();
        Person James = new Person("Bond", "James");
        James = new Owner(James.getName(), James.getSurname());
        House hou = new House("21 baker street", 120, 6, 500, (Owner)James); // toString of Owner not created yet so print is not correct
        ApartmentBuilding flatBlock = new ApartmentBuilding();
        Store sto = new Store();
        System.out.println("building classes created.");
        System.out.println(hou.toString());
        Instrument test = new AcousticGuitar();
        System.out.println(test.toString());
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


        // MAIN LOOP
        Scanner sc = new Scanner(System.in);
        System.out.println("########### WELCOME TO MELE-MELE ISLAND ###########" +"\n");
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
                    Functions.infoBuilding(sc, population); // to set the info common to all buildings
            }
            break;
        }
    }
}