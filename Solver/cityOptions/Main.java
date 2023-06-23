import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

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
        Map<String, Integer> result = cityService.getCountCitiesInRegions();
        for (Map.Entry<String, Integer> item : result.entrySet()) {
            System.out.println(item);
        }

        scanner.close();
    }
}

class CityService {
    private List<City> cities = new LinkedList<>();

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

    public Map<String, Integer> getCountCitiesInRegions() {
        Map<String, Integer> res = new HashMap<>();
        Iterator<City> cityIterator = cities.iterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            if (res.containsKey(city.getRegion())) {
                res.replace(city.getRegion(), res.get(city.getRegion()) + 1);
            } else {
                res.put(city.getRegion(), 1);
            }
        }
        return res;
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
                int district = a.getDistrict().compareTo(b.getDistrict()); 
                int name = a.getName().compareTo(b.getName());
                if (district == 0) {
                    district += name;
                }
                return district;
            }
        });
        return cities;
    }

    public int getIndexLargestPopulationCity() {
        City[] citiesArray = new City[cities.size()];
        Iterator<City> citiesIterator = cities.iterator();
        int i = 0, resIndex = 0, population = 0;
        while (citiesIterator.hasNext()) {
            citiesArray[i] = citiesIterator.next();
            int populationTmp = citiesArray[i].getPopulation();
            if (i == 0) {
                population = populationTmp;
                resIndex = i;
            }
            if (population < populationTmp) {
                population = populationTmp;
                resIndex = i;
            }
            i++;
        }
        return resIndex;
    }
}
