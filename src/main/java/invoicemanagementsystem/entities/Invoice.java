package invoicemanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {

    //Unique generated value of invoice
    @Id
    @GeneratedValue
    private Long invoiceId;
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
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Item> itemList = new ArrayList<>();

    //Totals, calculated
    private double totalPriceNoVAT;
    private double totalPriceWithVAT;

    //Setter Methods
    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setProviderAdress(String providerAdress) {
        this.providerAdress = providerAdress;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public void setSocialCapital(String socialCapital) {
        this.socialCapital = socialCapital;
    }

    public void setProviderCUI(String providerCUI) {
        this.providerCUI = providerCUI;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public void setBeneficiaryAdress(String beneficiaryAdress) {
        this.beneficiaryAdress = beneficiaryAdress;
    }

    public void setBeneficiaryCUI(String beneficiaryCUI) {
        this.beneficiaryCUI = beneficiaryCUI;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    //Method to attach ItemDTO's to the Item List
    public void setItem(Item item){
        this.itemList.add(item);
        item.setInvoice(this);
    }

    public void setTotalPriceNoVAT(double totalPriceNoVAT) {
        this.totalPriceNoVAT = totalPriceNoVAT;
    }

    public void setTotalPriceWithVAT(double totalPriceWithVAT) {
        this.totalPriceWithVAT = totalPriceWithVAT;
    }

    //Getter methods
    public Long getInvoiceId() {
        return invoiceId;
    }

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

    public List<Item> getItemList() {
        return itemList;
    }

    public double getTotalPriceNoVAT() {
        return totalPriceNoVAT;
    }

    public double getTotalPriceWithVAT() {
        return totalPriceWithVAT;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", date='" + date + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerAdress='" + providerAdress + '\'' +
                ", registrationCode='" + registrationCode + '\'' +
                ", socialCapital='" + socialCapital + '\'' +
                ", providerCUI='" + providerCUI + '\'' +
                ", legalForm='" + legalForm + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", beneficiaryAdress='" + beneficiaryAdress + '\'' +
                ", beneficiaryCUI='" + beneficiaryCUI + '\'' +
                ", itemList=" + itemList +
                ", totalPriceNoVAT=" + totalPriceNoVAT +
                ", totalPriceWithVAT=" + totalPriceWithVAT +
                '}';
    }
}
