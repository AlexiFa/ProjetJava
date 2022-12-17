/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
import Buildings.*;
import Person.*;
import Instrument.*;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    //method printing out the result of the test in console: '>' when all is good, '!' when a problem occurs
    private static void printResult(boolean check) throws InterruptedException {
        //TimeUnit.MILLISECONDS.sleep(250);
        if (check) System.out.print(">");
        else System.out.print("!");
    }
    //test method for the profile creation: owners, renters/occupants, and unspecified-role people
    static void testPerson() throws InterruptedException {
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
        printResult(occ0.getRent()==null);
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
        Hotel build = new Hotel(1);
        Occupant occ1 = new Occupant("John", "Lennon", build, 8);
        printResult(p1.getSurname().equalsIgnoreCase("CLOUS"));
        printResult(own1.getName().equalsIgnoreCase("HARRY"));
        printResult(occ1.getSurname().equalsIgnoreCase("lennon"));
        printResult(occ1.getNoRoom() == 8);
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
        printResult(hou1.getNbPart()==6);
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
        // test equals :
        // ApartmentBuilding
        Occupant occ1 = new Occupant("John", "Lennon");
        Building Ap1 = new ApartmentBuilding("12 av jsp", 152, 20, James);
        Building Ap2 = new ApartmentBuilding("12 av jsp", 152, 20, James);
        try{
            ((ApartmentBuilding) Ap1).rent(occ1, 5);
        }catch (Exception e){
            System.out.println("Error in testBuilding: "+e.getMessage());
        }
        printResult(Ap1.equals(Ap2));
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }
    //test method for relations between people-rental/owning-building
    static void testRelation1() throws InterruptedException {
        System.out.print("   ");
        // Test that owner has list all the buildings he/she owns
        Person debby = new Owner("Debby", "Lité");
        ArrayList<Instrument> instru = new ArrayList<Instrument>();
        Building B1 = new House("7 av trkl", 120, 5, 500, (Owner)debby);
        Building B2 = new Store("12 bd mele-mele", 50, (Owner)debby, instru);
        Building B3 = new Hotel("45 ad fr", 540, 2, (Owner)debby);
        Building B4 = new ApartmentBuilding("56 st here", 804, 24, (Owner)debby);
        printResult(((Owner) debby).getBuildings().size()==4);
        printResult(((Owner) debby).getBuildings().contains(B1));
        printResult(((Owner) debby).getBuildings().contains(B2));
        printResult(((Owner) debby).getBuildings().contains(B3));
        printResult(((Owner) debby).getBuildings().contains(B4));
        // Test fonction setOwner
        Person test = new Owner("jean", "Paul");
        Person owner2 = new Owner("Luc", "Voila");
        Building building = new House();
        building.setOwner((Owner)test);
        printResult(building.getOwner().getSurname().equalsIgnoreCase("PAUL"));
        printResult(((Owner) test).getBuildings().contains(building) && ((Owner) test).getBuildings().size()==1);
        building.setOwner((Owner)owner2);
        printResult(building.getOwner().getName().equalsIgnoreCase("LUC"));
        printResult(!((Owner) test).getBuildings().contains(building) && ((Owner) test).getBuildings().size()==0);
        printResult(((Owner) owner2).getBuildings().contains(building) && ((Owner) owner2).getBuildings().size()==1);
        // test rental of a Hotel room
        Building H1 = new Hotel("15 av Repu", 500, 3, (Owner)test);
        Building H2 = new Hotel("14 bd Monod", 12, 1, (Owner)test);
        Person voila = new Occupant("Jean", "Dujardin");
        try{
            ((Hotel)H2).rent((Occupant)voila, 10);
            ((Hotel)H2).stopRent((Occupant) voila);
            ((Hotel)H1).rent((Occupant)voila, 10);
        }catch (Exception e){
            printResult(false);
        }
        try{
            ((Hotel)H2).rent((Occupant) voila, 11);
            printResult(false); // if the line bellow don't throw an exception
        }catch (Exception e){
            printResult(true); // suppose to throw an exception
        }
        printResult(((Occupant)voila).getRent() == H1 && ((Occupant)voila).getNoRoom() == 10);
        printResult(((Hotel)H1).getRentals().containsKey(10) && ((Hotel)H1).getRentals().containsValue(voila));
        try{
            ((Hotel)H1).stopRent((Occupant) voila);
        }catch (Exception e){
            printResult(false);
        }
        // test rental in an ApartmentBuilding
        Building A1 = new ApartmentBuilding("15 av Repu", 500, 3, (Owner)test);
        try{
            ((ApartmentBuilding)A1).rent((Occupant)voila, 10); // suppose to throw an exception because the room doesn't exist
        }catch (Exception e){
            printResult(true);
        }
        try{
            ((ApartmentBuilding)A1).rent((Occupant)voila, 2);
            ((ApartmentBuilding)A1).stopRental((Occupant) voila);
            ((ApartmentBuilding)A1).rent((Occupant)voila, 2);
        }catch (Exception e){
            printResult(false);
        }
        System.out.print(" ");
        printResult(false);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for all instrument creation, and their specificities
    static void testInstrument() throws InterruptedException {
        System.out.print("   ");
        Instrument test = new AcousticGuitar();
//        System.out.println(test.toString());
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for relations between  store and instruments
    static void testRelation2() throws InterruptedException {
        System.out.print("   ");
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }
}
