package model.entity;

import java.util.List;

/**
 *
 * Class that extends @{@link User} and represents a client
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class Client extends User {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    {
        setRole("Client");
    }

    /**
     * Constructor for creating a new object without parameters
     * @see Client#Client()
     */
    public Client() {
    }

    /**
     * Constructor for creating a new object
     *
     * @param id - id
     * @param login - login
     * @param password - password
     * @param firstName - firstName
     * @param lastName - lastName
     * @param phone - phone
     * @param email - email
     *
     * @see Client#Client(int, String, String, String, String, String, String, List)
     */
    public Client(int id, String login, String password, String firstName, String lastName, String phone, String email) {
        super(id, login, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    private Client(Builder builder) {
        setLogin(builder.login);
        setPassword(builder.password);
        setId(builder.id);
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.email = builder.email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Implementation of builder's template for Client
     *
     * @author paveldvoryak
     */
    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private String email;
        private String phone;

        public Builder() {

        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }


    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
