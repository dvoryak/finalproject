package model.entity;

public class Inspector extends Entity {
    private String email;
    private String login;
    private String password;

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

        public Inspector build() {
            return new Inspector(this);
        }
    }
}
