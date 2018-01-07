package model.entity;

import java.util.Date;
import java.util.Set;

public class Report extends Entity {

    private ReportPayer payer;
    private String instituteNAme;
    private int employeeNumber;
    private Date date;
    private Client client;
    private Inspector inspector;
    private Set<ReportActivities> activities;
    private ReportStatus reportStatus;

    public Report() {
    }

    public Report(int id, ReportPayer payer, String instituteNAme, int employeeNumber, Date date, Client client,
                  Inspector inspector, Set<ReportActivities> activities) {
        super(id);
        this.payer = payer;
        this.instituteNAme = instituteNAme;
        this.employeeNumber = employeeNumber;
        this.date = date;
        this.client = client;
        this.inspector = inspector;
        this.activities = activities;
    }

    private Report(Builder builder) {
        super(builder.id);
        this.payer = builder.payer;
        this.instituteNAme = builder.instituteNAme;
        this.employeeNumber = builder.employeeNumber;
        this.date = builder.date;
        this.client = builder.client;
        this.inspector = builder.inspector;
        this.activities = builder.activities;
    }

    public Set<ReportActivities> getActivities() {
        return activities;
    }

    public void setActivities(Set<ReportActivities> activities) {
        this.activities = activities;
    }

    public ReportPayer getPayer() {
        return payer;
    }

    public void setPayer(ReportPayer payer) {
        this.payer = payer;
    }

    public String getInstituteNAme() {
        return instituteNAme;
    }

    public void setInstituteNAme(String instituteNAme) {
        this.instituteNAme = instituteNAme;
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

    public static class Builder {

        private int id;
        private ReportPayer payer;
        private String instituteNAme;
        private int employeeNumber;
        private Date date;
        private Client client;
        private Inspector inspector;
        private Set<ReportActivities> activities;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder payer(ReportPayer payer) {
            this.payer = payer;
            return this;
        }

        public Builder instituteName(String instituteNAme) {
            this.instituteNAme = instituteNAme;
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

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public Builder inspector(Inspector inspector) {
            this.inspector = inspector;
            return this;
        }

        public Builder activities(Set<ReportActivities> activities) {
            this.activities = activities;
            return this;
        }

        public Report build() {
            return new Report(this);
        }

    }

    @Override
    public String toString() {
        return "Report{" +
                "instituteNAme='" + instituteNAme + '\'' +
                ", employeeNumber=" + employeeNumber +
                ", date=" + date +
                '}';
    }
}
