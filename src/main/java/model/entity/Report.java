package model.entity;

public abstract class Report extends Entity {
    private int userId;
    private int inspectorId;


    public Report(int id, int userId, int inspectorId) {
        super.setId(id);
        this.userId = userId;
        this.inspectorId = inspectorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }


}
