package com.lacrobate.mapper;

import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.common.Feature;
import com.lacrobate.model.output.geojson.Properties;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-07T20:29:14+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class FeatureMapperImpl implements FeatureMapper {

    @Override
    public Feature xlsRowToFeature(XLSRow row) {
        if ( row == null ) {
            return null;
        }

        Feature feature = new Feature();

        feature.setType( toFeatureType( row ) );
        feature.setProperties( xLSRowToProperties( row ) );
        feature.setGeometry( toGeometry( row ) );

        return feature;
    }

    protected Properties xLSRowToProperties(XLSRow xLSRow) {
        if ( xLSRow == null ) {
            return null;
        }

        Properties properties = new Properties();

        properties.setId_aghyre( xLSRow.getId_aghyre() );
        properties.setId_externe( xLSRow.getId_externe() );
        properties.setSource( xLSRow.getSource() );
        properties.setNom_site( xLSRow.getNom_site() );
        properties.setNom_long_station( xLSRow.getNom_long_station() );
        properties.setNom_capteur( xLSRow.getNom_capteur() );
        properties.setNom_rubrique( xLSRow.getNom_rubrique() );
        properties.setType_grandeur( xLSRow.getType_grandeur() );
        properties.setLongitude( xLSRow.getLongitude() );
        properties.setLatitude( xLSRow.getLatitude() );
        properties.setType_capteur( xLSRow.getType_capteur() );

        return properties;
    }
}
