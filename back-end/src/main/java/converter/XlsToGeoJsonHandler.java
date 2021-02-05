package converter;

import model.XLSRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XlsToGeoJsonHandler {
    private String sourcePath;
    private static final String FILE_NAME  = "source.xls";

    public XlsToGeoJsonHandler(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public XlsToGeoJsonHandler() {
        this.sourcePath = getStaticSourceFilePath();
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
                .append(FILE_NAME)
                .toString();

        return sourcePath;
    }

    public void process() throws IOException {
        FileInputStream fis = new FileInputStream(new File(sourcePath));
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheetAt(0);

        FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

        for (Row row : sheet) {
            XLSRow pointVNF = getPointFromRow(row, formulaEvaluator);

            System.out.println(pointVNF);
        }
    }

    private XLSRow getPointFromRow(Row row, FormulaEvaluator formulaEvaluator) {
        XLSRow pointVnf = new XLSRow();

        for (Cell cell : row) {
            switch (formulaEvaluator.evaluateInCell(cell).getCellTypeEnum()) {
                case NUMERIC:
                    System.out.println("[num] " + cell.getNumericCellValue() + "\t\t");
                    break;
                case STRING:
                    System.out.println("[str] " + cell.getStringCellValue() + "\t\t");
                    break;
            }
        }

        return pointVnf;
    }
}
