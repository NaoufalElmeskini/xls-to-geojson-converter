package model;


public class XLSRow {
    private Integer ID_AGHYRE;
    private String ID_EXTERNE;
    private String SOURCE;
    private String NOM_SITE;
    private String NOM_LONG_STATION;
    private String NOM_CAPTEUR;
    private String NOM_RUBRIQUE;
    private String TYPE_GRANDEUR;
    private String DECLENCHEMENT;
    private Float PK;
    private String TYPE_COORDONNEES;
    private Float LONGITUDE;
    private Float LATITUDE;
    private Float L93_X;
    private Float L93_Y;
    private String TYPE_CAPTEUR;

    public XLSRow() {
    }

    public Integer getID_AGHYRE() {
        return ID_AGHYRE;
    }

    public void setID_AGHYRE(Integer ID_AGHYRE) {
        this.ID_AGHYRE = ID_AGHYRE;
    }

    public String getID_EXTERNE() {
        return ID_EXTERNE;
    }

    public void setID_EXTERNE(String ID_EXTERNE) {
        this.ID_EXTERNE = ID_EXTERNE;
    }

    public String getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(String SOURCE) {
        this.SOURCE = SOURCE;
    }

    public String getNOM_SITE() {
        return NOM_SITE;
    }

    public void setNOM_SITE(String NOM_SITE) {
        this.NOM_SITE = NOM_SITE;
    }

    public String getNOM_LONG_STATION() {
        return NOM_LONG_STATION;
    }

    public void setNOM_LONG_STATION(String NOM_LONG_STATION) {
        this.NOM_LONG_STATION = NOM_LONG_STATION;
    }

    public String getNOM_CAPTEUR() {
        return NOM_CAPTEUR;
    }

    public void setNOM_CAPTEUR(String NOM_CAPTEUR) {
        this.NOM_CAPTEUR = NOM_CAPTEUR;
    }

    public String getNOM_RUBRIQUE() {
        return NOM_RUBRIQUE;
    }

    public void setNOM_RUBRIQUE(String NOM_RUBRIQUE) {
        this.NOM_RUBRIQUE = NOM_RUBRIQUE;
    }

    public String getTYPE_GRANDEUR() {
        return TYPE_GRANDEUR;
    }

    public void setTYPE_GRANDEUR(String TYPE_GRANDEUR) {
        this.TYPE_GRANDEUR = TYPE_GRANDEUR;
    }

    public String getDECLENCHEMENT() {
        return DECLENCHEMENT;
    }

    public void setDECLENCHEMENT(String DECLENCHEMENT) {
        this.DECLENCHEMENT = DECLENCHEMENT;
    }

    public Float getPK() {
        return PK;
    }

    public void setPK(Float PK) {
        this.PK = PK;
    }

    public String getTYPE_COORDONNEES() {
        return TYPE_COORDONNEES;
    }

    public void setTYPE_COORDONNEES(String TYPE_COORDONNEES) {
        this.TYPE_COORDONNEES = TYPE_COORDONNEES;
    }

    public Float getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(Float LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public Float getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(Float LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public Float getL93_X() {
        return L93_X;
    }

    public void setL93_X(Float l93_X) {
        L93_X = l93_X;
    }

    public Float getL93_Y() {
        return L93_Y;
    }

    public void setL93_Y(Float l93_Y) {
        L93_Y = l93_Y;
    }

    public String getTYPE_CAPTEUR() {
        return TYPE_CAPTEUR;
    }

    public void setTYPE_CAPTEUR(String TYPE_CAPTEUR) {
        this.TYPE_CAPTEUR = TYPE_CAPTEUR;
    }

    @Override
    public String toString() {
        return "XLSRow{" +
                "ID_AGHYRE=" + ID_AGHYRE +
                ", ID_EXTERNE='" + ID_EXTERNE + '\'' +
                ", SOURCE='" + SOURCE + '\'' +
                ", NOM_SITE='" + NOM_SITE + '\'' +
                ", NOM_LONG_STATION='" + NOM_LONG_STATION + '\'' +
                ", NOM_CAPTEUR='" + NOM_CAPTEUR + '\'' +
                ", NOM_RUBRIQUE='" + NOM_RUBRIQUE + '\'' +
                ", TYPE_GRANDEUR='" + TYPE_GRANDEUR + '\'' +
                ", DECLENCHEMENT='" + DECLENCHEMENT + '\'' +
                ", PK=" + PK +
                ", TYPE_COORDONNEES='" + TYPE_COORDONNEES + '\'' +
                ", LONGITUDE=" + LONGITUDE +
                ", LATITUDE=" + LATITUDE +
                ", L93_X=" + L93_X +
                ", L93_Y=" + L93_Y +
                ", TYPE_CAPTEUR='" + TYPE_CAPTEUR + '\'' +
                '}';
    }
}
