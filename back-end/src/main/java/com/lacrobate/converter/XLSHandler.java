package com.lacrobate.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lacrobate.config.AppConfig;
import com.lacrobate.mapper.FeatureMapper;
import com.lacrobate.model.XLSRow;
import com.lacrobate.utils.ConverterUtils;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.SpreadsheetReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class XLSHandler {
    private Logger log = LoggerFactory.getLogger(XLSHandler.class);

    protected String TARGET_FILE_EXTENSION;

    @Autowired
    protected FeatureMapper mapper;

    @Autowired
    protected AppConfig appConfig;


    public void process() {
        try {
            List<XLSRow> rowList = getXlsRowList();
            Object resultObject = createResultObjectFrom(rowList);
            writeJsonFileFrom(resultObject);
        } catch (SpreadsheetReadException e) {
            e.printStackTrace();
            log.error("veuillez vous assurer que le fichier source est bien present dans l'emplacement source");
            log.error("Emplacement source : " + appConfig.getSourcePath());
        }
    }

    protected List<XLSRow> getXlsRowList() throws SpreadsheetReadException {
        String sourcePath = appConfig.getSourcePath();
        SpreadsheetReader sheetReader = ConverterUtils.getSpreadsheetReader();
        File file = new File(sourcePath);
        List<XLSRow> rowList = null;
        rowList = sheetReader.read(XLSRow.class, file);
        return rowList;
    }

    protected void writeJsonFileFrom(Object resultObject) {
        ObjectMapper objectMapper = getDecoratedObjectMapper();
        try {
            String targetPath = appConfig.getTargetPath() + TARGET_FILE_EXTENSION;
            objectMapper.writeValue(new File(targetPath), resultObject);
            log.info("Umap file generated in: " + targetPath);
        } catch (IOException e) {
            log.error("error while writing json to file");
            e.printStackTrace();
        }
    }

    private ObjectMapper getDecoratedObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //beautify output
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return objectMapper;
    }

    protected abstract Object createResultObjectFrom(List<XLSRow> rowList);

}
