
package com.oracle.xmlns.apps.financials.receivables.transactions.invoices.invoiceservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.adf.svc.types.AmountType;
import com.oracle.xmlns.apps.financials.receivables.transactions.shared.model.flex.transactiondistributiondff.TransactionDistributionFLEX;


/**
 * <p>Java class for InvoiceDistribution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceDistribution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistLineNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AccountClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodeCombinationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Amount" type="{http://xmlns.oracle.com/adf/svc/types/}AmountType" minOccurs="0"/>
 *         &lt;element name="Percent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ConcatSegment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionDistributionFLEX" type="{http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionDistributionDff/}TransactionDistributionFLEX" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceDistribution", propOrder = {
    "distLineNumber",
    "accountClass",
    "codeCombinationId",
    "amount",
    "percent",
    "concatSegment",
    "transactionDistributionFLEX"
})
public class InvoiceDistribution {

    @XmlElementRef(name = "DistLineNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> distLineNumber;
    @XmlElement(name = "AccountClass")
    protected String accountClass;
    @XmlElement(name = "CodeCombinationId")
    protected Long codeCombinationId;
    @XmlElementRef(name = "Amount", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<AmountType> amount;
    @XmlElementRef(name = "Percent", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> percent;
    @XmlElementRef(name = "ConcatSegment", namespace = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> concatSegment;
    @XmlElement(name = "TransactionDistributionFLEX")
    protected TransactionDistributionFLEX transactionDistributionFLEX;

    /**
     * Gets the value of the distLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDistLineNumber() {
        return distLineNumber;
    }

    /**
     * Sets the value of the distLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDistLineNumber(JAXBElement<Integer> value) {
        this.distLineNumber = value;
    }

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
     * Gets the value of the codeCombinationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodeCombinationId() {
        return codeCombinationId;
    }

    /**
     * Sets the value of the codeCombinationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodeCombinationId(Long value) {
        this.codeCombinationId = value;
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
     * Gets the value of the concatSegment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConcatSegment() {
        return concatSegment;
    }

    /**
     * Sets the value of the concatSegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConcatSegment(JAXBElement<String> value) {
        this.concatSegment = value;
    }

    /**
     * Gets the value of the transactionDistributionFLEX property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionDistributionFLEX }
     *     
     */
    public TransactionDistributionFLEX getTransactionDistributionFLEX() {
        return transactionDistributionFLEX;
    }

    /**
     * Sets the value of the transactionDistributionFLEX property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionDistributionFLEX }
     *     
     */
    public void setTransactionDistributionFLEX(TransactionDistributionFLEX value) {
        this.transactionDistributionFLEX = value;
    }

}
