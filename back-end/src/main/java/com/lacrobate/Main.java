package com.lacrobate;

import com.lacrobate.config.AppConfig;
import com.lacrobate.converter.XlsToGeoJsonHandler;
import com.lacrobate.converter.XlsToUmapHandler;
import com.lacrobate.utils.Profile;
import io.github.millij.poi.SpreadsheetReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import java.io.IOException;

@SpringBootApplication
public class Main implements CommandLineRunner{
    private Logger log = LoggerFactory.getLogger(Main.class);
    @Autowired
    private XlsToGeoJsonHandler converter;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("conversion: starting...\n");
        converter.process();
        log.info("\nconversion: success.");
    }
}
