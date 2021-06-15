package dk.usedmarket.domain;

public class Location {
    private final String zip;
    private final String city;

    public Location(String zip, String city) {
        this.zip = zip;
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }
}
