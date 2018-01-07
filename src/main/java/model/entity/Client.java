package model.entity;

import java.util.Set;

public class Client extends User {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Set<Report> reports;

    {
        role = Role.CLIENT;
    }

    public Client() {
    }

    public Client(int id, String firstName, String lastName, String phone, String email, Set<Report> reports) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.reports = reports;
    }

    private Client(Builder builder) {
        super.setId(builder.id);
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.email = builder.email;
        this.login = builder.login;
        this.password = builder.password;
        this.reports = builder.reports;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private String email;
        private String phone;
        private Set<Report> reports;

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

        public Builder reports(Set<Report> reports) {
            this.reports = reports;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }



    @Override
    public String toString() {
        return "ClientServiceImpl{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
