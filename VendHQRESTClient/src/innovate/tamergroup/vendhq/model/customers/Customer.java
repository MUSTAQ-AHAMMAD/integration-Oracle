package innovate.tamergroup.vendhq.model.customers;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Customer {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("source_unique_id")
    @Expose
    private String sourceUniqueId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("year_to_date")
    @Expose
    private Double yearToDate;
    @SerializedName("balance")
    @Expose
    private Double balance;
    @SerializedName("loyalty_balance")
    @Expose
    private Double loyaltyBalance;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("do_not_email")
    @Expose
    private Boolean doNotEmail;
    @SerializedName("loyalty_email_sent")
    @Expose
    private Boolean loyaltyEmailSent;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("website")
    @Expose
    private String website;
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
    @SerializedName("postal_suburb")
    @Expose
    private String postalSuburb;
    @SerializedName("postal_city")
    @Expose
    private String postalCity;
    @SerializedName("postal_state")
    @Expose
    private String postalState;
    @SerializedName("customer_group_id")
    @Expose
    private String customerGroupId;
    @SerializedName("enable_loyalty")
    @Expose
    private Boolean enableLoyalty;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Date deletedAt;
    @SerializedName("customer_group_ids")
    @Expose
    private List<String> customerGroupIds = null;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("postal_postcode")
    @Expose
    private String postalPostcode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("physical_address_1")
    @Expose
    private String physicalAddress1;
    @SerializedName("physical_address_2")
    @Expose
    private String physicalAddress2;
    @SerializedName("physical_country_id")
    @Expose
    private String physicalCountryId;
    @SerializedName("postal_address_1")
    @Expose
    private String postalAddress1;
    @SerializedName("postal_address_2")
    @Expose
    private String postalAddress2;
    @SerializedName("postal_country_id")
    @Expose
    private String postalCountryId;
    @SerializedName("custom_field_1")
    @Expose
    private String customField1;
    @SerializedName("custom_field_2")
    @Expose
    private String customField2;
    @SerializedName("custom_field_3")
    @Expose
    private String customField3;
    @SerializedName("custom_field_4")
    @Expose
    private String customField4;
    @SerializedName("time_until_deletion")
    @Expose
    private Long timeUntilDeletion;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setSourceUniqueId(String sourceUniqueId) {
        this.sourceUniqueId = sourceUniqueId;
    }

    public String getSourceUniqueId() {
        return sourceUniqueId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setYearToDate(Double yearToDate) {
        this.yearToDate = yearToDate;
    }

    public Double getYearToDate() {
        return yearToDate;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setLoyaltyBalance(Double loyaltyBalance) {
        this.loyaltyBalance = loyaltyBalance;
    }

    public Double getLoyaltyBalance() {
        return loyaltyBalance;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setDoNotEmail(Boolean doNotEmail) {
        this.doNotEmail = doNotEmail;
    }

    public Boolean getDoNotEmail() {
        return doNotEmail;
    }

    public void setLoyaltyEmailSent(Boolean loyaltyEmailSent) {
        this.loyaltyEmailSent = loyaltyEmailSent;
    }

    public Boolean getLoyaltyEmailSent() {
        return loyaltyEmailSent;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setPhysicalSuburb(String physicalSuburb) {
        this.physicalSuburb = physicalSuburb;
    }

    public String getPhysicalSuburb() {
        return physicalSuburb;
    }

    public void setPhysicalCity(String physicalCity) {
        this.physicalCity = physicalCity;
    }

    public String getPhysicalCity() {
        return physicalCity;
    }

    public void setPhysicalPostcode(String physicalPostcode) {
        this.physicalPostcode = physicalPostcode;
    }

    public String getPhysicalPostcode() {
        return physicalPostcode;
    }

    public void setPhysicalState(String physicalState) {
        this.physicalState = physicalState;
    }

    public String getPhysicalState() {
        return physicalState;
    }

    public void setPostalSuburb(String postalSuburb) {
        this.postalSuburb = postalSuburb;
    }

    public String getPostalSuburb() {
        return postalSuburb;
    }

    public void setPostalCity(String postalCity) {
        this.postalCity = postalCity;
    }

    public String getPostalCity() {
        return postalCity;
    }

    public void setPostalState(String postalState) {
        this.postalState = postalState;
    }

    public String getPostalState() {
        return postalState;
    }

    public void setCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getCustomerGroupId() {
        return customerGroupId;
    }

    public void setEnableLoyalty(Boolean enableLoyalty) {
        this.enableLoyalty = enableLoyalty;
    }

    public Boolean getEnableLoyalty() {
        return enableLoyalty;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setCustomerGroupIds(List<String> customerGroupIds) {
        this.customerGroupIds = customerGroupIds;
    }

    public List<String> getCustomerGroupIds() {
        return customerGroupIds;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setPostalPostcode(String postalPostcode) {
        this.postalPostcode = postalPostcode;
    }

    public String getPostalPostcode() {
        return postalPostcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhysicalAddress1(String physicalAddress1) {
        this.physicalAddress1 = physicalAddress1;
    }

    public String getPhysicalAddress1() {
        return physicalAddress1;
    }

    public void setPhysicalAddress2(String physicalAddress2) {
        this.physicalAddress2 = physicalAddress2;
    }

    public String getPhysicalAddress2() {
        return physicalAddress2;
    }

    public void setPhysicalCountryId(String physicalCountryId) {
        this.physicalCountryId = physicalCountryId;
    }

    public String getPhysicalCountryId() {
        return physicalCountryId;
    }

    public void setPostalAddress1(String postalAddress1) {
        this.postalAddress1 = postalAddress1;
    }

    public String getPostalAddress1() {
        return postalAddress1;
    }

    public void setPostalAddress2(String postalAddress2) {
        this.postalAddress2 = postalAddress2;
    }

    public String getPostalAddress2() {
        return postalAddress2;
    }

    public void setPostalCountryId(String postalCountryId) {
        this.postalCountryId = postalCountryId;
    }

    public String getPostalCountryId() {
        return postalCountryId;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getCustomField4() {
        return customField4;
    }

    public void setTimeUntilDeletion(Long timeUntilDeletion) {
        this.timeUntilDeletion = timeUntilDeletion;
    }

    public Long getTimeUntilDeletion() {
        return timeUntilDeletion;
    }
}
