package test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class PDFTest {

    public static void main(String[] args) {
        Document document = new Document(PageSize.A4.rotate());

        try {
            String userHome = System.getProperty("user.home");
            String downloadsPath = userHome + "/Downloads/test_output.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(downloadsPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Hello, iText PDF!", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(30);
            document.add(title);

            PdfPTable table = new PdfPTable(3); // 3 columns
            table.setWidthPercentage(100);

            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Role");

            table.addCell("1");
            table.addCell("Jeremie");
            table.addCell("Admin");

            table.addCell("2");
            table.addCell("Grace");
            table.addCell("User");

            document.add(table);

            System.out.println(" PDF created successfully in your Downloads folder: " + downloadsPath);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
