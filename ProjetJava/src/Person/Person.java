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
