package model.entity;

public class ReportPayer extends Entity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String passportCode;
    private String postalCode;
    private String phone;
    private String city;
    private String street;
    private String home;
    private Report report;


    public ReportPayer() {
    }

    public ReportPayer(int id, String firstName, String middleName, String lastName, String passportCode, String postalCode,
                       String phone, String city, String street, String home, Report report) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportCode = passportCode;
        this.postalCode = postalCode;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.home = home;
    }

    public ReportPayer(Builder builder) {
        super(builder.id);
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.passportCode = builder.passportCode;
        this.postalCode = builder.postalCode;
        this.phone = builder.phone;
        this.city = builder.city;
        this.street = builder.street;
        this.home = builder.home;
        this.report = report;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    private static class Builder {
        private int id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String passportCode;
        private String postalCode;
        private String phone;
        private String city;
        private String street;
        private String home;
        private Report report;


        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder report(Report report) {
            this.report = report;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder passportCode(String passportCode) {
            this.passportCode = passportCode;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder home(String home) {
            this.home = home;
            return this;
        }

        public ReportPayer build() {
            return new ReportPayer(this);
        }
    }

    @Override
    public String toString() {
        return "ReportPayer{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportCode='" + passportCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
