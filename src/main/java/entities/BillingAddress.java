package entities;

import javax.persistence.*;


@Entity
@Table(name = "billing_addresses")
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bla_id")
    private int id;

    @Column(name = "bla_city")
    private String city;

    @Column(name = "bla_region")
    private String region;

    @Column(name = "bla_street")
    private String street;

    @Column(name = "bla_street_no")
    private String streetNo;

    @Column(name = "bla_code")
    private String code;

    @Column(name = "bla_surname")
    private String surname;

    @Column(name = "bla_name")
    private String name;

    public BillingAddress(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
