package com.lacrobate.converter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lacrobate.mapper.FeatureMapper;
import com.lacrobate.model.Constant;
import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.geojson.CRS;
import com.lacrobate.model.output.geojson.Feature;
import com.lacrobate.model.output.geojson.GeoJsonResult;
import com.lacrobate.model.output.umap.UmapObject;
import com.lacrobate.utils.ConverterUtils;
import com.lacrobate.utils.Profile;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.SpreadsheetReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class XlsToUmapHandler extends XLSHandler {
    private Logger log = LoggerFactory.getLogger(XlsToUmapHandler.class);




    @Override
    public void process() {

    }
}
