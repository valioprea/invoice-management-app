package invoicemanagementsystem.entities.dto;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceDTO {

    //Two parties: the provider & the beneficiary
    private String date;

    //PROVIDER INFO
    private String providerName;
    private String providerAdress;
    private String registrationCode;
    private String socialCapital;
    private String providerCUI;
    private String legalForm;

    //BENEFICIARY INFO
    private String beneficiaryName;
    private String beneficiaryAdress;
    private String beneficiaryCUI;

    //The list of purchased items
    private List<ItemDTO> itemList;

    //Getter methods to map the actual entity

    public String getDate() {
        return date;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderAdress() {
        return providerAdress;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public String getSocialCapital() {
        return socialCapital;
    }

    public String getProviderCUI() {
        return providerCUI;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public String getBeneficiaryAdress() {
        return beneficiaryAdress;
    }

    public String getBeneficiaryCUI() {
        return beneficiaryCUI;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        List<ItemDTO> lista = itemList.stream().map(itemDTO -> {return itemDTO;}).collect(Collectors.toList());
        return "InvoiceDTO{" +
                "date='" + date + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerAdress='" + providerAdress + '\'' +
                ", registrationCode='" + registrationCode + '\'' +
                ", socialCapital='" + socialCapital + '\'' +
                ", CUI='" + providerCUI + '\'' +
                ", legalForm='" + legalForm + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", beneficiaryAdress='" + beneficiaryAdress + '\'' +
                ", beneficiaryCUI='" + beneficiaryCUI + '\'' +
                ", itemList=" + lista +
                '}';
    }
}
