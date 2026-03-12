package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InventoryTransactionRequest implements Serializable {

    @SerializedName("transactionLines")
    @Expose
    private List<TransactionLine> transactionLines = null;
    private final static long serialVersionUID = -7310855682891965217L;

    /**
     * No args constructor for use in serialization
     *
     */
    public InventoryTransactionRequest() {
    }

    /**
     *
     * @param transactionLines
     */
    public InventoryTransactionRequest(List<TransactionLine> transactionLines) {
        super();
        this.transactionLines = transactionLines;
    }

    public List<TransactionLine> getTransactionLines() {
        return transactionLines;
    }

    public void setTransactionLines(List<TransactionLine> transactionLines) {
        this.transactionLines = transactionLines;
    }

    public InventoryTransactionRequest withTransactionLines(List<TransactionLine> transactionLines) {
        this.transactionLines = transactionLines;
        return this;
    }

}
