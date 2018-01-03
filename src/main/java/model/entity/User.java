package model.entity;

public abstract class User extends Entity {

    Role role;
    String login;
    String password;

    public User() {
    }

    public User(int id) {
        super(id);
    }

    public Role getRole() {
        return role;
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
}
