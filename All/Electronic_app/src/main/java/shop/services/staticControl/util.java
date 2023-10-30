package shop.services.staticControl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public interface util {
    
    public static String fetchHTML(String url, String charSet) {
        URLConnection connection;
        try {
            connection = new URL(url).openConnection();
            try (Scanner scanner = new Scanner(connection.getInputStream(), charSet)) {
                scanner.useDelimiter("\\Z");
                return scanner.next();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return new StringBuilder("<h3>").append(e.getMessage()).append("</h3>").toString();
        }
    }

    public static BufferedImage generateQrCode(String text, int width, int height) throws Exception {
        BitMatrix matrix = new QRCodeWriter().encode(text,
                BarcodeFormat.QR_CODE, width, height);
        return MatrixToImageWriter.toBufferedImage(matrix);
    }
    
    public static BufferedImage generateBarCode(String text) {
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(300, BufferedImage.TYPE_BYTE_GRAY, true, 0);
        //Create the barcode bean
        Code128Bean bean = new Code128Bean();
 
        //Configure the barcode generator
        bean.setModuleWidth(UnitConv.in2mm(1.0f / 150));
        bean.doQuietZone(false);
        bean.generateBarcode(canvas, text);
        
        return canvas.getBufferedImage();
    }

    public static Object[] addArr(boolean last, Object[] base, Object value) {
        Object[] agrs = new Object[base.length + 1];
        System.arraycopy(base, 0, agrs, last ? 0 : 1, base.length);
        agrs[last ? base.length : 0] = value;
        return agrs;
    }

    public static void exportExcel(DefaultTableModel model) throws Exception {
        // header name
        String[] columnNames = new String[model.getColumnCount()];
        for (int i = 0; i < columnNames.length; i++) {
            columnNames[i] = model.getColumnName(i);
        }

        // copy data
        Object[][] data = new Object[model.getRowCount()][model.getColumnCount()];
        List<Vector> list = model.getDataVector();
        int size = list.size();
        for (int index = 0; index < size; index++) {
            data[index] = list.get(index).toArray();
        }

        // write file data
        File file = ExcelExport.writeExcel(columnNames, data, null);
        if (file != null && file.canRead()) {
            Desktop.getDesktop().open(file);
        }
    }

    public static void jasperReport(Map<String, Object> parameters, InputStream is) throws JRException {
        JasperDesign jasperDesign = JRXmlLoader.load(is);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        JasperViewer.viewReport(jasperPrint, false);
    }
}
