package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InboundQuantityDetail implements Serializable {

    @SerializedName("InboundQuantity")
    @Expose
    private Double inboundQuantity;
    @SerializedName("SecondaryInboundQuantity")
    @Expose
    private Double secondaryInboundQuantity;
    @SerializedName("DocumentNumber")
    @Expose
    private String documentNumber;
    @SerializedName("LineNumber")
    @Expose
    private Long lineNumber;
    @SerializedName("Schedule")
    @Expose
    private String schedule;
    @SerializedName("DocumentType")
    @Expose
    private String documentType;
    private final static long serialVersionUID = -2560011261672114102L;

    /**
     * No args constructor for use in serialization
     *
     */
    public InboundQuantityDetail() {
    }

    /**
     *
     * @param schedule
     * @param documentType
     * @param lineNumber
     * @param documentNumber
     * @param secondaryInboundQuantity
     * @param inboundQuantity
     */
    public InboundQuantityDetail(Double inboundQuantity, Double secondaryInboundQuantity, String documentNumber,
                                 Long lineNumber, String schedule, String documentType) {
        this.inboundQuantity = inboundQuantity;
        this.secondaryInboundQuantity = secondaryInboundQuantity;
        this.documentNumber = documentNumber;
        this.lineNumber = lineNumber;
        this.schedule = schedule;
        this.documentType = documentType;
    }


    public void setInboundQuantity(Double inboundQuantity) {
        this.inboundQuantity = inboundQuantity;
    }

    public Double getInboundQuantity() {
        return inboundQuantity;
    }

    public void setSecondaryInboundQuantity(Double secondaryInboundQuantity) {
        this.secondaryInboundQuantity = secondaryInboundQuantity;
    }

    public Double getSecondaryInboundQuantity() {
        return secondaryInboundQuantity;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }
}
