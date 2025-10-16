package com.example.lab6_listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     * @throws IllegalArgumentException If the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException(city.toString() + " is already in the list");
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This check if the city is in the list.
     * Two {@link City} objects are considered to be equal
     * if their {@link City#getCityName()} and
     * {@link City#getProvinceName()} are equal, case-sensitive.
     * @param city This is a candidate city to check
     * @return true if the city already exists, false otherwise.
     * @see City#equals
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Remove the city from list if it is in the list.
     * @param city The city to be removed.
     * @throws IllegalStateException If the city is not in the list.
     */
    public void deleteCity(City city) {
        int index = cities.indexOf(city);
        if (index == -1) {
            throw new IllegalStateException(city.toString() + " is not in the list.");
        }
        cities.remove(index);
    }

    /**
     * Return the number of cities contained in the list.
     * @return Number of cities contained in the list.
     */
    public int countCities() {
        return cities.size();
    }
}
