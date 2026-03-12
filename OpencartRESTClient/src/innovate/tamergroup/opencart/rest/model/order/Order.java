package innovate.tamergroup.opencart.rest.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Order {

    @SerializedName("order_id")
    @Expose
    private Long orderId;
    @SerializedName("invoice_no")
    @Expose
    private String invoiceNo;
    @SerializedName("invoice_prefix")
    @Expose
    private String invoicePrefix;
    @SerializedName("store_id")
    @Expose
    private Long storeId;
    @SerializedName("store_name")
    @Expose
    private String storeName;
    @SerializedName("store_url")
    @Expose
    private String storeUrl;
    @SerializedName("customer_id")
    @Expose
    private Long customerId;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("payment_firstname")
    @Expose
    private String paymentFirstname;
    @SerializedName("payment_lastname")
    @Expose
    private String paymentLastname;
    @SerializedName("payment_company")
    @Expose
    private String paymentCompany;
    @SerializedName("payment_address_1")
    @Expose
    private String paymentAddress1;
    @SerializedName("payment_address_2")
    @Expose
    private String paymentAddress2;
    @SerializedName("payment_postcode")
    @Expose
    private String paymentPostcode;
    @SerializedName("payment_city")
    @Expose
    private String paymentCity;
    @SerializedName("payment_zone_id")
    @Expose
    private Long paymentZoneId;
    @SerializedName("payment_zone")
    @Expose
    private String paymentZone;
    @SerializedName("payment_zone_code")
    @Expose
    private String paymentZoneCode;
    @SerializedName("payment_country_id")
    @Expose
    private Long paymentCountryId;
    @SerializedName("payment_country")
    @Expose
    private String paymentCountry;
    @SerializedName("payment_iso_code_2")
    @Expose
    private String paymentIsoCode2;
    @SerializedName("payment_iso_code_3")
    @Expose
    private String paymentIsoCode3;
    @SerializedName("payment_address_format")
    @Expose
    private String paymentAddressFormat;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("payment_code")
    @Expose
    private String paymentCode;
    @SerializedName("shipping_firstname")
    @Expose
    private String shippingFirstname;
    @SerializedName("shipping_lastname")
    @Expose
    private String shippingLastname;
    @SerializedName("shipping_company")
    @Expose
    private String shippingCompany;
    @SerializedName("shipping_address_1")
    @Expose
    private String shippingAddress1;
    @SerializedName("shipping_address_2")
    @Expose
    private String shippingAddress2;
    @SerializedName("shipping_postcode")
    @Expose
    private String shippingPostcode;
    @SerializedName("shipping_city")
    @Expose
    private String shippingCity;
    @SerializedName("shipping_zone_id")
    @Expose
    private Long shippingZoneId;
    @SerializedName("shipping_zone")
    @Expose
    private String shippingZone;
    @SerializedName("shipping_zone_code")
    @Expose
    private String shippingZoneCode;
    @SerializedName("shipping_country_id")
    @Expose
    private Long shippingCountryId;
    @SerializedName("shipping_country")
    @Expose
    private String shippingCountry;
    @SerializedName("shipping_iso_code_2")
    @Expose
    private String shippingIsoCode2;
    @SerializedName("shipping_iso_code_3")
    @Expose
    private String shippingIsoCode3;
    @SerializedName("shipping_address_format")
    @Expose
    private String shippingAddressFormat;
    @SerializedName("shipping_method")
    @Expose
    private String shippingMethod;
    @SerializedName("shipping_code")
    @Expose
    private String shippingCode;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("total")
    @Expose
    private Double total;
    @SerializedName("order_status_id")
    @Expose
    private Long orderStatusId;
    @SerializedName("language_id")
    @Expose
    private Long languageId;
    @SerializedName("language_code")
    @Expose
    private String languageCode;
    @SerializedName("language_filename")
    @Expose
    private String languageFilename;
    @SerializedName("language_directory")
    @Expose
    private String languageDirectory;
    @SerializedName("currency_id")
    @Expose
    private Long currencyId;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("currency_value")
    @Expose
    private String currencyValue;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("forwarded_ip")
    @Expose
    private String forwardedIp;
    @SerializedName("user_agent")
    @Expose
    private String userAgent;
    @SerializedName("accept_language")
    @Expose
    private String acceptLanguage;
    @SerializedName("date_modified")
    @Expose
    private Date dateModified;
    @SerializedName("date_added")
    @Expose
    private Date dateAdded;
    @SerializedName("products")
    @Expose
    private List<OrderProduct> products = null;
    @SerializedName("histories")
    @Expose
    private List<History> histories = null;
    @SerializedName("totals")
    @Expose
    private List<Total> totals = null;
    @SerializedName("shipping_exclude_tax")
    @Expose
    private Long shippingExcludeTax;
    @SerializedName("shipping_tax")
    @Expose
    private Long shippingTax;
    @SerializedName("shipping_lines")
    @Expose
    private List<ShippingLine> shippingLines = null;
    @SerializedName("item_total_tax")
    @Expose
    private Double itemTotalTax;
    @SerializedName("item_total_exclude_tax")
    @Expose
    private Double itemTotalExcludeTax;
    @SerializedName("subtotal")
    @Expose
    private Double subtotal;
    @SerializedName("coupons")
    @Expose
    private List<String> coupons = null;
    @SerializedName("discounts")
    @Expose
    private List<String> discounts = null;
    private final static long serialVersionUID = -8273879757507769504L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Order() {
    }

    /**
     *
     * @param total
     * @param dateModified
     * @param paymentLastname
     * @param paymentZoneCode
     * @param paymentCompany
     * @param invoicePrefix
     * @param invoiceNo
     * @param languageFilename
     * @param shippingCode
     * @param coupons
     * @param languageDirectory
     * @param shippingTax
     * @param fax
     * @param paymentZoneId
     * @param orderStatusId
     * @param shippingAddress1
     * @param subtotal
     * @param shippingAddress2
     * @param shippingIsoCode2
     * @param shippingIsoCode3
     * @param acceptLanguage
     * @param email
     * @param itemTotalExcludeTax
     * @param paymentPostcode
     * @param shippingCountry
     * @param paymentAddressFormat
     * @param comment
     * @param storeId
     * @param storeUrl
     * @param userAgent
     * @param currencyId
     * @param dateAdded
     * @param paymentFirstname
     * @param lastname
     * @param paymentIsoCode3
     * @param shippingPostcode
     * @param paymentIsoCode2
     * @param forwardedIp
     * @param shippingZoneId
     * @param customerId
     * @param shippingZone
     * @param paymentCountry
     * @param discounts
     * @param paymentAddress2
     * @param itemTotalTax
     * @param shippingAddressFormat
     * @param products
     * @param orderId
     * @param paymentAddress1
     * @param shippingLastname
     * @param shippingCountryId
     * @param currencyCode
     * @param paymentCountryId
     * @param storeName
     * @param shippingFirstname
     * @param shippingExcludeTax
     * @param shippingLines
     * @param firstname
     * @param shippingZoneCode
     * @param shippingMethod
     * @param currencyValue
     * @param paymentCity
     * @param languageId
     * @param ip
     * @param paymentCode
     * @param paymentZone
     * @param languageCode
     * @param shippingCompany
     * @param totals
     * @param histories
     * @param telephone
     * @param shippingCity
     * @param paymentMethod
     */
    public Order(Long orderId, String invoiceNo, String invoicePrefix, Long storeId, String storeName, String storeUrl,
                 Long customerId, String firstname, String lastname, String telephone, String fax, String email,
                 String paymentFirstname, String paymentLastname, String paymentCompany, String paymentAddress1,
                 String paymentAddress2, String paymentPostcode, String paymentCity, Long paymentZoneId,
                 String paymentZone, String paymentZoneCode, Long paymentCountryId, String paymentCountry,
                 String paymentIsoCode2, String paymentIsoCode3, String paymentAddressFormat, String paymentMethod,
                 String paymentCode, String shippingFirstname, String shippingLastname, String shippingCompany,
                 String shippingAddress1, String shippingAddress2, String shippingPostcode, String shippingCity,
                 Long shippingZoneId, String shippingZone, String shippingZoneCode, Long shippingCountryId,
                 String shippingCountry, String shippingIsoCode2, String shippingIsoCode3, String shippingAddressFormat,
                 String shippingMethod, String shippingCode, String comment, Double total, Long orderStatusId,
                 Long languageId, String languageCode, String languageFilename, String languageDirectory,
                 Long currencyId, String currencyCode, String currencyValue, String ip, String forwardedIp,
                 String userAgent, String acceptLanguage, Date dateModified, Date dateAdded,
                 List<OrderProduct> products, List<History> histories, List<Total> totals, Long shippingExcludeTax,
                 Long shippingTax, List<ShippingLine> shippingLines, Double itemTotalTax, Double itemTotalExcludeTax,
                 Double subtotal, List<String> coupons, List<String> discounts) {
        super();
        this.orderId = orderId;
        this.invoiceNo = invoiceNo;
        this.invoicePrefix = invoicePrefix;
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeUrl = storeUrl;
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.paymentFirstname = paymentFirstname;
        this.paymentLastname = paymentLastname;
        this.paymentCompany = paymentCompany;
        this.paymentAddress1 = paymentAddress1;
        this.paymentAddress2 = paymentAddress2;
        this.paymentPostcode = paymentPostcode;
        this.paymentCity = paymentCity;
        this.paymentZoneId = paymentZoneId;
        this.paymentZone = paymentZone;
        this.paymentZoneCode = paymentZoneCode;
        this.paymentCountryId = paymentCountryId;
        this.paymentCountry = paymentCountry;
        this.paymentIsoCode2 = paymentIsoCode2;
        this.paymentIsoCode3 = paymentIsoCode3;
        this.paymentAddressFormat = paymentAddressFormat;
        this.paymentMethod = paymentMethod;
        this.paymentCode = paymentCode;
        this.shippingFirstname = shippingFirstname;
        this.shippingLastname = shippingLastname;
        this.shippingCompany = shippingCompany;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingPostcode = shippingPostcode;
        this.shippingCity = shippingCity;
        this.shippingZoneId = shippingZoneId;
        this.shippingZone = shippingZone;
        this.shippingZoneCode = shippingZoneCode;
        this.shippingCountryId = shippingCountryId;
        this.shippingCountry = shippingCountry;
        this.shippingIsoCode2 = shippingIsoCode2;
        this.shippingIsoCode3 = shippingIsoCode3;
        this.shippingAddressFormat = shippingAddressFormat;
        this.shippingMethod = shippingMethod;
        this.shippingCode = shippingCode;
        this.comment = comment;
        this.total = total;
        this.orderStatusId = orderStatusId;
        this.languageId = languageId;
        this.languageCode = languageCode;
        this.languageFilename = languageFilename;
        this.languageDirectory = languageDirectory;
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyValue = currencyValue;
        this.ip = ip;
        this.forwardedIp = forwardedIp;
        this.userAgent = userAgent;
        this.acceptLanguage = acceptLanguage;
        this.dateModified = dateModified;
        this.dateAdded = dateAdded;
        this.products = products;
        this.histories = histories;
        this.totals = totals;
        this.shippingExcludeTax = shippingExcludeTax;
        this.shippingTax = shippingTax;
        this.shippingLines = shippingLines;
        this.itemTotalTax = itemTotalTax;
        this.itemTotalExcludeTax = itemTotalExcludeTax;
        this.subtotal = subtotal;
        this.coupons = coupons;
        this.discounts = discounts;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoicePrefix() {
        return invoicePrefix;
    }

    public void setInvoicePrefix(String invoicePrefix) {
        this.invoicePrefix = invoicePrefix;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentFirstname() {
        return paymentFirstname;
    }

    public void setPaymentFirstname(String paymentFirstname) {
        this.paymentFirstname = paymentFirstname;
    }

    public String getPaymentLastname() {
        return paymentLastname;
    }

    public void setPaymentLastname(String paymentLastname) {
        this.paymentLastname = paymentLastname;
    }

    public String getPaymentCompany() {
        return paymentCompany;
    }

    public void setPaymentCompany(String paymentCompany) {
        this.paymentCompany = paymentCompany;
    }

    public String getPaymentAddress1() {
        return paymentAddress1;
    }

    public void setPaymentAddress1(String paymentAddress1) {
        this.paymentAddress1 = paymentAddress1;
    }

    public String getPaymentAddress2() {
        return paymentAddress2;
    }

    public void setPaymentAddress2(String paymentAddress2) {
        this.paymentAddress2 = paymentAddress2;
    }

    public String getPaymentPostcode() {
        return paymentPostcode;
    }

    public void setPaymentPostcode(String paymentPostcode) {
        this.paymentPostcode = paymentPostcode;
    }

    public String getPaymentCity() {
        return paymentCity;
    }

    public void setPaymentCity(String paymentCity) {
        this.paymentCity = paymentCity;
    }

    public Long getPaymentZoneId() {
        return paymentZoneId;
    }

    public void setPaymentZoneId(Long paymentZoneId) {
        this.paymentZoneId = paymentZoneId;
    }

    public String getPaymentZone() {
        return paymentZone;
    }

    public void setPaymentZone(String paymentZone) {
        this.paymentZone = paymentZone;
    }

    public String getPaymentZoneCode() {
        return paymentZoneCode;
    }

    public void setPaymentZoneCode(String paymentZoneCode) {
        this.paymentZoneCode = paymentZoneCode;
    }

    public Long getPaymentCountryId() {
        return paymentCountryId;
    }

    public void setPaymentCountryId(Long paymentCountryId) {
        this.paymentCountryId = paymentCountryId;
    }

    public String getPaymentCountry() {
        return paymentCountry;
    }

    public void setPaymentCountry(String paymentCountry) {
        this.paymentCountry = paymentCountry;
    }

    public String getPaymentIsoCode2() {
        return paymentIsoCode2;
    }

    public void setPaymentIsoCode2(String paymentIsoCode2) {
        this.paymentIsoCode2 = paymentIsoCode2;
    }

    public String getPaymentIsoCode3() {
        return paymentIsoCode3;
    }

    public void setPaymentIsoCode3(String paymentIsoCode3) {
        this.paymentIsoCode3 = paymentIsoCode3;
    }

    public String getPaymentAddressFormat() {
        return paymentAddressFormat;
    }

    public void setPaymentAddressFormat(String paymentAddressFormat) {
        this.paymentAddressFormat = paymentAddressFormat;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getShippingFirstname() {
        return shippingFirstname;
    }

    public void setShippingFirstname(String shippingFirstname) {
        this.shippingFirstname = shippingFirstname;
    }

    public String getShippingLastname() {
        return shippingLastname;
    }

    public void setShippingLastname(String shippingLastname) {
        this.shippingLastname = shippingLastname;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingPostcode() {
        return shippingPostcode;
    }

    public void setShippingPostcode(String shippingPostcode) {
        this.shippingPostcode = shippingPostcode;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public Long getShippingZoneId() {
        return shippingZoneId;
    }

    public void setShippingZoneId(Long shippingZoneId) {
        this.shippingZoneId = shippingZoneId;
    }

    public String getShippingZone() {
        return shippingZone;
    }

    public void setShippingZone(String shippingZone) {
        this.shippingZone = shippingZone;
    }

    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    public void setShippingZoneCode(String shippingZoneCode) {
        this.shippingZoneCode = shippingZoneCode;
    }

    public Long getShippingCountryId() {
        return shippingCountryId;
    }

    public void setShippingCountryId(Long shippingCountryId) {
        this.shippingCountryId = shippingCountryId;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingIsoCode2() {
        return shippingIsoCode2;
    }

    public void setShippingIsoCode2(String shippingIsoCode2) {
        this.shippingIsoCode2 = shippingIsoCode2;
    }

    public String getShippingIsoCode3() {
        return shippingIsoCode3;
    }

    public void setShippingIsoCode3(String shippingIsoCode3) {
        this.shippingIsoCode3 = shippingIsoCode3;
    }

    public String getShippingAddressFormat() {
        return shippingAddressFormat;
    }

    public void setShippingAddressFormat(String shippingAddressFormat) {
        this.shippingAddressFormat = shippingAddressFormat;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageFilename() {
        return languageFilename;
    }

    public void setLanguageFilename(String languageFilename) {
        this.languageFilename = languageFilename;
    }

    public String getLanguageDirectory() {
        return languageDirectory;
    }

    public void setLanguageDirectory(String languageDirectory) {
        this.languageDirectory = languageDirectory;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getForwardedIp() {
        return forwardedIp;
    }

    public void setForwardedIp(String forwardedIp) {
        this.forwardedIp = forwardedIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public List<Total> getTotals() {
        return totals;
    }

    public void setTotals(List<Total> totals) {
        this.totals = totals;
    }

    public Long getShippingExcludeTax() {
        return shippingExcludeTax;
    }

    public void setShippingExcludeTax(Long shippingExcludeTax) {
        this.shippingExcludeTax = shippingExcludeTax;
    }

    public Long getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(Long shippingTax) {
        this.shippingTax = shippingTax;
    }

    public List<ShippingLine> getShippingLines() {
        return shippingLines;
    }

    public void setShippingLines(List<ShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public Double getItemTotalTax() {
        return itemTotalTax;
    }

    public void setItemTotalTax(Double itemTotalTax) {
        this.itemTotalTax = itemTotalTax;
    }

    public Double getItemTotalExcludeTax() {
        return itemTotalExcludeTax;
    }

    public void setItemTotalExcludeTax(Double itemTotalExcludeTax) {
        this.itemTotalExcludeTax = itemTotalExcludeTax;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public List<String> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<String> coupons) {
        this.coupons = coupons;
    }

    public List<String> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<String> discounts) {
        this.discounts = discounts;
    }

}
