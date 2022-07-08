package invoicemanagementsystem.service;
import invoicemanagementsystem.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class InjectInfoService {

    @Autowired
    InvoiceService invoiceService;

    public HashMap<String, Object> injectInfo(Long id){
        Invoice myInvoice =  invoiceService.getInvoiceById(id);
        HashMap<String, Object> infoInjection = new HashMap<>();

        //attributes to inject - for invoice data
        infoInjection.put("invoiceId", myInvoice.getInvoiceId());
        infoInjection.put("date", myInvoice.getDate());

        //attributes to inject - for provider data
        infoInjection.put("providerName", myInvoice.getProviderName());
        infoInjection.put("providerAdress", myInvoice.getProviderAdress());
        infoInjection.put("registrationCode", myInvoice.getRegistrationCode());
        infoInjection.put("socialCapital", myInvoice.getSocialCapital());
        infoInjection.put("providerCUI", myInvoice.getProviderCUI());
        infoInjection.put("legalForm", myInvoice.getLegalForm());

        //attributes to inject - for beneficiary data
        infoInjection.put("beneficiaryName", myInvoice.getBeneficiaryName());
        infoInjection.put("beneficiaryAdress", myInvoice.getBeneficiaryAdress());
        infoInjection.put("beneficiaryCUI", myInvoice.getBeneficiaryCUI());

        //attributes to inject - the item list
        infoInjection.put("itemList", myInvoice.getItemList());

        //attributes to inject - the total costs
        infoInjection.put("totalPriceWithoutVAT", myInvoice.getTotalPriceNoVAT());
        infoInjection.put("totalPriceWithVAT", myInvoice.getTotalPriceWithVAT());

        return  infoInjection;
    }
}
