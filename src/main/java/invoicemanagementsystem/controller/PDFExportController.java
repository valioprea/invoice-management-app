package invoicemanagementsystem.controller;
import invoicemanagementsystem.service.InjectInfoService;
import invoicemanagementsystem.service.PrintToPDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PDFExportController {

    @Autowired
    PrintToPDFService printToPDFService;

    @Autowired
    InjectInfoService injectInfo;

    @GetMapping("/invoice/{id}/print")
    public ResponseEntity<byte[]> generatePDF(@PathVariable Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" +"myInvoice");
        return printToPDFService.generatePdfFile("invoicePage", injectInfo.injectInfo(id));
    }
}
