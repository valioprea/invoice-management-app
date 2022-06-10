package invoicemanagementsystem.printservice;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PdfGeneratorService {

    public void export(HttpServletResponse response, String jsonStr) throws IOException {
        Document document = new Document(PageSize.A4); //lowagi imported
        PdfWriter.getInstance(document, response.getOutputStream()); //lowagi imported ( the doc , destination to write the pdf)

        document.open();
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph = new Paragraph(jsonStr, fontParagraph);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph);
        document.close();
    }
}
