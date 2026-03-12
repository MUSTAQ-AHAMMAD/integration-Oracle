
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.model.flex.standardreceiptgdf;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JLxARReceiptInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JLxARReceiptInformation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/}StandardReceiptGdf">
 *       &lt;sequence>
 *         &lt;element name="packageNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="withholdingCertificateNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="withholdingCertificateDate" type="{http://xmlns.oracle.com/adf/svc/types/}date-Date" minOccurs="0"/>
 *         &lt;element name="taxRegimeReportingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JLxARReceiptInformation", propOrder = {
    "packageNumber",
    "withholdingCertificateNumber",
    "withholdingCertificateDate",
    "taxRegimeReportingCode"
})
public class JLxARReceiptInformation
    extends StandardReceiptGdf
{

    @XmlElementRef(name = "packageNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> packageNumber;
    @XmlElementRef(name = "withholdingCertificateNumber", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> withholdingCertificateNumber;
    @XmlElementRef(name = "withholdingCertificateDate", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> withholdingCertificateDate;
    @XmlElementRef(name = "taxRegimeReportingCode", namespace = "http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> taxRegimeReportingCode;

    /**
     * Gets the value of the packageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPackageNumber() {
        return packageNumber;
    }

    /**
     * Sets the value of the packageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPackageNumber(JAXBElement<String> value) {
        this.packageNumber = value;
    }

    /**
     * Gets the value of the withholdingCertificateNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getWithholdingCertificateNumber() {
        return withholdingCertificateNumber;
    }

    /**
     * Sets the value of the withholdingCertificateNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setWithholdingCertificateNumber(JAXBElement<BigDecimal> value) {
        this.withholdingCertificateNumber = value;
    }

    /**
     * Gets the value of the withholdingCertificateDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getWithholdingCertificateDate() {
        return withholdingCertificateDate;
    }

    /**
     * Sets the value of the withholdingCertificateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setWithholdingCertificateDate(JAXBElement<XMLGregorianCalendar> value) {
        this.withholdingCertificateDate = value;
    }

    /**
     * Gets the value of the taxRegimeReportingCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTaxRegimeReportingCode() {
        return taxRegimeReportingCode;
    }

    /**
     * Sets the value of the taxRegimeReportingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTaxRegimeReportingCode(JAXBElement<String> value) {
        this.taxRegimeReportingCode = value;
    }

}
