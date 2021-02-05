package application;

import converter.XlsToGeoJsonHandler;
import io.github.millij.poi.SpreadsheetReadException;

import java.io.IOException;

public class Main {
    private static XlsToGeoJsonHandler converter;

    public static void main(String[] args) {
        converter = new XlsToGeoJsonHandler();
        try {
            System.out.println("Start processing");
            converter.process();
            System.out.println("end of processing.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpreadsheetReadException e) {
            e.printStackTrace();
        }
    }
}
