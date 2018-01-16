package model.entity;


/**
 *Class that extends @{@link Entity} and represent a user
 *
 *@author paveldvoryak
 *@version 1.0
 */

public class User extends Entity {

    private String login;
    private String password;
    private String role;

    /**
     * Constructor without parameters
     * @see User#User()
     */
    public User() {
    }

    /**
     * Constructor
     *
     * @param id - id
     * @param login - login for enter to system
     * @param password - password for enter to system
     *
     *@see User#User(int, String, String)
     */
    public User(int id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
