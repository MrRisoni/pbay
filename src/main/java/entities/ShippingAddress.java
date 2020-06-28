package entities;

import javax.persistence.*;


@Entity
@Table(name = "shipping_addresses")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shp_id")
    private int id;

    @Column(name = "shp_city")
    private String city;

    @Column(name = "shp_region")
    private String region;

    @Column(name = "shp_street")
    private String street;

    @Column(name = "shp_street_no")
    private String streetNo;

    @Column(name = "shp_code")
    private String code;

    @Column(name = "shp_surname")
    private String surname;

    @Column(name = "shp_name")
    private String name;


    public ShippingAddress(int id, String city, String region, String street, String streetNo, String code, String surname, String name) {
        this.id = id;
        this.city = city;
        this.region = region;
        this.street = street;
        this.streetNo = streetNo;
        this.code = code;
        this.surname = surname;
        this.name = name;
    }


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
