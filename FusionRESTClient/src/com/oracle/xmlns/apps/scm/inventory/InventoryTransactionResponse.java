
package com.oracle.xmlns.apps.scm.inventory;

import java.io.Serializable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InventoryTransactionResponse implements Serializable {

    @SerializedName("ReturnStatus")
    @Expose
    private String returnStatus;
    @SerializedName("ErrorCode")
    @Expose
    private String errorCode;
    @SerializedName("ErrorExplanation")
    @Expose
    private String errorExplanation;
    @SerializedName("ErrorUniqueTransactionId")
    @Expose
    private String errorUniqueTransactionId;
    @SerializedName("transactionLines")
    @Expose
    private List<TransactionLine> transactionLines = null;
    private final static long serialVersionUID = 6109817571700556977L;

    /**
     * No args constructor for use in serialization
     *
     */
    public InventoryTransactionResponse() {
    }

    /**
     *
     * @param errorExplanation
     * @param errorCode
     * @param returnStatus
     * @param errorUniqueTransactionId
     * @param transactionLines
     */
    public InventoryTransactionResponse(String returnStatus, String errorCode, String errorExplanation,
                                        String errorUniqueTransactionId, List<TransactionLine> transactionLines) {
        super();
        this.returnStatus = returnStatus;
        this.errorCode = errorCode;
        this.errorExplanation = errorExplanation;
        this.errorUniqueTransactionId = errorUniqueTransactionId;
        this.transactionLines = transactionLines;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorExplanation() {
        return errorExplanation;
    }

    public void setErrorExplanation(String errorExplanation) {
        this.errorExplanation = errorExplanation;
    }

    public String getErrorUniqueTransactionId() {
        return errorUniqueTransactionId;
    }

    public void setErrorUniqueTransactionId(String errorUniqueTransactionId) {
        this.errorUniqueTransactionId = errorUniqueTransactionId;
    }

    public List<TransactionLine> getTransactionLines() {
        return transactionLines;
    }

    public void setTransactionLines(List<TransactionLine> transactionLines) {
        this.transactionLines = transactionLines;
    }

}
