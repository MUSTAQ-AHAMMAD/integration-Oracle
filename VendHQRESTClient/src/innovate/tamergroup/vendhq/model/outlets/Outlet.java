package innovate.tamergroup.vendhq.model.outlets;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import innovate.tamergroup.vendhq.model.shared.Attribute;

public class Outlet {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("default_tax_id")
    @Expose
    private String defaultTaxId;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("currency_symbol")
    @Expose
    private String currencySymbol;
    @SerializedName("display_prices")
    @Expose
    private String displayPrices;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("physical_address_1")
    @Expose
    private String physicalAddress1;
    @SerializedName("physical_address_2")
    @Expose
    private String physicalAddress2;
    @SerializedName("physical_suburb")
    @Expose
    private String physicalSuburb;
    @SerializedName("physical_city")
    @Expose
    private String physicalCity;
    @SerializedName("physical_postcode")
    @Expose
    private String physicalPostcode;
    @SerializedName("physical_state")
    @Expose
    private String physicalState;
    @SerializedName("physical_country_id")
    @Expose
    private String physicalCountryId;
    @SerializedName("deleted_at")
    @Expose
    private Date deletedAt;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    
    public String getId() {
    return id;
    }
    
    public void setId(String id) {
    this.id = id;
    }
    
    public String getName() {
    return name;
    }
    
    public void setName(String name) {
    this.name = name;
    }
    
    public String getDefaultTaxId() {
    return defaultTaxId;
    }
    
    public void setDefaultTaxId(String defaultTaxId) {
    this.defaultTaxId = defaultTaxId;
    }
    
    public String getCurrency() {
    return currency;
    }
    
    public void setCurrency(String currency) {
    this.currency = currency;
    }
    
    public String getCurrencySymbol() {
    return currencySymbol;
    }
    
    public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
    }
    
    public String getDisplayPrices() {
    return displayPrices;
    }
    
    public void setDisplayPrices(String displayPrices) {
    this.displayPrices = displayPrices;
    }
    
    public String getTimeZone() {
    return timeZone;
    }
    
    public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
    }
    
    public String getPhysicalAddress1() {
    return physicalAddress1;
    }
    
    public void setPhysicalAddress1(String physicalAddress1) {
    this.physicalAddress1 = physicalAddress1;
    }
    
    public String getPhysicalAddress2() {
    return physicalAddress2;
    }
    
    public void setPhysicalAddress2(String physicalAddress2) {
    this.physicalAddress2 = physicalAddress2;
    }
    
    public String getPhysicalSuburb() {
    return physicalSuburb;
    }
    
    public void setPhysicalSuburb(String physicalSuburb) {
    this.physicalSuburb = physicalSuburb;
    }
    
    public String getPhysicalCity() {
    return physicalCity;
    }
    
    public void setPhysicalCity(String physicalCity) {
    this.physicalCity = physicalCity;
    }
    
    public String getPhysicalPostcode() {
    return physicalPostcode;
    }
    
    public void setPhysicalPostcode(String physicalPostcode) {
    this.physicalPostcode = physicalPostcode;
    }
    
    public String getPhysicalState() {
    return physicalState;
    }
    
    public void setPhysicalState(String physicalState) {
    this.physicalState = physicalState;
    }
    
    public String getPhysicalCountryId() {
    return physicalCountryId;
    }
    
    public void setPhysicalCountryId(String physicalCountryId) {
    this.physicalCountryId = physicalCountryId;
    }
    
    public Date getDeletedAt() {
    return deletedAt;
    }
    
    public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
    }
    
    public Long getVersion() {
    return version;
    }
    
    public void setVersion(Long version) {
    this.version = version;
    }
    
    public List<Attribute> getAttributes() {
    return attributes;
    }
    
    public void setAttributes(List<Attribute> attributes) {
    this.attributes = attributes;
    }

}