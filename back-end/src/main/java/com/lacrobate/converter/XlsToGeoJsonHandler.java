package com.lacrobate.converter;

import com.lacrobate.model.Constant;
import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.geojson.CRS;
import com.lacrobate.model.output.common.Feature;
import com.lacrobate.model.output.geojson.GeoJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class XlsToGeoJsonHandler extends XLSHandler {
    private Logger log = LoggerFactory.getLogger(XlsToGeoJsonHandler.class);

    public XlsToGeoJsonHandler() {
        this.TARGET_FILE_EXTENSION = ".geojson";
    }

    @Override
    protected GeoJsonResult createResultObjectFrom(List<XLSRow> rowList) {
        GeoJsonResult result = new GeoJsonResult();

        result.setType(Constant.RESULT_TYPE_DEFAULT_VALUE);
        result.setName(Constant.RESULT_NAME_DEFAULT_VALUE);
        result.setCrs(createCRS());
        result.setFeatures(createFeaturesFrom(rowList));

        return result;
    }

    private List<Feature> createFeaturesFrom(List<XLSRow> rowList) {
        List<Feature> featureList = new ArrayList<>();
        Feature feature;

        for (XLSRow row : rowList) {
            feature = mapper.xlsRowToFeature(row);
            featureList.add(feature);
        }

        return featureList;
    }

    private CRS createCRS() {
        return new CRS();
    }
}
