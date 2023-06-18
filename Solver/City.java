public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return String.format("City {" +
            "name = '%s', region = '%s'," + 
            "district = '%s', population = %d," +
            "foundation = '%s'}", 
            name, region, district, population, foundation.trim());
    }
}