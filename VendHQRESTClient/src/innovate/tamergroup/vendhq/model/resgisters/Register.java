package innovate.tamergroup.vendhq.model.resgisters;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import innovate.tamergroup.vendhq.model.shared.Attribute;

public class Register {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("outlet_id")
    @Expose
    private String outletId;
    @SerializedName("ask_for_note_on_save")
    @Expose
    private Integer askForNoteOnSave;
    @SerializedName("print_note_on_receipt")
    @Expose
    private Boolean printNoteOnReceipt;
    @SerializedName("ask_for_user_on_sale")
    @Expose
    private Boolean askForUserOnSale;
    @SerializedName("show_discounts_on_receipts")
    @Expose
    private Boolean showDiscountsOnReceipts;
    @SerializedName("print_receipt")
    @Expose
    private Boolean printReceipt;
    @SerializedName("email_receipt")
    @Expose
    private Boolean emailReceipt;
    @SerializedName("invoice_prefix")
    @Expose
    private String invoicePrefix;
    @SerializedName("invoice_suffix")
    @Expose
    private String invoiceSuffix;
    @SerializedName("invoice_sequence")
    @Expose
    private Integer invoiceSequence;
    @SerializedName("button_layout_id")
    @Expose
    private Object buttonLayoutId;
    @SerializedName("register_open_time")
    @Expose
    private String registerOpenTime;
    @SerializedName("register_close_time")
    @Expose
    private Object registerCloseTime;
    @SerializedName("register_open_sequence_id")
    @Expose
    private String registerOpenSequenceId;
    @SerializedName("deleted_at")
    @Expose
    private Date deletedAt;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("is_open")
    @Expose
    private Boolean isOpen;
    @SerializedName("is_quick_keys_enabled")
    @Expose
    private Boolean isQuickKeysEnabled;
    @SerializedName("cash_managed_payment_type_id")
    @Expose
    private String cashManagedPaymentTypeId;

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

    public String getOutletId() {
    return outletId;
    }

    public void setOutletId(String outletId) {
    this.outletId = outletId;
    }

    public Integer getAskForNoteOnSave() {
    return askForNoteOnSave;
    }

    public void setAskForNoteOnSave(Integer askForNoteOnSave) {
    this.askForNoteOnSave = askForNoteOnSave;
    }

    public Boolean getPrintNoteOnReceipt() {
    return printNoteOnReceipt;
    }

    public void setPrintNoteOnReceipt(Boolean printNoteOnReceipt) {
    this.printNoteOnReceipt = printNoteOnReceipt;
    }

    public Boolean getAskForUserOnSale() {
    return askForUserOnSale;
    }

    public void setAskForUserOnSale(Boolean askForUserOnSale) {
    this.askForUserOnSale = askForUserOnSale;
    }

    public Boolean getShowDiscountsOnReceipts() {
    return showDiscountsOnReceipts;
    }

    public void setShowDiscountsOnReceipts(Boolean showDiscountsOnReceipts) {
    this.showDiscountsOnReceipts = showDiscountsOnReceipts;
    }

    public Boolean getPrintReceipt() {
    return printReceipt;
    }

    public void setPrintReceipt(Boolean printReceipt) {
    this.printReceipt = printReceipt;
    }

    public Boolean getEmailReceipt() {
    return emailReceipt;
    }

    public void setEmailReceipt(Boolean emailReceipt) {
    this.emailReceipt = emailReceipt;
    }

    public String getInvoicePrefix() {
    return invoicePrefix;
    }

    public void setInvoicePrefix(String invoicePrefix) {
    this.invoicePrefix = invoicePrefix;
    }

    public String getInvoiceSuffix() {
    return invoiceSuffix;
    }

    public void setInvoiceSuffix(String invoiceSuffix) {
    this.invoiceSuffix = invoiceSuffix;
    }

    public Integer getInvoiceSequence() {
    return invoiceSequence;
    }

    public void setInvoiceSequence(Integer invoiceSequence) {
    this.invoiceSequence = invoiceSequence;
    }

    public Object getButtonLayoutId() {
    return buttonLayoutId;
    }

    public void setButtonLayoutId(Object buttonLayoutId) {
    this.buttonLayoutId = buttonLayoutId;
    }

    public String getRegisterOpenTime() {
    return registerOpenTime;
    }

    public void setRegisterOpenTime(String registerOpenTime) {
    this.registerOpenTime = registerOpenTime;
    }

    public Object getRegisterCloseTime() {
    return registerCloseTime;
    }

    public void setRegisterCloseTime(Object registerCloseTime) {
    this.registerCloseTime = registerCloseTime;
    }

    public String getRegisterOpenSequenceId() {
    return registerOpenSequenceId;
    }

    public void setRegisterOpenSequenceId(String registerOpenSequenceId) {
    this.registerOpenSequenceId = registerOpenSequenceId;
    }

    public Date getDeletedAt() {
    return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
    }

    public List<Attribute> getAttributes() {
    return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
    this.attributes = attributes;
    }

    public Long getVersion() {
    return version;
    }

    public void setVersion(Long version) {
    this.version = version;
    }

    public Boolean getIsOpen() {
    return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
    this.isOpen = isOpen;
    }

    public Boolean getIsQuickKeysEnabled() {
    return isQuickKeysEnabled;
    }

    public void setIsQuickKeysEnabled(Boolean isQuickKeysEnabled) {
    this.isQuickKeysEnabled = isQuickKeysEnabled;
    }

    public String getCashManagedPaymentTypeId() {
    return cashManagedPaymentTypeId;
    }

    public void setCashManagedPaymentTypeId(String cashManagedPaymentTypeId) {
    this.cashManagedPaymentTypeId = cashManagedPaymentTypeId;
    }


}
