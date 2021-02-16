package com.lacrobate.utils;

import com.lacrobate.Main;
import io.github.millij.poi.ss.reader.SpreadsheetReader;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.reader.XlsxReader;



public class ConverterUtils {
    public static final String DEFAULT_SOURCE_FILE_NAME = "source.xls";
    public static final String DEFAULT_TARGET_FILE_NAME = "target";

    private static final String ABSOLUTE_SOURCE_DIR_PATH = "C:\\Users\\naoufal\\Documents\\convertisseur\\source\\";
    private static final String ABSOLUTE_TARGET_DIR_PATH = "C:\\Users\\naoufal\\Documents\\convertisseur\\target\\";


    public static SpreadsheetReader getSpreadsheetReader() {
        SpreadsheetReader sheetReader;
        if (DEFAULT_SOURCE_FILE_NAME.endsWith(".xlsx")) {
            sheetReader = new XlsxReader();
        } else {
            sheetReader = new XlsReader();
        }
        return sheetReader;
    }

    public static String getAbsoluteSourceFilePath(String sourceFileName) {
        return ABSOLUTE_SOURCE_DIR_PATH + sourceFileName;
    }

    public static String getAbsoluteSourceFilePath() {
        return getAbsoluteSourceFilePath(DEFAULT_SOURCE_FILE_NAME);
    }

    public static String getAbsoluteTargetFilePath(String targetFileName) {
        return ABSOLUTE_TARGET_DIR_PATH + targetFileName;
    }

    public static String getAbsoluteTargetFilePath() {
        return getAbsoluteTargetFilePath(DEFAULT_TARGET_FILE_NAME);
    }

    public static String getJarParentPath() {
        String jarPath = FileUtils.urlToFile(FileUtils.getLocation(Main.class)).getParentFile().getAbsolutePath();

        System.out.println("jarPath: ");
        System.out.println(jarPath);

        return jarPath;
    }
}
