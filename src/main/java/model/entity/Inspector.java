package model.entity;

public class Inspector extends User {

    private String firstName;
    private String lastName;

    {
        setRole("Inspector");
    }

    public Inspector() {
    }

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
