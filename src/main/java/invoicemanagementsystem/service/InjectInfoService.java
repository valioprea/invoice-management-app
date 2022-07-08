package invoicemanagementsystem.service;
import invoicemanagementsystem.entities.Invoice;
import invoicemanagementsystem.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InjectInfoService {

    private static final DecimalFormat df = new DecimalFormat("0.00");
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
        List<Item> formattedList = myInvoice.getItemList()
                        .stream().map(item -> {
                            Item formattedItem = new Item();
                            formattedItem.setItemName(item.getItemName());
                            formattedItem.setItemQuantity(InjectInfoService.round(item.getItemQuantity(),2));
                            formattedItem.setApplicableVAT(InjectInfoService.round(item.getApplicableVAT(),2));
                            formattedItem.setPricePerUnitNoVAT(InjectInfoService.round(item.getPricePerUnitNoVAT(),2));
                            formattedItem.setPricePerUnitWithVAT();
                            formattedItem.setPricePerQuantityNoVAT();
                            formattedItem.setPricePerQuantityWithVAT();
                            formattedItem.setPricePerUnitWithVAT_ROUNDED(InjectInfoService.round(item.getPricePerUnitWithVAT(),2));
                            formattedItem.setPricePerQuantityNoVAT_ROUNDED(InjectInfoService.round(item.getPricePerQuantityNoVAT(),2));
                            formattedItem.setPricePerQuantityWithVAT_ROUNDED(InjectInfoService.round(item.getPricePerQuantityWithVAT(),2));
                            return formattedItem;
                }).collect(Collectors.toList());
        infoInjection.put("itemList", formattedList);

        //attributes to inject - the total costs
        infoInjection.put("totalPriceWithoutVAT", df.format(myInvoice.getTotalPriceNoVAT()));
        infoInjection.put("totalPriceWithVAT", df.format(myInvoice.getTotalPriceWithVAT()));

        return  infoInjection;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
