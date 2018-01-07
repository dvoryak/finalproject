package model.entity;

import java.util.Set;

public class Inspector extends User {

    private String email;
    private Set<Report> reports;


    {
        role = Role.INSPECTOR;
    }

    public Inspector() {
    }

    public Inspector(int id, String email, String login, String password) {
        super(id);
        this.email = email;
        this.login = login;
        this.password = password;
    }

    private Inspector(Builder builder) {
        super.setId(builder.id);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private int id;
        private String email;
        private String login;
        private String password;
        private Set<Report> reports;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
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

        public Inspector build() {
            return new Inspector(this);
        }
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
