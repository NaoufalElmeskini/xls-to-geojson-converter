package com.lacrobate.model.output.umap;

public class UmapOptions {
    private boolean displayOnLoad;
    private boolean browsable;
    private String name;
    private EmptyObject remoteData;
    private int id;
    private String color;
    private String iconClass;

    public UmapOptions() {
        this.displayOnLoad = false;
        this.browsable = true;
        this.remoteData = new EmptyObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public boolean isDisplayOnLoad() {
        return displayOnLoad;
    }

    public void setDisplayOnLoad(boolean displayOnLoad) {
        this.displayOnLoad = displayOnLoad;
    }

    public boolean isBrowsable() {
        return browsable;
    }

    public void setBrowsable(boolean browsable) {
        this.browsable = browsable;
    }
}
