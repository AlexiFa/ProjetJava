import Buildings.*;
import Instrument.*;
import Person.*;
// if not used at the end of the project, we can remove the import
/*
* The main class is used to verify that the whole project is working without errors
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println();
        Building hot = new Hotel();
        Person James = new Owner("Bond", "James", hot);
        House hou = new House("21 baker street", 120, 6, 500, (Owner)James); // toString of Owner not created yet so print is not correct
        ApartmentBuilding flatBlock = new ApartmentBuilding();
        Store sto = new Store();
        System.out.println("building classes created.");
        System.out.println(hou.toString());
    }
}