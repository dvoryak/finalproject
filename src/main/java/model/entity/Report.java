package model.entity;

import java.sql.Date;
import java.util.Set;

public class Report extends Entity {

    private String institute;
    private int employeeNumber;
    private Date date;
    private String message;
    private Status status;
    private Client client;
    private Inspector inspector;
    private ReportPayer payer;

    private Set<ReportActivities> activities;

    public static enum Status {
        OK(1),
        FAILED(2),
        UNCECKED(3);

        private int id;

        Status(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public Report() {
    }

    public Report(int id, String institute, int employeeNumber, Date date, String message, Status status, Client client,
                  ReportPayer payer, Set<ReportActivities> activities) {
        super(id);
        this.institute = institute;
        this.employeeNumber = employeeNumber;
        this.date = date;
        this.message = message;
        this.status = status;
        this.client = client;
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

    public Set<ReportActivities> getActivities() {
        return activities;
    }

    public void setActivities(Set<ReportActivities> activities) {
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

    public static class Builder {

        private int id;
        private String institute;
        private int employeeNumber;
        private Date date;
        private Status status;
        private Client client;
        private ReportPayer reportPayer;
        private Set<ReportActivities> activities;
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

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder user(Client client) {
            this.client = client;
            return this;
        }


        public Builder activities(Set<ReportActivities> activities) {
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
            int result = id;
            result = 31 * result + institute.hashCode();
            result = 31 * result + employeeNumber;
            result = 31 * result + date.hashCode();
            result = 31 * result + status.hashCode();
            result = 31 * result + (client != null ? client.hashCode() : 0);
            result = 31 * result + (reportPayer != null ? reportPayer.hashCode() : 0);
            result = 31 * result + (activities != null ? activities.hashCode() : 0);
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
