package model.entity;

import java.util.Set;

public class Client extends User {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    private Set<Report> reports;
    private Set<UserRequest> requests;

    {
        setRole("Client");
    }

    public Client() {
    }

    public Client(int id, String login, String password, String firstName, String lastName, String phone, String email,
                  Set<Report> reports, Set<UserRequest> requests) {
        super(id, login, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.reports = reports;
        this.requests = requests;
    }

    private Client(Builder builder) {
        setLogin(builder.login);
        setPassword(builder.password);
        super.setId(builder.id);
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.email = builder.email;
        this.reports = builder.reports;
        this.requests = builder.requests;
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

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    public Set<UserRequest> getRequests() {
        return requests;
    }

    public void setRequests(Set<UserRequest> requests) {
        this.requests = requests;
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
        private Set<UserRequest> requests;


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

        public Builder request(Set<UserRequest> reports) {
            this.requests = requests;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!firstName.equals(client.firstName)) return false;
        if (!lastName.equals(client.lastName)) return false;
        if (!phone.equals(client.phone)) return false;
        if (!email.equals(client.email)) return false;
        if (reports != null ? !reports.equals(client.reports) : client.reports != null) return false;
        return requests != null ? requests.equals(client.requests) : client.requests == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (reports != null ? reports.hashCode() : 0);
        result = 31 * result + (requests != null ? requests.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", reports=" + reports +
                ", requests=" + requests +
                '}';
    }
}
