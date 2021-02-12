package com.lacrobate.config;

import org.springframework.context.annotation.Configuration;


public interface AppConfig {

    public String getSourcePath();

    public String getTargetPath();
}
