package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConsignedQuantityDetail implements Serializable {

    @SerializedName("ConsignedQuantity")
    @Expose
    private long consignedQuantity;
    @SerializedName("SecondaryConsignedQuantity")
    @Expose
    private double secondaryConsignedQuantity;
    @SerializedName("PartyName")
    @Expose
    private String partyName;
    @SerializedName("PartyType")
    @Expose
    private String partyType;
    @SerializedName("PartyNumber")
    @Expose
    private String partyNumber;
    private final static long serialVersionUID = 4036036789538123120L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ConsignedQuantityDetail() {
    }

    /**
     *
     * @param partyNumber
     * @param partyName
     * @param partyType
     * @param consignedQuantity
     * @param secondaryConsignedQuantity
     */
    public ConsignedQuantityDetail(long consignedQuantity, double secondaryConsignedQuantity, String partyName,
                                   String partyType, String partyNumber) {
        super();
        this.consignedQuantity = consignedQuantity;
        this.secondaryConsignedQuantity = secondaryConsignedQuantity;
        this.partyName = partyName;
        this.partyType = partyType;
        this.partyNumber = partyNumber;
    }

    public long getConsignedQuantity() {
        return consignedQuantity;
    }

    public void setConsignedQuantity(long consignedQuantity) {
        this.consignedQuantity = consignedQuantity;
    }

    public double getSecondaryConsignedQuantity() {
        return secondaryConsignedQuantity;
    }

    public void setSecondaryConsignedQuantity(double secondaryConsignedQuantity) {
        this.secondaryConsignedQuantity = secondaryConsignedQuantity;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getPartyNumber() {
        return partyNumber;
    }

    public void setPartyNumber(String partyNumber) {
        this.partyNumber = partyNumber;
    }

}
