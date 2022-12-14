/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;

public class Person {
    String name;
    String surname;
    public Person() {
        this.name="";
        this.surname="";
    }
    public Person(Person person){
        this.name = person.getName();
        this.surname = person.getSurname();
    }
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
}
