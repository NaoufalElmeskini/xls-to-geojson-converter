package mapper;

import model.Constant;
import model.GeometryTypeEnum;
import model.XLSRow;
import model.output.Feature;
import model.output.GeoJsonObject;
import model.output.Geometry;
import model.output.Properties;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper
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
