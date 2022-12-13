/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
import Person.*;
import Instrument.*;
import Person.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    public static void infoBuilding(Scanner sc, ArrayList<Person> population){
        System.out.println("Address :");
        String address = sc.nextLine() + sc.nextLine(); // because after the nextInt, the line is not finished, so it takes the end of the line ("") so we add the nextLine()
        System.out.println("Living space :");
        String livingSpace = sc.nextLine();
        System.out.println("Owner :");
        Functions.printAllPerson(sc, population);
    }

    /**
     * Function to print all people in the residence who can be owner (who are not occupant)
     * @param owners : all the person added to the residence
     */
    public static void printAllPerson(Scanner sc, ArrayList<Person> owners){ // ATTENTION A TESTER
        int i = 0;
        for (Person people : owners){
            if (people instanceof Occupant)
                continue;
            System.out.println(i + " " + people.toString()); // TODO : fct Person.toString()
            i++;
            int choice = sc.nextInt();
        }
    }
}
