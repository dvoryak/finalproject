package model.entity;

public abstract class Report {
    private int id;
    private int userId;
    private int inspectorId;
    private ReportStatus status = ReportStatus.UNCHECKED;

    public Report(int id, int userId, int inspectorId) {
        this.id = id;
        this.userId = userId;
        this.inspectorId = inspectorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

}
