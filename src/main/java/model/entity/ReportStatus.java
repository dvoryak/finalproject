package model.entity;

public enum ReportStatus {
    OK,
    FAILED,
    UNCHECKED;

    private String message;

    ReportStatus() {
    }

    ReportStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
