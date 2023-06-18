import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        CityService cityService = new CityService();
        String filename = "./task.csv";
        Path path = Paths.get(filename);
        Scanner scanner = new Scanner(path);

        scanner.useDelimiter("\n");
        while(scanner.hasNext()) {
            City city = cityService.parseCSVCity(scanner.next());
            cityService.addCity(city);
        }
        scanner.close();
        // cityService.sortByName();
        cityService.sortByRegionAndName();
        cityService.getCities().forEach(c -> {
            System.out.println(c);
        });
    }
}

class CityService {
    private List<City> cities = new ArrayList<>();

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public City parseCSVCity(String line) {
        City city = new City();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.nextInt();
        city.setName(scanner.next());
        city.setRegion(scanner.next());
        city.setDistrict(scanner.next());
        city.setPopulation(scanner.nextInt());
        city.setFoundation(scanner.next());
        scanner.close();
        return city;
    }

    public List<City> sortByName() {
        Collections.sort(cities, new Comparator<City>() {
            public int compare(City a, City b) {
                return a.getName().compareTo(b.getName());
            }
        });
        return cities;
    }

    public List<City> sortByRegionAndName() {
        Collections.sort(cities, new Comparator<City>() {
            public int compare(City a, City b) {
                return a.getRegion().compareTo(b.getRegion()) * -1 <= 0 ? -1 : 1;
                // && a.getName().compareTo(b.getName()) > 0 ? 1 : 0;
            }
        });
        return cities;
    }
}
