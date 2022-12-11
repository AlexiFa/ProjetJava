/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
import Buildings.*;
import Instrument.*;
import Person.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Scanner;
// if not used at the end of the project, we can remove the import
/*
* The main class is used to verify that the whole project is working without errors
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println();
        Building hot = new Hotel();
        Person James = new Person("Bond", "James");
        James = new Owner(James.getName(), James.getSurname(), hot);
        House hou = new House("21 baker street", 120, 6, 500, (Owner)James); // toString of Owner not created yet so print is not correct
        ApartmentBuilding flatBlock = new ApartmentBuilding();
        Store sto = new Store();
        System.out.println("building classes created.");
        System.out.println(hou.toString());


        // MAIN LOOP
        Scanner sc = new Scanner(System.in);
        System.out.println("########### WELCOME TO MELE-MELE ISLAND ###########");
        System.out.println();
        System.out.println("What is your name (you will be the default owner of each building you create)");
        System.out.print("Name :");
        String name = sc.nextLine();
        System.out.print("Surname :");
        String surname = sc.nextLine();
        Person admin = new Person(name, surname);
        ArrayList<Building> residence;

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
                    System.out.println("Enter the address of the house");
            }
            break;
        }
    }
}