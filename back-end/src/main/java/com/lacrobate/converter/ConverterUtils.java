package com.lacrobate.converter;

import io.github.millij.poi.ss.reader.SpreadsheetReader;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.reader.XlsxReader;

import java.io.File;

public class ConverterUtils {
    private static final String DEFAULT_SOURCE_FILE_NAME = "source-origin.xls";
    private static final String DEFAULT_TARGET_FILE_NAME = "target.geojson";


    public static SpreadsheetReader getSpreadsheetReader(String sourceFileName) {
        SpreadsheetReader sheetReader;
        if (sourceFileName.endsWith(".xlsx")) {
            sheetReader = new XlsxReader();
        } else {
            sheetReader = new XlsReader();
        }
        return sheetReader;
    }

    public static String getAbsoluteSourceFilePath(String sourceFileName) {
        String sourcePath = System.getProperty("user.dir"); //get the absolute url of the project root
        System.out.println("/*********************************/");
        System.out.println("sourcePath: " + sourcePath);
        System.out.println("/*********************************/");
        sourcePath = (new StringBuilder(sourcePath))
                .append(File.separator)
                .append("back-end")
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("source")
                .append(File.separator)
                .append(sourceFileName)
                .toString();

        sourcePath = "C:\\Users\\naoufal\\Documents\\source\\" + sourceFileName;
        return sourcePath;
    }

    public static String getAbsoluteSourceFilePath() {
        return getAbsoluteSourceFilePath(DEFAULT_SOURCE_FILE_NAME);
    }

    public static String getAbsoluteTargetFilePath(String targetFileName) {
        String targetPath = System.getProperty("user.dir"); //get the absolute url of the project root
        targetPath = (new StringBuilder(targetPath))
                .append(File.separator)
                .append("back-end")
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("target")
                .append(File.separator)
                .append(targetFileName)
                .toString();
        targetPath = "C:\\Users\\naoufal\\Documents\\target\\" + targetFileName;

        return targetPath;
    }

    public static String getAbsoluteTargetFilePath() {
        return getAbsoluteTargetFilePath(DEFAULT_TARGET_FILE_NAME);
    }

}
