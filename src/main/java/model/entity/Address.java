package model.entity;

public class Address extends Entity {

    private String country;
    private String city;
    private String street;
    private String home;

    public Address() {
    }

    public Address(int id, String country, String city, String street, String home) {
        super(id);
        this.country = country;
        this.city = city;
        this.street = street;
        this.home = home;
    }

    public Address(Builder builder) {
        super(builder.id);
        this.country = builder.country;
        this.city = builder.city;
        this.street = builder.street;
        this.home = builder.home;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public static class Builder {

        private int id;
        private String country;
        private String city;
        private String street;
        private String home;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
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

        public Address build() {
            return new Address(this);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
