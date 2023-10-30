package shop.services.staticControl;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.poi.EmptyFileException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelExport {
    
    public static List<Object[]> readExcel(String path, int sheetOfIndex) throws IOException {
        if (path == null) {
            path = openPath();
        }
        File file = new File(path);
        List<Object[]> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file); Workbook wb = getWorkbook(fis, path)) {
            Sheet s = wb.getSheetAt(sheetOfIndex);
            Iterator<Row> iterator = s.iterator();
            // get rows
            List<Object> rows = new LinkedList<>();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                // get cells
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rows.add(cell.getCellType());
                }
                list.add(rows.toArray());
            }
            list.remove(0); // remove headName
        }
        return list;
    }
    
    public static File writeExcel(String[] columnNames, Object[][] data, String path) throws Exception {
        if (path == null) {
            path = savePath();
        }
        
        File file = new File(path);
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("File export");
            int row = 0, length = columnNames.length, size = data.length;
            CellStyle cs;

            // set header
            cs = cellStyle(workbook, IndexedColors.WHITE, IndexedColors.BLUE1, true);
            cs.setBorderBottom(BorderStyle.DOUBLE);
            cs.setFillPattern(FillPatternType.DIAMONDS);
            Row crw = sheet.createRow(row);
            crw.setHeight((short) -1);
            ExcelExport.createRow(crw, cs, length, columnNames);

            // set data
            cs = cellStyle(workbook, IndexedColors.BLACK, IndexedColors.WHITE, false);
            cs.setBorderBottom(BorderStyle.THIN);
            cs.setFillPattern(FillPatternType.NO_FILL);
            do {
                ExcelExport.createRow(sheet.createRow(row + 1), cs, length, data[row]);
            } while (++row < size);

            // auto resize column
            for (int i = 0; i < length; i++) {
                sheet.autoSizeColumn(i);
            }

            // write file
            try (FileOutputStream out = new FileOutputStream(file.getPath())) {
                workbook.write(out);
            }
            
            return file;
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public static boolean updateExcel(Object[][] data, String path, int sheetOfIndex) {
        if (path == null) {
            return false;
        }
        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(path))) {
            XSSFSheet s = workbook.getSheetAt(sheetOfIndex);
            // TODO

            FileOutputStream outFile = new FileOutputStream(new File(path));
            workbook.write(outFile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    private static void createRow(Row row, CellStyle cs, int length, Object[] values) {
        for (int i = 0; i < length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(String.valueOf(values[i]));
            cell.setCellStyle(cs);
        }
    }
    
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }
    
    private static CellStyle cellStyle(Workbook wb, IndexedColors color, IndexedColors bgr, boolean bold) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        
        font.setBold(bold);
        font.setColor(color.index);
        font.setFontHeightInPoints((short) 16);
        
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setFillBackgroundColor(bgr.index);
        style.setAlignment(HorizontalAlignment.CENTER);
        
        return style;
    }

    // get path from open file
    private static String openPath() throws EmptyFileException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == 0) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            throw new EmptyFileException();
        }
    }

    // get path from save file
    private static String savePath() throws HeadlessException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(null) == 0) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            return (path.endsWith(".xls") || path.endsWith(".xlsx")) ? path : path + ".xlsx";
        } else {
            throw new HeadlessException("path does not exist!");
        }
    }
}
