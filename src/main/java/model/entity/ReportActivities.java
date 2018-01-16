package model.entity;

/**
 * Class that extends @{@link Entity} and represents Activities which includes into @{@link Report}
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class ReportActivities extends Entity {

    private String text;
    private String name;
    private int reportId;

    /**
     * Constructor for creating a new object without parameters
     *
     * @see ReportActivities#ReportActivities()
     */
    public ReportActivities() {
    }

    /**
     * Constructor for creating a new object
     *
     * @param id       - id
     * @param text     - text of activity
     * @param name     - name of activity
     * @param reportId - report's id
     *
     * @see ReportActivities#ReportActivities(int, String, String, int)
     */
    public ReportActivities(int id, String text, String name, int reportId) {
        super(id);
        this.text = text;
        this.name = name;
        this.reportId = reportId;
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

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return "ReportActivities{" +
                "text='" + text + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
