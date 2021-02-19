package com.lacrobate.config;

import com.lacrobate.utils.ConverterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("DEV")
public class DevConfig implements AppConfig{
    private static Logger log = LoggerFactory.getLogger(DevConfig.class);

    @Override
    public String getXlsSourcePath() {
        return ConverterUtils.getAbsoluteXlsSourceFilePath();
    }

    @Override
    public String getXlsxSourcePath() {
        return ConverterUtils.getAbsoluteXlsxSourceFilePath();
    }

    @Override
    public String getTargetPath() {
        return ConverterUtils.getAbsoluteTargetFilePath();
    }
}
