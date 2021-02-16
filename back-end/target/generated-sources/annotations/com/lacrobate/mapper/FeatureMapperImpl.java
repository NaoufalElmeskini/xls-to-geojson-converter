package com.lacrobate.mapper;

import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.common.Feature;
import com.lacrobate.model.output.geojson.Properties;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-12T17:41:51+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_282 (AdoptOpenJDK)"
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
        properties.setDeclenchement( xLSRow.getDeclenchement() );
        properties.setPk( xLSRow.getPk() );
        properties.setType_coordonnees( xLSRow.getType_coordonnees() );
        properties.setLongitude( xLSRow.getLongitude() );
        properties.setLatitude( xLSRow.getLatitude() );
        properties.setL93_x( xLSRow.getL93_x() );
        properties.setL93_y( xLSRow.getL93_y() );
        properties.setType_capteur( xLSRow.getType_capteur() );

        return properties;
    }
}
