package model.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Class that extends a @{@link Entity} and represents Report
 *
 * @author paveldvoryak
 * @version 1.0
 */
public class Report extends Entity {

    private String institute;
    private int employeeNumber;
    private Date date;
    private String message;
    private Status status;
    private Client client;
    private Inspector inspector;
    private ReportPayer payer;

    private List<ReportActivities> activities;


    /**
     * Inner static enum that represents a status of report
     *
     */
    public static enum Status {
        OK(1),
        FAILED(2),
        UNCHECKED(3);

        private int id;

        Status(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    /**
     * Constructor for creating a new object without parameters
     * @see Report#Report()
     */
    public Report() {
    }


    /**
     * Constructor for creating a new object
     *
     * @param id - id
     * @param institute - name of institute
     * @param employeeNumber - number of employees
     * @param date - date @{@link Date}
     * @param message - message
     * @param status - status of report
     * @param client - owner of report @{@link Client}
     * @param inspector - person which should process report @{@link Report}
     * @param payer - payer @{@link ReportPayer}
     * @param activities - activities @{@link ReportActivities}
     *
     * @see Report#Report(int, String, int, Date, String, Status, Client, Inspector, ReportPayer, List)
     */
    public Report(int id, String institute, int employeeNumber, Date date, String message, Status status, Client client,
                  Inspector inspector, ReportPayer payer, List<ReportActivities> activities) {
        super(id);
        this.institute = institute;
        this.employeeNumber = employeeNumber;
        this.date = date;
        this.message = message;
        this.status = status;
        this.client = client;
        this.inspector = inspector;
        this.payer = payer;
        this.activities = activities;
    }

    private Report(Builder builder) {
        super(builder.id);
        this.institute = builder.institute;
        this.employeeNumber = builder.employeeNumber;
        this.date = builder.date;
        this.status = builder.status;
        this.message = builder.message;
        this.client = builder.client;
        this.payer = builder.reportPayer;
        this.activities = builder.activities;
        this.inspector = builder.inspector;
        this.client = builder.client;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ReportActivities> getActivities() {
        return activities;
    }

    public void setActivities(List<ReportActivities> activities) {
        this.activities = activities;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReportPayer getPayer() {
        return payer;
    }

    public void setPayer(ReportPayer payer) {
        this.payer = payer;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }


    /**
     * Inner static class that implements a builder's template for creating @{@link Report}
     */
    public static class Builder {

        private int id;
        private String institute;
        private int employeeNumber;
        private Date date;
        private Status status;
        private Client client;
        private ReportPayer reportPayer;
        private Inspector inspector;
        private List<ReportActivities> activities;
        private String message;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder institute(String institute) {
            this.institute = institute;
            return this;
        }

        public Builder employeeNumber(int employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder payer(ReportPayer reportPayer) {
            this.reportPayer = reportPayer;
            return this;
        }

        public Builder inspector(Inspector inspector) {
            this.inspector = inspector;
            return this;
        }

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder user(Client client) {
            this.client = client;
            return this;
        }


        public Builder activities(List<ReportActivities> activities) {
            this.activities = activities;
            return this;
        }

        public Report build() {
            return new Report(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Builder)) return false;

            Builder builder = (Builder) o;

            if (id != builder.id) return false;
            if (employeeNumber != builder.employeeNumber) return false;
            if (!institute.equals(builder.institute)) return false;
            if (!date.equals(builder.date)) return false;
            if (status != builder.status) return false;
            if (client != null ? !client.equals(builder.client) : builder.client != null) return false;
            if (reportPayer != null ? !reportPayer.equals(builder.reportPayer) : builder.reportPayer != null) return false;
            if (activities != null ? !activities.equals(builder.activities) : builder.activities != null) return false;
            return message != null ? message.equals(builder.message) : builder.message == null;
        }

        @Override
        public int hashCode() {
            int result = institute.hashCode();
            result = 31 * result + employeeNumber;
            result = 31 * result + date.hashCode();
            result = 31 * result + status.hashCode();
            result = 31 * result + client.hashCode();
            result = 31 * result + (reportPayer != null ? reportPayer.hashCode() : 0);
            result = 31 * result + (inspector != null ? inspector.hashCode() : 0);
            result = 31 * result + (message != null ? message.hashCode() : 0);
            return result;
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "institute='" + institute + '\'' +
                ", employeeNumber=" + employeeNumber +
                ", date=" + date +
                ", status=" + status +
                ", client=" + client +
                ", activities=" + activities +
                '}';
    }
}
