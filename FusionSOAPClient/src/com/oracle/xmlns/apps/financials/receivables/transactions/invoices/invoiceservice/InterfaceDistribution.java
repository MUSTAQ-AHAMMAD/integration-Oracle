
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactiondistributiondff.TransactionDistributionFLEX;
import com.oracle.xmlns.apps.flex.financials.receivables.transactions.autoinvoices.transactiondistributioninterfacelinedff.TransactionInterfaceLineFLEX;


/**
 * <p>Java class for InterfaceDistribution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterfaceDistribution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AcctdAmount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="CodeCombinationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="InterimTaxCcid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="OrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Percent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DistributionInterfacLineDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionInterfaceLineDff/}TransactionInterfaceLineFLEX" minOccurs="0"/>
 *         &lt;element name="TransactionDistributionDff" type="{http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/}TransactionDistributionFLEX" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterfaceDistribution", propOrder = {
    "accountClass",
    "acctdAmount",
    "amount",
    "codeCombinationId",
    "interimTaxCcid",
    "orgId",
    "percent",
    "distributionInterfacLineDff",
    "transactionDistributionDff"
})
public class InterfaceDistribution {

    @XmlElement(name = "AccountClass")
    protected String accountClass;
    @XmlElementRef(name = "AcctdAmount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> acctdAmount;
    @XmlElementRef(name = "Amount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> amount;
    @XmlElementRef(name = "CodeCombinationId", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> codeCombinationId;
    @XmlElementRef(name = "InterimTaxCcid", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> interimTaxCcid;
    @XmlElement(name = "OrgId")
    protected Long orgId;
    @XmlElementRef(name = "Percent", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> percent;
    @XmlElement(name = "DistributionInterfacLineDff")
    protected TransactionInterfaceLineFLEX distributionInterfacLineDff;
    @XmlElement(name = "TransactionDistributionDff")
    protected TransactionDistributionFLEX transactionDistributionDff;

    /**
     * Gets the value of the accountClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountClass() {
        return accountClass;
    }

    /**
     * Sets the value of the accountClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountClass(String value) {
        this.accountClass = value;
    }

    /**
     * Gets the value of the acctdAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getAcctdAmount() {
        return acctdAmount;
    }

    /**
     * Sets the value of the acctdAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setAcctdAmount(JAXBElement<AmountType> value) {
        this.acctdAmount = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public JAXBElement<AmountType> getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     
     */
    public void setAmount(JAXBElement<AmountType> value) {
        this.amount = value;
    }

    /**
     * Gets the value of the codeCombinationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCodeCombinationId() {
        return codeCombinationId;
    }

    /**
     * Sets the value of the codeCombinationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCodeCombinationId(JAXBElement<Long> value) {
        this.codeCombinationId = value;
    }

    /**
     * Gets the value of the interimTaxCcid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getInterimTaxCcid() {
        return interimTaxCcid;
    }

    /**
     * Sets the value of the interimTaxCcid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setInterimTaxCcid(JAXBElement<Long> value) {
        this.interimTaxCcid = value;
    }

    /**
     * Gets the value of the orgId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgId(Long value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the percent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPercent() {
        return percent;
    }

    /**
     * Sets the value of the percent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPercent(JAXBElement<BigDecimal> value) {
        this.percent = value;
    }

    /**
     * Gets the value of the distributionInterfacLineDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public TransactionInterfaceLineFLEX getDistributionInterfacLineDff() {
        return distributionInterfacLineDff;
    }

    /**
     * Sets the value of the distributionInterfacLineDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterfaceLineFLEX }
     *     
     */
    public void setDistributionInterfacLineDff(TransactionInterfaceLineFLEX value) {
        this.distributionInterfacLineDff = value;
    }

    /**
     * Gets the value of the transactionDistributionDff property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionDistributionFLEX }
     *     
     */
    public TransactionDistributionFLEX getTransactionDistributionDff() {
        return transactionDistributionDff;
    }

    /**
     * Sets the value of the transactionDistributionDff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionDistributionFLEX }
     *     
     */
    public void setTransactionDistributionDff(TransactionDistributionFLEX value) {
        this.transactionDistributionDff = value;
    }

}
