package co.agital.fundraiser.json;

import java.util.List;

public class GeoResponse {

    private List<GeoResult> results;
    private String status;

    public List<GeoResult> getResults() {
        return results;
    }

    public void setResults(List<GeoResult> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GeoLocation getLocation() {
        return results.get(0).getGeometry().getLocation();
    }

    public String getPlaceId() {
        return results.get(0).getPlaceId();
    }

    public String getFormattedAddress() {
        return results.get(0).getFormattedAddress();
    }

    @Override
    public String toString() {
        return "Response{" +
                "geoResults=" + results +
                ", status='" + status + '\'' +
                '}';
    }

}
