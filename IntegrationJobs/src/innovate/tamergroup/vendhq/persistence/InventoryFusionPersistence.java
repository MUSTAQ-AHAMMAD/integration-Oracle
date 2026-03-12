package innovate.tamergroup.vendhq.persistence;

import com.oracle.xmlns.apps.financials.receivables.receipts.shared.miscellaneousreceiptservice.commonservice.MiscellaneousReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ApplyReceipt;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.StandardReceipt;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.Invoice;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceLine;
import com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice.InvoiceResult;

import com.oracle.xmlns.apps.scm.inventory.InventoryTransactionResponse;

import com.oracle.xmlns.apps.scm.inventory.TransactionLine;

import innovate.tamergroup.ejb.utils.EJBClientUtil;
import innovate.tamergroup.persistence.entities.FusionApplyReceipt;
import innovate.tamergroup.persistence.entities.FusionInvTxn;
import innovate.tamergroup.persistence.entities.FusionInvoiceHeader;
import innovate.tamergroup.persistence.entities.FusionInvoiceLine;
import innovate.tamergroup.persistence.entities.FusionMiscReceipt;
import innovate.tamergroup.persistence.entities.FusionStandardReceipt;
import innovate.tamergroup.persistence.session.SessionEJB;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.Date;

import java.util.HashMap;

import javax.naming.NamingException;


public class InventoryFusionPersistence {

    private SessionEJB session;
    private Integer requestId;
    private String region;
    private String integrationMode;


    public InventoryFusionPersistence(SessionEJB session, Integer requestId, String region, String integrationMode) {
        this.session = session;
        this.requestId = requestId;
        this.region = region;
        this.integrationMode = integrationMode;
    }
    
    public void syncInvTxn(InventoryTransactionResponse invTransactions) {
        for (TransactionLine transactionLine : invTransactions.getTransactionLines())
            session.mergeEntity(transformInvTxn(transactionLine, invTransactions.getErrorCode() == null ? "Success" : "Failed", invTransactions.getErrorExplanation() + " "));
    }

    private FusionInvTxn transformInvTxn(TransactionLine transactionLine, String status, String message) {
        FusionInvTxn invTxnDb = new FusionInvTxn();
        invTxnDb.setRequestId(BigDecimal.valueOf(requestId));
        invTxnDb.setStatus(status);
        invTxnDb.setMessage(message.length() >= 500 ? message.substring(0, 500) : message);
        invTxnDb.setRequestDate(new Date(System.currentTimeMillis()));
        invTxnDb.setRegion(region);
        invTxnDb.setIntegrationMode(integrationMode);

        invTxnDb.setOrganizationName(transactionLine.getOrganizationName());
        invTxnDb.setItemNumber(transactionLine.getItem());
        invTxnDb.setSunbinventory(transactionLine.getSubinventory());
        invTxnDb.setTxnSourceName(transactionLine.getTransactionSourceName());
        invTxnDb.setTxnUom(transactionLine.getTransactionUnitOfMeasure());
        invTxnDb.setTxnQty(BigDecimal.valueOf(transactionLine.getTransactionQuantity()));
        invTxnDb.setTxnDate(transactionLine.getTransactionDate());
                   
        return invTxnDb;
    }
}
