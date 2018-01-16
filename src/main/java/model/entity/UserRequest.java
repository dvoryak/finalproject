package model.entity;

/**
 * Class that extends @{@link Entity} and represents requests of user
 *
 * @author paveldvoryak
 * @version 1.0
 */
public class UserRequest extends Entity {

    private String text;
    private int userId;

    /**
     * Constructor for creating a new object without parameters
     * @see UserRequest#UserRequest()
     */
    public UserRequest() {
    }

    /**
     * Constructor for creating a new object
     *
     * @param id
     * @param text
     * @param userId
     *
     * @see UserRequest#UserRequest(int, String, int)
     */
    public UserRequest(int id, String text, int userId) {
        super(id);
        this.text = text;
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "text='" + text + '\'' +
                '}';
    }
}
