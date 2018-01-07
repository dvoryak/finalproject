package model.entity;

public class ReportActivities extends Entity {

    private String code;
    private String name;
    private Report report;


    public ReportActivities() {
    }

    public ReportActivities(int id, String code, String name, Report report) {
        super(id);
        this.code = code;
        this.name = name;
        this.report = report;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "ReportActivities{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
