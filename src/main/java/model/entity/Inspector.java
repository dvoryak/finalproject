package model.entity;

/**
 *
 * Class that extends @{@link User} and represents a inspector
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class Inspector extends User {

    private String firstName;
    private String lastName;

    {
        setRole("Inspector");
    }

    /**
     * Constructor for creating a new object without parameters
     * @see Inspector#Inspector()
     */
    public Inspector() {
    }

    /**
     * Constructor for creating a new object
     *
     * @param id - id
     * @param login - login
     * @param password - password
     * @param firstName - firstName
     * @param lastName - lastName
     *
     *@see Inspector#Inspector(int, String, String, String, String)
     */

    public Inspector(int id, String login, String password, String firstName, String lastName) {
        super(id, login, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
