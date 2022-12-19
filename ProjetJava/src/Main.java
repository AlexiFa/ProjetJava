/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *  The main loop of the application
 */
import Buildings.*;
import Instrument.*;
import Person.*;
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
        // MAIN LOOP: Start Application
        Scanner sc;
        System.out.println("\n#############################################################");
        residence.put("House",new ArrayList<Building>()); //create empty residence
        residence.put("Hotel", new ArrayList<Building>());
        residence.put("Apartment Building", new ArrayList<Building>());
        residence.put("Store", new ArrayList<Building>());

        while(stay_in_app){
            sc = new Scanner(System.in);
            System.out.println("\nWELCOME TO MELE-MELE ISLAND RESIDENCE\n");
            System.out.println("Please enter your name to log in:"); //registering user, asking his information
            System.out.print("First Name : ");
            String name = sc.nextLine();
            System.out.print("Last Name : ");
            String lastName = sc.nextLine();
            Person admin = new Person(name, lastName);
            boolean isAlreadySign = false;
            for (Person p : population.keySet()) {
                if (p.equals(admin)) {
                    isAlreadySign = true;
                    admin = p;
                    break;
                }
            }
            if (!isAlreadySign)
                population.put(admin, new Person[]{null,null});

            System.out.println("\n_____________________________________________________________");
            try{
                stay_in_app = mainMenu(sc, admin);
            }catch (Exception e){
                System.out.println("Error in your entries, logging out");
                System.out.println(e.getMessage());
            }
            //stay_in_app = mainMenu(sc, admin);
        }
    }
    public static boolean mainMenu(Scanner sc, Person admin) throws Exception { //todo: for all menus, create a default case, for entering wrong digit
        boolean loop=true;
        System.out.println(admin.getName()+" "+ admin.getSurname()+", You have been successfully logged in !");
        while(loop){
            System.out.println("\nYOUR MAIN MENU\n");
            System.out.println(">> Enter a digit to choose what to do:\n");
            System.out.println("1. Get a list of all people in Mele-Mele Island Residence");
            System.out.println("2. Get a list of all buildings existing in Mele-Mele Island Residence");
            System.out.println("3. Own/Build/Buy a building");
            System.out.println("4. Rent an apartment or a hotel room");
            System.out.println("5. See all your buildings");
            System.out.println("6. Hand over a building to another owner");
            System.out.println("7. Stop your rental");
            System.out.println("8. Get a list of all rented hotel rooms and apartments");
            System.out.println("9. Buy an instrument in an existing store");
            System.out.println("10. See all your instruments (not available for now)");
            System.out.println("0. Log out\n");
            int choice = sc.nextInt();
            switch (choice) {
            case 1://list all Persons, with reference to owner/occupant information.
                Functions.printAllPerson(population);
                System.out.print("Going back to main menu");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                break;
            case 2://list all buildings, with their description.
                Functions.printAllBuildings(residence);
                System.out.print("Going back to main menu");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                break;
            case 3:
                Owner owner;
                if (population.get(admin)[0]!=null){
                    owner = (Owner) population.get(admin)[0];
                }else{
                    owner = new Owner(admin);
                    population.get(admin)[0] = owner;
                }
                menuCreateBuilding(sc, owner); //function menuCreateBuilding creating the building in the name of the owner2
                break;
            case 4:
                Occupant occupant;
                if (population.get(admin)[1]!=null){
                    occupant = (Occupant) population.get(admin)[1];
                }else{
                    occupant = new Occupant(admin.getName(), admin.getSurname());
                    population.get(admin)[1] = occupant;
                }
                menuRentRoom(sc, occupant);
                break;
            case 5:
                Functions.printBuildingsOwned((Owner)population.get(admin)[0]);
                System.out.print("Going back to main menu");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                break;
            case 6:
                Functions.GiveOutBuilding(sc, (Owner)population.get(admin)[0], population);
                if (population.get(admin)[0]!=null){
                    if(((Owner) population.get(admin)[0]).getBuildings().size()==0) population.get(admin)[0]=null;
                }
                System.out.print("Going back to main menu");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                break;
            case 7:
                if(population.get(admin)[1] == null) {
                    System.out.println("You are not renting anything");
                }
                else{
                    if (((Occupant)population.get(admin)[1]).getRent() instanceof Hotel)
                        ((Hotel)((Occupant)population.get(admin)[1]).getRent()).stopRent((Occupant) population.get(admin)[1]);
                    else if (((Occupant)population.get(admin)[1]).getRent() instanceof ApartmentBuilding)
                        ((ApartmentBuilding)((Occupant)population.get(admin)[1]).getRent()).stopRent((Occupant) population.get(admin)[1]);
                }
                System.out.print("Going back to main menu");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                break;
            case 8:
                Functions.printAllRented(residence);
                System.out.print("Going back to main menu");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                break;
            case 9:
                menuBuyInStore(sc, admin);
                break;
            case 10:
                ArrayList<Instrument> all_ad_instru = admin.getMy_instruments();
                if (all_ad_instru.size()!=0) {
                    int i=1;
                    for( Instrument instrument: admin.getMy_instruments()){
                        System.out.println(" "+i+". "+instrument.toString());
                    }
                }
                else{
                    System.out.println("You have no instruments in your possession");
                }
                System.out.print("Going back to main menu");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
                break;
            case 0: //quit the mainMenu() loop
                System.out.println("Do you want to also exit the program? Enter 0 to confirm or any other number to go back to the main menu");
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
            default:
                System.out.println("Please enter a valid number");
                break;
            }
        }
        return stay_in_app; //return if breaking or not the main application loop
    }
    public static void menuCreateBuilding(Scanner sc, Owner owner) throws InterruptedException {
        System.out.println("Which type of building do you want to own?");
        System.out.println();
        System.out.println("1. Create a house");
        System.out.println("2. Create a hotel");
        System.out.println("3. Create a apartment building");
        System.out.println("4. Create a store");
        int choice = sc.nextInt();
        sc.nextLine(); //PRIMORDIAL, to be able to read strings after reading an int/float
        switch (choice){
            case 1:
                House house = Functions.mCBHouse(sc, owner);
                if (Functions.addressFree(house.getAddress(), residence.get("House")) && Functions.addressFree(house.getAddress(), residence.get("Hotel")) && Functions.addressFree(house.getAddress(), residence.get("ApartmentBuilding")) && Functions.addressFree(house.getAddress(), residence.get("Store"))){
                    residence.get("House").add(house);
                    System.out.println("House created successfully");
                }
                else{
                    System.out.println("This address is already taken");
                }
                break;
            case 2:
                Hotel hotel = Functions.mCBHotel(sc, owner);
                if (Functions.addressFree(hotel.getAddress(), residence.get("House")) && Functions.addressFree(hotel.getAddress(), residence.get("Hotel")) && Functions.addressFree(hotel.getAddress(), residence.get("ApartmentBuilding")) && Functions.addressFree(hotel.getAddress(), residence.get("Store"))){
                    residence.get("Hotel").add(hotel);
                    System.out.println("Hotel created successfully");
                }
                else{
                    System.out.println("This address is already taken");
                }
                break;
            case 3:
                ApartmentBuilding ap_building = Functions.mCBApartment(sc, owner);
                if (Functions.addressFree(ap_building.getAddress(), residence.get("House")) && Functions.addressFree(ap_building.getAddress(), residence.get("Hotel")) && Functions.addressFree(ap_building.getAddress(), residence.get("ApartmentBuilding")) && Functions.addressFree(ap_building.getAddress(), residence.get("Store"))){
                    residence.get("ApartmentBuilding").add(ap_building);
                    System.out.println("Apartment building created successfully");
                }
                else{
                    System.out.println("This address is already taken");
                }
                break;
            case 4:
                Store store = Functions.mCBStore(sc, owner);
                if (Functions.addressFree(store.getAddress(), residence.get("House")) && Functions.addressFree(store.getAddress(), residence.get("Hotel")) && Functions.addressFree(store.getAddress(), residence.get("ApartmentBuilding")) && Functions.addressFree(store.getAddress(), residence.get("Store"))){
                    residence.get("Store").add(store);
                    System.out.println("Store created successfully");
                }
                else{
                    System.out.println("This address is already taken");
                }
                break;
            default:
                System.out.println("Please enter a valid number");
                break;
        }
        System.out.print("Going back to main menu");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
    }
    private static void menuRentRoom(Scanner sc, Occupant occupant) throws Exception {
        System.out.println("What do you want to rent?");
        System.out.println();
        System.out.println("1. a Hotel room");
        System.out.println("2. an Apartment");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                if (residence.get("Hotel").size()==0){
                    System.out.println("There no hotels available at the moment.");
                }
                else {
                    Functions.mRRHotel(sc, occupant, residence.get("Hotel"));
                    System.out.println("Your booking has been accepted !");
                }
                break;
            case 2:
                if(residence.get("Apartment Building").size() ==0){
                    System.out.println("There no apartment buildings available at the moment.");
                }
                else{
                    Functions.mRRApartment(sc, occupant, residence.get("Apartment Building"));
                    System.out.println("Your booking has been accepted !");
                }
                break;
            default:
                System.out.println("Please enter a valid number");
                break;
        }
        System.out.print("Going back to main menu");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
    }
    private static void menuBuyInStore(Scanner sc, Person person) throws InterruptedException {
        System.out.println("What would be your budget (in dollars)?");
        person.setBudget(sc.nextFloat());
        ArrayList<Building> stores = residence.get("Store");
        boolean shopping = true;
        if(stores.size()!= 0) {
            while (shopping) {
                System.out.println("Here are the stores available:");
                Functions.mBISPrintAllStores(stores);
                System.out.print("Which one do you want to shop in? Chose a number: ");
                int choice = sc.nextInt();
                Store store_chosen = (Store) stores.get(choice - 1);
                ArrayList<Instrument> all_in_store = store_chosen.getInstruments();
                System.out.println("In this store, there is " + all_in_store.size() + " instruments:");
                Functions.mBISPrintInstruInStore(all_in_store);
                System.out.print("Which one do you want to buy? Chose a number: ");
                choice = sc.nextInt();
                Instrument chosen_one = all_in_store.get(choice - 1);
                boolean worked = Functions.mBISTry2Sell(person, store_chosen, chosen_one);
                if (worked) {
                    System.out.println("Your purchase of " + chosen_one.getNameInstru() + " was successful !");
                    System.out.println("Your remaining budget is: " + person.getBudget());
                    System.out.print("Do you want to continue your shopping? 1 (yes) or 0 (no)");
                    if (sc.nextInt() != 1) shopping = false;
                } else {
                    System.out.println("Unfortunately, you cannot get " + chosen_one.getNameInstru()
                            + ", because your remaining budget is not enough, or an error occurred.");
                    shopping = false;
                }
            }
            System.out.println("You have finished your shopping !");
        }
        else {
            System.out.println("There are no stores available.");
        }
        System.out.print("Going back to main menu");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(250);System.out.print(".\n");
    }
}
