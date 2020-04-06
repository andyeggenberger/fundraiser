package co.agital.fundraiser.entities;

public class Site {

    private Integer id;
    private String placeId;
    private String address;
    private double latitude;
    private double longitude;

    public Site(String placeId, String address, double latitude, double longitude) {
        this.placeId = placeId;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", placeId='" + placeId + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
