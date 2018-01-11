package model.entity;

public class UserRequest extends Entity {

    private String text;
    private int userId;

    public UserRequest() {
    }

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
