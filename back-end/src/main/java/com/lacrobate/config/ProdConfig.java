package com.lacrobate.config;

import com.lacrobate.utils.ConverterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("PROD")
public class ProdConfig implements AppConfig{
    private static Logger log = LoggerFactory.getLogger(ProdConfig.class);
    private static String ROOT_DIRECTORY_PATH;

    public ProdConfig() {
        this.ROOT_DIRECTORY_PATH = ConverterUtils.getJarParentPath();
    }

    @Override
    public String getSourcePath() {
        return this.ROOT_DIRECTORY_PATH + "\\source\\" + ConverterUtils.DEFAULT_SOURCE_FILE_NAME;
    }

    @Override
    public String getTargetPath() {
        return this.ROOT_DIRECTORY_PATH + "\\target\\" + ConverterUtils.DEFAULT_TARGET_FILE_NAME;
    }
}
