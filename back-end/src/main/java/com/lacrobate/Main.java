package com.lacrobate;

import com.lacrobate.converter.XlsToUmapHandler;
import io.github.millij.poi.SpreadsheetReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main implements CommandLineRunner{
    private Logger log = LoggerFactory.getLogger(Main.class);

    @Autowired
    private XlsToUmapHandler converter;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("conversion: starting...\n");
        try {
            converter.process();
            log.info("\nconversion: success.");
        } catch (SpreadsheetReadException e) {
            log.error("il semble que des difficultés ont été rencontrées lors du traitement...");
            log.error("conversion: echec :(");
        }
    }
}
