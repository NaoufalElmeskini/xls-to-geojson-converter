package com.lacrobate.model;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet
public class XLSRow {

    @SheetColumn("ID_AGHYRE")
    private Integer id_aghyre;

    @SheetColumn("ID_EXTERNE")
    private String id_externe;

    @SheetColumn("SOURCE")
    private String source;

    @SheetColumn("NOM_SITE")
    private String nom_site;

    @SheetColumn("NOM_LONG_STATION")
    private String nom_long_station;

    @SheetColumn("NOM_CAPTEUR")
    private String nom_capteur;

    @SheetColumn("NOM_RUBRIQUE")
    private String nom_rubrique;

    @SheetColumn("TYPE_GRANDEUR")
    private String type_grandeur;

    @SheetColumn("DECLENCHEMENT")
    private String declenchement;

    @SheetColumn("PK")
    private Float pk;

    @SheetColumn("TYPE_COORDONNEES")
    private String type_coordonnees;

    @SheetColumn("LONGITUDE")
    private Float longitude;

    @SheetColumn("LATITUDE")
    private Float latitude;

    @SheetColumn("L93_X")
    private Float l93_x;

    @SheetColumn("L93_Y")
    private Float l93_y;

    @SheetColumn("TYPE_CAPTEUR")
    private String type_capteur;


    public XLSRow() {
    }

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

    public String getDeclenchement() {
        return declenchement;
    }

    public void setDeclenchement(String declenchement) {
        this.declenchement = declenchement;
    }

    public Float getPk() {
        return pk;
    }

    public void setPk(Float pk) {
        this.pk = pk;
    }

    public String getType_coordonnees() {
        return type_coordonnees;
    }

    public void setType_coordonnees(String type_coordonnees) {
        this.type_coordonnees = type_coordonnees;
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

    public Float getL93_x() {
        return l93_x;
    }

    public void setL93_x(Float l93_x) {
        this.l93_x = l93_x;
    }

    public Float getL93_y() {
        return l93_y;
    }

    public void setL93_y(Float l93_y) {
        this.l93_y = l93_y;
    }

    public String getType_capteur() {
        return type_capteur;
    }

    public void setType_capteur(String type_capteur) {
        this.type_capteur = type_capteur;
    }

    @Override
    public String toString() {
        return "XLSRow{" +
                "id_aghyre=" + id_aghyre +
                ", id_externe='" + id_externe + '\'' +
                ", source='" + source + '\'' +
                ", nom_site='" + nom_site + '\'' +
                ", nom_long_station='" + nom_long_station + '\'' +
                ", nom_capteur='" + nom_capteur + '\'' +
                ", nom_rubrique='" + nom_rubrique + '\'' +
                ", type_grandeur='" + type_grandeur + '\'' +
                ", declenchement='" + declenchement + '\'' +
                ", pk=" + pk +
                ", type_coordonnees='" + type_coordonnees + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", l93_x=" + l93_x +
                ", l93_y=" + l93_y +
                ", type_capteur='" + type_capteur + '\'' +
                '}';
    }
}
