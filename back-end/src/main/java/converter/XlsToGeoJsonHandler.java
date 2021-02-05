package converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.SpreadsheetReader;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.reader.XlsxReader;
import mapper.FeatureMapper;
import model.Constant;
import model.XLSRow;
import model.output.CRS;
import model.output.Feature;
import model.output.GeoJsonObject;
import org.mapstruct.factory.Mappers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XlsToGeoJsonHandler {
    private String sourcePath;
    private String targetPath;
    private static final String SOURCE_FILE_NAME = "source-origin.xlsx";
    private static final String TARGET_FILE_NAME = "target.geojson";

    private FeatureMapper mapper;

    public XlsToGeoJsonHandler(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public XlsToGeoJsonHandler() {
        this.sourcePath = getStaticSourceFilePath();
        this.targetPath = getStaticTargetFilePath();
        this.mapper = Mappers.getMapper(FeatureMapper.class);
    }

    private String getStaticSourceFilePath() {
        String sourcePath = System.getProperty("user.dir"); //get the absolute url of the project root
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
                .append(SOURCE_FILE_NAME)
                .toString();

        return sourcePath;
    }

    private String getStaticTargetFilePath() {
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
                .append(TARGET_FILE_NAME)
                .toString();

        return targetPath;
    }

    public void process() throws IOException, SpreadsheetReadException {
        SpreadsheetReader sheetReader = getSpreadsheetReader();
        File file = new File(sourcePath);
        List<XLSRow> rowList = sheetReader.read(XLSRow.class, file);

        GeoJsonObject resultObject = preparerResultObject(rowList);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //beautify output
        objectMapper.writeValue(new File(targetPath), resultObject);
    }

    private SpreadsheetReader getSpreadsheetReader() {
        SpreadsheetReader sheetReader;
        if (SOURCE_FILE_NAME.endsWith(".xlsx")) {
            sheetReader = new XlsxReader();
        } else {
            sheetReader = new XlsReader();
        }
        return sheetReader;
    }

    private GeoJsonObject preparerResultObject(List<XLSRow> rowList) {
        GeoJsonObject result = new GeoJsonObject();

        result.setType(Constant.RESULT_TYPE_DEFAULT_VALUE);
        result.setName(Constant.RESULT_NAME_DEFAULT_VALUE);
        result.setCrs(preparerResultCRS());
        result.setFeatures(preparerResultFeatures(rowList));

        return result;
    }

    private List<Feature> preparerResultFeatures(List<XLSRow> rowList) {
        List<Feature> featureList = new ArrayList<>();
        Feature feature;

        for (XLSRow row : rowList) {
            feature = mapper.xlsRowToFeature(row);
            featureList.add(feature);
        }

        return featureList;
    }

    private CRS preparerResultCRS() {
        CRS crs = new CRS();
        return crs;
    }
}
