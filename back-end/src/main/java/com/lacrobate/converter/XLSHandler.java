package com.lacrobate.converter;

import com.lacrobate.mapper.FeatureMapper;
import com.lacrobate.utils.ConverterUtils;
import com.lacrobate.utils.Profile;
import io.github.millij.poi.SpreadsheetReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public abstract class XLSHandler {
    protected Logger log = LoggerFactory.getLogger(XLSHandler.class);

    protected String sourcePath;
    protected String targetPath;
    protected static final String SOURCE_FILE_NAME = "source.xls";
    protected static final String TARGET_FILE_NAME = "target.geojson";

    @Autowired
    protected FeatureMapper mapper;

    public XLSHandler() {
        Profile profile = Profile.DEV;

        if (profile.equals(Profile.PROD)) {
            String jarParentPath = ConverterUtils.getJarParentPath();

            this.sourcePath = jarParentPath + "\\source\\" + SOURCE_FILE_NAME;
            this.targetPath = jarParentPath + "\\target\\" + TARGET_FILE_NAME;
        } else {
            this.sourcePath = ConverterUtils.getAbsoluteSourceFilePath(SOURCE_FILE_NAME);
            this.targetPath = ConverterUtils.getAbsoluteTargetFilePath(TARGET_FILE_NAME);
        }

        log.info("this.sourcePath: " + this.sourcePath);
        log.info("this.targetPath: " + this.targetPath);
    }

    public abstract void process();

}
