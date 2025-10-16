package com.example.lab6_listycity;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private final String city;
    private final String province;

    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCityName() {
        return this.city;
    }

    public String getProvinceName() {
        return this.province;
    }

    @Override
    public int compareTo(City o) {
        int ret = this.city.compareTo(o.getCityName());
        if (ret != 0) {
            return ret;
        }
        return this.province.compareTo(o.getProvinceName());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return this.compareTo(city1) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    @NonNull
    @Override
    public String toString() {
        return "City{" +
            "city='" + city + '\'' +
            ", province='" + province + '\'' +
            '}';
    }
}
