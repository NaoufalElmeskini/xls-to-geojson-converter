package com.lacrobate.model.output.geojson;

public class Properties {
    private Integer id_aghyre;

    private String id_externe;

    private String nom_capteur;

    private String type_capteur;

    private String nom_site;

    private String nom_long_station;

    private String nom_rubrique;

    private String type_grandeur;

    private Float longitude;

    private Float latitude;

    private String source;


    public Integer getId_aghyre() {
        return id_aghyre;
    }

    public void setId_aghyre(Integer id_aghyre) {
        this.id_aghyre = id_aghyre;
    }

    public String getId_externe() {
        return id_externe;
    }

    public void setId_externe(String id_externe) {
        this.id_externe = id_externe;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNom_site() {
        return nom_site;
    }

    public void setNom_site(String nom_site) {
        this.nom_site = nom_site;
    }

    public String getNom_long_station() {
        return nom_long_station;
    }

    public void setNom_long_station(String nom_long_station) {
        this.nom_long_station = nom_long_station;
    }

    public String getNom_capteur() {
        return nom_capteur;
    }

    public void setNom_capteur(String nom_capteur) {
        this.nom_capteur = nom_capteur;
    }

    public String getNom_rubrique() {
        return nom_rubrique;
    }

    public void setNom_rubrique(String nom_rubrique) {
        this.nom_rubrique = nom_rubrique;
    }

    public String getType_grandeur() {
        return type_grandeur;
    }

    public void setType_grandeur(String type_grandeur) {
        this.type_grandeur = type_grandeur;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getType_capteur() {
        return type_capteur;
    }

    public void setType_capteur(String type_capteur) {
        this.type_capteur = type_capteur;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "id_aghyre=" + id_aghyre +
                ", id_externe='" + id_externe + '\'' +
                ", source='" + source + '\'' +
                ", nom_site='" + nom_site + '\'' +
                ", nom_long_station='" + nom_long_station + '\'' +
                ", nom_capteur='" + nom_capteur + '\'' +
                ", nom_rubrique='" + nom_rubrique + '\'' +
                ", type_grandeur='" + type_grandeur + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", type_capteur='" + type_capteur + '\'' +
                '}';
    }
}
