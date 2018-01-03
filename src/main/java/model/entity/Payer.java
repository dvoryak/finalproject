package model.entity;

public class Payer extends Entity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String passportCode;
    private String postalCode;
    private String phone;

    public Payer() {
    }

    public Payer(int id, String firstName, String middleName, String lastName, String passportCode, String postalCode, String phone) {
        super(id);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportCode = passportCode;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public Payer(Builder builder) {
        super(builder.id);
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.passportCode = builder.passportCode;
        this.postalCode = builder.postalCode;
        this.phone = builder.phone;
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

    private static class Builder {
        private int id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String passportCode;
        private String postalCode;
        private String phone;

        public Builder id(int id) {
            this.id = id;
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

        public Payer build() {
            return new Payer(this);
        }
    }

    @Override
    public String toString() {
        return "Payer{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportCode='" + passportCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
