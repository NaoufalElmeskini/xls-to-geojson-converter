package model.output;

import java.util.ArrayList;
import java.util.List;

public class GeoJsonObject {
    private String type;
    private String name;

    private CRS crs;
    private List<Feature> features;

    public GeoJsonObject() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CRS getCrs() {
        return crs;
    }

    public void setCrs(CRS crs) {
        this.crs = crs;
    }

    public List<Feature> getFeatures() {
        if (this.features == null) {
            this.features = new ArrayList<>();
        }
        return this.features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
