/** Mele-Mele Island
 *  Rebecca Morel, Marion Galfard, Vinciane Loy, Romain Léoture, Alexis Faure
 *
 */
package Person;

public class Person {
    String name;
    String surname;
    public Person() {
    }
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

}
