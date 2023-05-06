package se.yrgo.domain;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String zipcode;

    public Address() {
    }

    public Address(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Adress:" +
                "street:" + street + '\'' +
                ", city:" + city + '\'' +
                ", zipcode:" + zipcode;
    }
}
