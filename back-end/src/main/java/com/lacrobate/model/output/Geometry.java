package com.lacrobate.model.output;

public class Geometry {
    private String type;
    private float[] coordinates;

    public Geometry() {
        this.coordinates = new float[2];
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }
}
