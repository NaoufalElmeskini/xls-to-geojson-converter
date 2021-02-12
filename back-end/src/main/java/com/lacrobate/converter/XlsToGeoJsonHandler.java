package com.lacrobate.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lacrobate.config.AppConfig;
import com.lacrobate.model.output.umap.UmapObject;
import com.lacrobate.utils.ConverterUtils;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.SpreadsheetReader;
import com.lacrobate.mapper.FeatureMapper;
import com.lacrobate.model.Constant;
import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.geojson.CRS;
import com.lacrobate.model.output.geojson.Feature;
import com.lacrobate.model.output.geojson.GeoJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class XlsToGeoJsonHandler extends XLSHandler{
    private Logger log = LoggerFactory.getLogger(XlsToGeoJsonHandler.class);

    private String sourcePath;
    private String targetPath;
    private static final String SOURCE_FILE_NAME = "source.xls";
    private static final String TARGET_FILE_NAME = "target.geojson";

    @Autowired
    private FeatureMapper mapper;

    @Autowired
    private AppConfig appConfig;

    @Value("${spring.profiles.active}")
    public String profile;

    @PostConstruct
    public void init() {
        this.sourcePath = appConfig.getSourcePath();
        this.targetPath = appConfig.getTargetPath();
    }


    @Override
    public void process() {
        List<XLSRow> rowList = getXlsRowList();

        GeoJsonResult resultObject = preparerGeoJsonObject(rowList);

        writeJsonFileFrom(resultObject);
    }

    private void writeJsonFileFrom(GeoJsonResult resultObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //beautify output
        try {
            objectMapper.writeValue(new File(this.targetPath), resultObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<XLSRow> getXlsRowList() {
        try {
            SpreadsheetReader sheetReader = ConverterUtils.getSpreadsheetReader(this.SOURCE_FILE_NAME);
            File file = new File(this.sourcePath);
            List<XLSRow> rowList = null;
            rowList = sheetReader.read(XLSRow.class, file);
            return rowList;
        } catch (SpreadsheetReadException e) {
            e.printStackTrace();
            return null;
        }
    }

    private GeoJsonResult preparerGeoJsonObject(List<XLSRow> rowList) {
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
