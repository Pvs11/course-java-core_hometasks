package homework.home_work_3.test;

import java.util.List;
import java.util.function.Predicate;

import static homework.home_work_3.main.CityUtil.getCities;
import static homework.home_work_3.main.CityUtil.getCityCount;

public class CityUtilDemo {

    public static void main(String[] args) {
        List<String> listOfCities = List.of("Minsk", "Madrid", "Lisbon", "Paris", "Brest", "Minsk", "Nicaragua");

        Predicate<String> uniqueCities = (str) -> listOfCities.stream().filter((city) -> city.equals(str)).count() == 1;
        Predicate<String> lengthMoreThanSix = (str) -> str.length() > 6;
        Predicate<String> startWith = (str) -> str.startsWith("B");

        System.out.println(getCities(listOfCities, uniqueCities));
        System.out.println(getCities(listOfCities, lengthMoreThanSix));
        System.out.println(getCities(listOfCities, startWith));
        System.out.println("Repetitions of specified city: " + getCityCount(listOfCities, "Minsk"));
    }
}
