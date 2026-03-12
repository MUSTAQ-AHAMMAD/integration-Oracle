
package com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.oracle.xmlns.apps.financials.receivables.receipts.shared.standardreceiptservice.commonservice.ActivityUnapplication;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activityUnapplication" type="{http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/}ActivityUnapplication"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "activityUnapplication"
})
@XmlRootElement(name = "createActivityUnapplication")
public class CreateActivityUnapplication {

    @XmlElement(required = true)
    protected ActivityUnapplication activityUnapplication;

    /**
     * Gets the value of the activityUnapplication property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityUnapplication }
     *     
     */
    public ActivityUnapplication getActivityUnapplication() {
        return activityUnapplication;
    }

    /**
     * Sets the value of the activityUnapplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityUnapplication }
     *     
     */
    public void setActivityUnapplication(ActivityUnapplication value) {
        this.activityUnapplication = value;
    }

}
