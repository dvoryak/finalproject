package model.entity;

import java.util.Set;

public class ReportStatus extends Entity {

    private String status;
    private Set<Report> reports;

    public ReportStatus() {
    }

    public ReportStatus(int id, String status, Set<Report> reports) {
        super(id);
        this.status = status;
        this.reports = reports;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "ReportStatus{" +
                "status='" + status + '\'' +
                ", reports=" + reports +
                '}';
    }
}
