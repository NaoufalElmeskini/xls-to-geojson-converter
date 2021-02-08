package com.lacrobate;

import com.lacrobate.converter.XlsToGeoJsonHandler;
import io.github.millij.poi.SpreadsheetReadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main implements CommandLineRunner{
    @Autowired
    private XlsToGeoJsonHandler converter;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println(args.length);
            System.out.println("conversion: starting...");
            converter.process();
            System.out.println("conversion: success.");
        } catch (IOException e) {
            System.err.println("Erreur lors d'ouverture de fichier...");
            e.printStackTrace();
        } catch (SpreadsheetReadException e) {
            System.err.println("Erreur lors de manipulation du fichier source...");
            e.printStackTrace();
        }
    }
}
