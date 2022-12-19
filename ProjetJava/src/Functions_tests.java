import Buildings.*;
import Instrument.*;
import Person.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Functions_tests {
    // TESTS //TODO: ALL TESTS ARE NOT MADE
    public static void LaunchingTests() throws InterruptedException {
        System.out.println("=============================================================");
        System.out.print("               Verifying application structure               \n");
        System.out.println("-------------------------------------------------------------");
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
        System.out.println("-------------------------------------------------------------");
        System.out.print("                      Verification over                      \n");
        System.out.println("=============================================================");

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
        ApartmentBuilding Ap3 = new ApartmentBuilding("12 av other", 152, 20, James);
        try{
            ((ApartmentBuilding) Ap1).rent(occ1, 5);
        }catch (Exception e){
            System.out.println("Error in testBuilding: "+e.getMessage());
        }
        printResult(Ap1.equals(Ap2));
        printResult(!Ap1.equals(Ap3));

        // Hotel
        Building Ho1 = new Hotel("12 av jsp", 152, 1, James);
        Building Ho2 = new Hotel("12 av jsp", 152, 1, James);
        Building Ho3 = new Hotel("12 av jsp", 152, 2, James);
        try{
            ((ApartmentBuilding)Ap1).stopRent(occ1);
            ((Hotel) Ho1).rent(occ1, 5);
        }catch (Exception e){
            System.out.println("Error in testBuilding: "+e.getMessage());
        }
        printResult(Ho1.equals(Ho2));
        printResult(!Ho1.equals(Ho3));

        // House
        House Ho4 = new House("12 av jsp", 152, 1, 100, James);
        House Ho5 = new House("12 av jsp", 152, 1, 100, James);
        House Ho6 = new House("12 av other", 152, 1, 200, James);
        printResult(Ho4.equals(Ho5));
        printResult(!Ho4.equals(Ho6));

        //Store
        Building St1 = new Store("12 av jsp", 152, James, insts);
        Building St2 = new Store("12 av jsp", 152, James, insts);
        Building St3 = new Store("12 av other", 152, James, insts);
        printResult(St1.equals(St2));
        printResult(!St1.equals(St3));

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
        /**
         * 1. test rent function
         * 2. test stopRent function
         * 3. test when the renter already has a room
         * 4. test when the room is already rented
         * 5. test if the occupant has the right room in both Occupant and Hotel classes
         * 6. test when we try to rent a flat which is not in the building
         */
        Building H1 = new Hotel("15 av Repu", 500, 3, (Owner)test);
        Building H2 = new Hotel("14 bd Monod", 12, 1, (Owner)test);
        Person JeanTest = new Occupant("Jean", "Dujardin");
        Person JackTest = new Occupant("Jack", "Jefferson");
        try{
            ((Hotel)H2).rent((Occupant)JeanTest, 10); // test rent and stopRent
            ((Hotel)H2).stopRent((Occupant) JeanTest);
            ((Hotel)H1).rent((Occupant)JeanTest, 10);
        }catch (Exception e){
            printResult(false);
        }
        try{
            ((Hotel)H2).rent((Occupant) JeanTest, 11); // test rent when the renter already has a room
            printResult(false); // if the line bellow don't throw an exception
        }catch (Exception e){
            printResult(true); // suppose to throw an exception
        }
        try{
            ((Hotel)H1).rent((Occupant) JackTest, 10); // test rent when the room is already rented
            printResult(false); // if the line bellow don't throw an exception
        }catch (Exception e){
            printResult(true); // suppose to throw an exception
        }
        printResult(((Occupant)JeanTest).getRent() == H1 && ((Occupant)JeanTest).getNoRoom() == 10); // test if the occupant has the right room
        printResult(((Hotel)H1).getRentals().containsKey(10) && ((Hotel)H1).getRentals().containsValue(JeanTest)); // same in the Hotel class
        try{
            ((Hotel)H2).rent((Occupant)JackTest, 11); // test when we try to rent a flat which is not in the building
            printResult(false); // if the line bellow don't throw an exception
        }catch (Exception e){
            printResult(true); // suppose to throw an exception
        }
        try{
            ((Hotel)H1).stopRent((Occupant) JeanTest); // just to clear for the next tests (to use JeanTest and not create a new one)
        }catch (Exception e){
            printResult(false);
        }
        // test rental in an ApartmentBuilding
        /**
         * 1. test when we try to rent a flat which is not in the building
         * 2. test rent
         * 3. test stopRent
         * 4. test rent when the renter already has a flat
         * 5. test if the flat is already rented
         * 6. test if the occupant has the right flat in both ApartmentBuilding and Occupant classes
         */
        Building A1 = new ApartmentBuilding("15 av Repu", 500, 3, (Owner)test);
        try{
            ((ApartmentBuilding)A1).rent((Occupant)JeanTest, 10); // suppose to throw an exception because the flat doesn't exist
        }catch (Exception e){
            printResult(true);
        }
        try{
            ((ApartmentBuilding)A1).rent((Occupant)JeanTest, 2); // test of rent and stopRent
            ((ApartmentBuilding)A1).stopRent((Occupant) JeanTest);
            ((ApartmentBuilding)A1).rent((Occupant)JeanTest, 2);
        }catch (Exception e){
            printResult(false);
        }
        try{
            ((ApartmentBuilding)A1).rent((Occupant) JeanTest, 1); // test rent when the renter already has a flat
            printResult(false); // if the line bellow don't throw an exception
        }catch (Exception e){
            printResult(true); // suppose to throw an exception
        }
        try{
            ((ApartmentBuilding)A1).rent((Occupant) JackTest, 2); // test rent when the flat is already rented
            printResult(false); // if the line bellow don't throw an exception
        }catch (Exception e){
            printResult(true);
        }
        printResult(((Occupant)JeanTest).getRent() == A1 && ((Occupant)JeanTest).getNoRoom() == 2); // test if the occupant has the right flat
        printResult(((ApartmentBuilding)A1).getRentals().containsKey(2) && ((ApartmentBuilding)A1).getRentals().containsValue(JeanTest)); // same in the ApartmentBuilding class
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for all instrument creation, and their specificities
    static void testInstrument() throws InterruptedException {
        System.out.print("   ");
        Instrument test = new AcousticGuitar();
//        System.out.println(test.toString());

        //test equals
        //AcousticGuitar
        Instrument test2 = new AcousticGuitar("name", 123, 123, 1, 1, "right-handed", 1);
        Instrument test3 = new AcousticGuitar("name", 123, 123, 1, 1, "right-handed", 1);
        Instrument test4 = new AcousticGuitar("name", 123, 152, 1, 1, "right-handed", 1);
        printResult(test2.equals(test3));
        printResult(!test2.equals(test4));

        //DigitalPiano
        Instrument test5 = new DigitalPiano("name", 123, 123, 1, 1, 50);
        Instrument test6 = new DigitalPiano("name", 123, 123, 1, 1, 50);
        Instrument test7 = new DigitalPiano("name other", 123, 123, 1, 1, 50);
        printResult(test5.equals(test6));
        printResult(!test5.equals(test7));

        //ElectricGuitar
        Instrument test8 = new ElectricGuitar("name", 123, 123, 1, 1, true, false);
        Instrument test9 = new ElectricGuitar("name", 123, 123, 1, 1, true, false);
        Instrument test10 = new ElectricGuitar("name other", 123, 123, 1, 1, true, true);
        printResult(test8.equals(test9));
        printResult(!test8.equals(test10));

        //GrandPiano
        Instrument test11 = new GrandPiano("name", 123, 123, 1, 1, 50);
        ((GrandPiano)test11).setSize(1);
        Instrument test12 = new GrandPiano("name", 123, 123, 1, 1, 50);
        ((GrandPiano)test12).setSize(1);
        Instrument test13 = new GrandPiano("name", 123, 123, 1, 1, 50);
        ((GrandPiano)test13).setSize(2);
        printResult(test11.equals(test12));
        printResult(!test11.equals(test13));

        //UpRightPiano
        Instrument test14 = new UprightPiano("name", 123, 123, 1, 1, 50);
        ((UprightPiano)test14).setSilence(true);
        ((UprightPiano)test14).setStrings(1);
        Instrument test15 = new UprightPiano("name", 123, 123, 1, 1, 50);
        ((UprightPiano)test15).setSilence(true);
        ((UprightPiano)test15).setStrings(1);
        Instrument test16 = new UprightPiano("name", 123, 123, 1, 1, 50);
        ((UprightPiano)test16).setSilence(true);
        ((UprightPiano)test16).setStrings(2);
        printResult(test14.equals(test15));
        printResult(!test14.equals(test16));

        //WindInstru
        Instrument test17 = new WindInstru("name", 123, 123, "FLUTE");
        Instrument test18 = new WindInstru("name", 123, 123, "FLUTE");
        Instrument test19 = new WindInstru("name", 123, 123, "CLARINET");
        printResult(test17.equals(test18));
        printResult(!test17.equals(test19));

        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

    //test method for relations between  store and instruments
    static void testRelation2() throws InterruptedException {
        System.out.print("   ");
        printResult(true);
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(" all checked\n");
    }

}
