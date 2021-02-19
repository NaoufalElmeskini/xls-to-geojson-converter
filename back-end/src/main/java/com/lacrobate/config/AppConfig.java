package com.lacrobate.config;

import org.springframework.context.annotation.Configuration;


public interface AppConfig {

    String getXlsSourcePath();

    String getXlsxSourcePath();

    String getTargetPath();
}
