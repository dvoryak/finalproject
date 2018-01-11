package model.entity;

public class ReportActivities extends Entity {

    private String text;
    private String name;
    private Report report;


    public ReportActivities() {
    }

    public ReportActivities(int id, String text, String name) {
        super(id);
        this.text = text;
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
                "text='" + text + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
