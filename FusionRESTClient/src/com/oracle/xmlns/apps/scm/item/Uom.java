package com.oracle.xmlns.apps.scm.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uom {

    @SerializedName("UOMCode")
    @Expose
    private String uOMCode;
    @SerializedName("UOMClass")
    @Expose
    private String uOMClass;
    @SerializedName("UOM")
    @Expose
    private String uOM;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("UOMPluralDescription")
    @Expose
    private String uOMPluralDescription;
    @SerializedName("UOMReciprocalDescription")
    @Expose
    private String uOMReciprocalDescription;
    @SerializedName("DisableDate")
    @Expose
    private Object disableDate;
    @SerializedName("OkeiCode")
    @Expose
    private String okeiCode;
    @SerializedName("GlobalAttributeCategory")
    @Expose
    private String globalAttributeCategory;
    private final static long serialVersionUID = -2448539799712892521L;

    public String getUOMCode() {
        return uOMCode;
    }

    public void setUOMCode(String uOMCode) {
        this.uOMCode = uOMCode;
    }

    public String getUOMClass() {
        return uOMClass;
    }

    public void setUOMClass(String uOMClass) {
        this.uOMClass = uOMClass;
    }

    public String getUOM() {
        return uOM;
    }

    public void setUOM(String uOM) {
        this.uOM = uOM;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUOMPluralDescription() {
        return uOMPluralDescription;
    }

    public void setUOMPluralDescription(String uOMPluralDescription) {
        this.uOMPluralDescription = uOMPluralDescription;
    }

    public String getUOMReciprocalDescription() {
        return uOMReciprocalDescription;
    }

    public void setUOMReciprocalDescription(String uOMReciprocalDescription) {
        this.uOMReciprocalDescription = uOMReciprocalDescription;
    }

    public Object getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Object disableDate) {
        this.disableDate = disableDate;
    }

    public String getOkeiCode() {
        return okeiCode;
    }

    public void setOkeiCode(String okeiCode) {
        this.okeiCode = okeiCode;
    }

    public String getGlobalAttributeCategory() {
        return globalAttributeCategory;
    }

    public void setGlobalAttributeCategory(String globalAttributeCategory) {
        this.globalAttributeCategory = globalAttributeCategory;
    }

}
