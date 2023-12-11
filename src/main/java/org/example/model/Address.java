package org.example.model;


import java.util.Objects;

public class Address implements Comparable<Address>{
    private String city;
    private String street;
    private Integer house;
    private Integer floor;

    public Address(String city, String street, int house, int floor) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
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

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!Objects.equals(city, address.city)) return false;
        if (!Objects.equals(street, address.street)) return false;
        if (!Objects.equals(house, address.house)) return false;
        return Objects.equals(floor, address.floor);
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        return result;
    }



    @Override
    public int compareTo(Address a) {
        int result = this.city.compareTo(a.getCity());

        if (result == 0) {
            result = this.street.compareTo(a.getStreet());
        }
        if (result == 0) {
            result = this.house.compareTo(a.getHouse());
        }
        if (result == 0) {
            result = this.floor.compareTo(a.getFloor());
        }

        return result;
    }
}
