package com.lacrobate.model.output.geojson;

import com.lacrobate.model.output.MapObject;
import com.lacrobate.model.output.common.Feature;

import java.util.ArrayList;
import java.util.List;

public class GeoJsonResult extends MapObject {
    private String type;
    private String name;

    private CRS crs;
    private List<Feature> features;

    public GeoJsonResult() {
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
