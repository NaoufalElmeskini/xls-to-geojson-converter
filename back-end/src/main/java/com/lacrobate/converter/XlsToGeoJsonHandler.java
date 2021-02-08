package com.lacrobate.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.SpreadsheetReader;
import com.lacrobate.mapper.FeatureMapper;
import com.lacrobate.model.Constant;
import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.CRS;
import com.lacrobate.model.output.Feature;
import com.lacrobate.model.output.GeoJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class XlsToGeoJsonHandler {
    private String sourcePath;
    private String targetPath;
    private static final String SOURCE_FILE_NAME = "source-origin.xls";
    private static final String TARGET_FILE_NAME = "target.geojson";

    @Autowired
    private FeatureMapper mapper;

    public XlsToGeoJsonHandler() {
        this.sourcePath = ConverterUtils.getAbsoluteSourceFilePath(SOURCE_FILE_NAME);
        this.targetPath = ConverterUtils.getAbsoluteTargetFilePath(TARGET_FILE_NAME);
    }



    public void process() throws IOException, SpreadsheetReadException {
        SpreadsheetReader sheetReader = ConverterUtils.getSpreadsheetReader(SOURCE_FILE_NAME);
        File file = new File(sourcePath);
        List<XLSRow> rowList = sheetReader.read(XLSRow.class, file);

        GeoJsonResult resultObject = preparerResultObject(rowList);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //beautify output
        objectMapper.writeValue(new File(targetPath), resultObject);
    }


    private GeoJsonResult preparerResultObject(List<XLSRow> rowList) {
        GeoJsonResult result = new GeoJsonResult();

        result.setType(Constant.RESULT_TYPE_DEFAULT_VALUE);
        result.setName(Constant.RESULT_NAME_DEFAULT_VALUE);
        result.setCrs(preparerResultCRS());
        result.setFeatures(preparerResultFeatures(rowList));

        return result;
    }

    private List<Feature> preparerResultFeatures(List<XLSRow> rowList) {
        List<Feature> featureList = new ArrayList<>();
        Feature feature;

        for (XLSRow row : rowList) {
            feature = mapper.xlsRowToFeature(row);
            featureList.add(feature);
        }

        return featureList;
    }

    private CRS preparerResultCRS() {
        return new CRS();
    }
}
