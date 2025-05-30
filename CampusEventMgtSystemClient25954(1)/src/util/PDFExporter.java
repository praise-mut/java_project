package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;

public class PDFExporter {

    public static void exportTableToPDF(JTable table, String title) {
        Document document = new Document(PageSize.A4.rotate());

        try {
            String userHome = System.getProperty("user.home");
            String downloadsPath = userHome + "/Downloads/" + title.replaceAll("\\s+", "_") + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(downloadsPath));
            document.open();

            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph heading = new Paragraph(title, font);
            heading.setAlignment(Element.ALIGN_CENTER);
            heading.setSpacingAfter(20);
            document.add(heading);

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Add column headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Phrase(table.getColumnName(i))));
            }

            // Add table rows
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    Object value = table.getValueAt(rows, cols);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            document.add(pdfTable);
            System.out.println("PDF successfully created in Downloads folder: " + downloadsPath);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
