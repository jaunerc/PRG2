/*
 * License header jaunerc
 */
package ch.jaunerc.prg2.oop1_dat1;

/**
 * This class represents a person. A person is defined by the name and first name.
 * @author jaunerc
 */
public class Person {
    
    private String name;
    private String firstName;
    
    /**
     * Create a new Person.
     * @param name of the person.
     * @param firstName of the person.
     */
    public Person(final String name, final String firstName) {
        this.name = name;
        this.firstName = firstName;
    }
    
    /**
     * Create a new Person. Set the name and firstName field to an empty string.
     */
    public Person() {
        this("","");
    }
    
    /**
     * Print the values of the fields to the console.
     */
    public void print() {
        System.out.print("Person - name: "+name+" - firstname: "+firstName);
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

}
