package com.lacrobate.model.output.umap;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lacrobate.model.output.common.Geometry;

import java.util.ArrayList;
import java.util.List;

public class UmapObject {
    private String type = "umap";
    private UmapObjectProperties properties;
    private Geometry geometry;
    private List<Layer> layers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UmapObjectProperties getProperties() {
        return properties;
    }

    public void setProperties(UmapObjectProperties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<Layer> getLayers() {
        if (this.layers == null) {
            this.layers = new ArrayList<>();
        }
        return this.layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    @Override
    public String toString() {
        return "UmapObject{" +
                "type='" + type + '\'' +
                ", properties=" + properties +
                ", geometry=" + geometry +
                ", layers=" + layers +
                '}';
    }
}
