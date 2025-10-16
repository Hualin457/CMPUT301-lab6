package com.example.lab6_listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        // Different instances but with the same city name and province
        // should be considered to be equal
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
        // the check is case-sensitive
        assertFalse(cityList.hasCity(new City("Edmonton", "alberta")));
        // Calgary is not in the list yet
        assertFalse(cityList.hasCity(new City("Calgary", "AB")));
        cityList.add(new City("Calgary", "AB"));
        // Calgary is added to the list, now it should return true
        assertTrue(cityList.hasCity(new City("Calgary", "AB")));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City calgary = new City("Calgary", "AB");
        cityList.add(calgary);
        assertEquals(2, cityList.getCities().size());
        // existence check is case-sensitive
        assertThrows(IllegalStateException.class, () -> {
            cityList.deleteCity(new City("Edmonton", "alberta"));
        });
        cityList.deleteCity(new City("Edmonton", "Alberta"));
        // the list should have Calgary only
        assertEquals(1, cityList.getCities().size());
        assertEquals(cityList.getCities().get(0), calgary);
        // empty the list
        cityList.deleteCity(calgary);
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        // originally has 1 city
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Edmonton", "alberta"));
        assertEquals(2, cityList.countCities());
        cityList.add(new City("Calgary", "AB"));
        assertEquals(3, cityList.countCities());
        cityList.deleteCity(mockCity());
        assertEquals(2, cityList.countCities());
    }
}
