package com.lacrobate.model.output.umap;

import com.lacrobate.model.output.common.Feature;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private String type;
    private List<Feature> features;
    private UmapOptions _umap_options;

    public Layer() {
        this.type = "FeatureCollection";
        this._umap_options = new UmapOptions();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public UmapOptions get_umap_options() {
        return _umap_options;
    }

    public void set_umap_options(UmapOptions _umap_options) {
        this._umap_options = _umap_options;
    }
}
