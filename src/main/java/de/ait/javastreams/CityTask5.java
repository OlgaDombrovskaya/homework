package de.ait.javastreams;

import java.util.Comparator;
import java.util.Optional;

public class CityTask5 {
    /**
     * Метод для поиска города с минимальным населением.
     *
     * @return Optional, содержащий город с минимальным населением
     *
     * Method to find the city with the minimum population.
     *
     * @return an Optional containing the city with the minimum population
     */
    private static CityTestData data = new CityTestData();

    public static void main(String[] args) {
        Optional<City> cityWithMinPopulation = getCityWithMinPopulation();
        cityWithMinPopulation.ifPresent(city ->
                System.out.println("Город с минимальным населением: " + city.getName())
        );
    }

    public static Optional<City> getCityWithMinPopulation() {
        return data.getCities().stream()
                .min(Comparator.comparingInt(City::getPopulation));
    }
}