package com.lacrobate.mapper;

import com.lacrobate.model.Constant;
import com.lacrobate.model.output.GeometryTypeEnum;
import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.Feature;
import com.lacrobate.model.output.Geometry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface FeatureMapper {

    @Mapping(source = "row", target = "type", qualifiedByName = "featureTypeQualifier")
    @Mapping(source = "row", target = "properties")
    @Mapping(source = "row", target = "geometry", qualifiedByName = "geometryQualifier")
    Feature xlsRowToFeature(XLSRow row);

    @Named("featureTypeQualifier")
    default String toFeatureType(XLSRow row) {
        return Constant.FEATURE_TYPE_DEFAULT_VALUE;
    }

    @Named("geometryQualifier")
    default Geometry toGeometry(XLSRow row) {
        Geometry geometry = new Geometry();

        geometry.setType(GeometryTypeEnum.Point.name());
        float[] coordinates = new float[2];
        coordinates[0] = row.getLongitude();
        coordinates[1] = row.getLatitude();

        geometry.setCoordinates(coordinates);
        return geometry;
    }

}
