package model.entity;


/**
 * Class that extends @{@link Entity} and represents a payer of report
 */

public class ReportPayer extends Entity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String passport;
    private String phone;
    private String city;
    private String street;
    private String home;


    /**
     * Constructor for creating a new object without parameters
     * @see ReportPayer#ReportPayer()
     */
    public ReportPayer() {
    }

    /**
     * Constructor for creating a new object
     *
     * @param id - id
     * @param firstName - first name of payer
     * @param middleName - middle name of payer
     * @param lastName - last name of payer
     * @param passport - passport of payer
     * @param phone - phone of payer
     * @param city - city
     * @param street - street
     * @param home - home (number of home)
     *
     * @see ReportPayer#ReportPayer(int, String, String, String, String, String, String, String, String)
     */
    public ReportPayer(int id, String firstName, String middleName, String lastName, String passport,
                       String phone, String city, String street, String home) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passport = passport;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.home = home;
    }

    private ReportPayer(Builder builder) {
        super(builder.id);
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.passport = builder.passportCode;
        this.phone = builder.phone;
        this.city = builder.city;
        this.street = builder.street;
        this.home = builder.home;
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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    /**
     * Inner static class that implements a builder's template for creating @{@link ReportPayer}
     */
    public static class Builder {

        private int id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String passportCode;
        private String phone;
        private String city;
        private String street;
        private String home;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder passport(String passport) {
            this.passportCode = passport;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportPayer)) return false;

        ReportPayer that = (ReportPayer) o;

        if (!firstName.equals(that.firstName)) return false;
        if (!middleName.equals(that.middleName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!passport.equals(that.passport)) return false;
        if (!phone.equals(that.phone)) return false;
        if (!city.equals(that.city)) return false;
        if (!street.equals(that.street)) return false;
        return home.equals(that.home);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + passport.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + home.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ReportPayer{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport='" + passport + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
