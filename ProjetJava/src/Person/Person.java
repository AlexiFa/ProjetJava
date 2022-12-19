/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;

import Instrument.*;

import java.util.ArrayList;

public class Person {
    protected String name;
    protected String surname;
    protected float budget;
    protected ArrayList<Instrument> my_instruments;
    public Person() {
        this.name="";
        this.surname="";
        this.budget =0;
        this.my_instruments = new ArrayList<Instrument>();
    }
    public Person(Person person){
        this.name = person.getName();
        this.surname = person.getSurname();
        this.budget = person.getBudget();
        this.my_instruments = new ArrayList<Instrument>();
    }
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.budget = 0;
        this.my_instruments = new ArrayList<Instrument>();
    }
    @Override
    public String toString() {
        return name +
                " " + surname;
    }
    /**
     * Getter and setters to create an or an occupant from a person (with new Owner(getName,getSurname, ...))
     */
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public float getBudget() {
        return this.budget;
    }
    public ArrayList<Instrument> getMy_instruments(){
        return this.my_instruments;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setBudget(float budget){
        this.budget = budget;
    }

    public void addInstrument(Instrument instrument){
        this.my_instruments.add(instrument);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) { // if the name is null so : false if other.name is not null else : false if the name is not equals to other.name
            return false;
        }
        if ((this.surname == null) ? (other.surname != null) : !this.surname.equals(other.surname)) { // if the surname is null so : false if other.surname is not null else : false if the surname is not equals to other.surname
            return false;
        }
        return true;
    }
}
