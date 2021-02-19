package com.lacrobate.utils;

import com.lacrobate.Main;
import com.lacrobate.model.Constant;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.SpreadsheetReader;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.reader.XlsxReader;



public class ConverterUtils {
    public static final String DEFAULT_SOURCE_FILE_NAME = "source";
    public static final String DEFAULT_TARGET_FILE_NAME = "target";

    private static final String ABSOLUTE_SOURCE_DIR_PATH = "C:\\Users\\naoufal\\Documents\\convertisseur\\source\\";
    private static final String ABSOLUTE_TARGET_DIR_PATH = "C:\\Users\\naoufal\\Documents\\convertisseur\\target\\";


    public static SpreadsheetReader getSpreadsheetReader(String filePath) throws SpreadsheetReadException {
        SpreadsheetReader sheetReader;
        if (filePath.endsWith(Constant.XLS_EXTENSION)) {
            sheetReader = new XlsReader();
        } else if (filePath.endsWith(Constant.XLSX_EXTENSION)){
            sheetReader = new XlsxReader();
        } else {
            throw new SpreadsheetReadException("source file is neither .xls nor .xlsx file");
        }
        return sheetReader;
    }

    public static String getAbsoluteSourceFilePath(String sourceFileName) {
        return ABSOLUTE_SOURCE_DIR_PATH + sourceFileName;
    }

    public static String getAbsoluteXlsSourceFilePath() {
        return getAbsoluteSourceFilePath(DEFAULT_SOURCE_FILE_NAME) + Constant.XLS_EXTENSION;
    }

    public static String getAbsoluteXlsxSourceFilePath() {
        return getAbsoluteSourceFilePath(DEFAULT_SOURCE_FILE_NAME) + Constant.XLSX_EXTENSION;
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
