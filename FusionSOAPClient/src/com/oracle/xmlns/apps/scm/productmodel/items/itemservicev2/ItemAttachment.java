
package com.oracle.xmlns.apps.scm.productmodel.items.itemservicev2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.oracle.xmlns.apps.flex.fnd.applcore.attachments.model.AttachedDocumentsDFF;


/**
 * <p>Java class for ItemAttachment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemAttachment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AttachedDocumentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DocumentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="LastUpdateDate" type="{http://xmlns.oracle.com/adf/svc/types/}dateTime-Timestamp" minOccurs="0"/>
 *         &lt;element name="DatatypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatabaseDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsageType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DmNode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DmFolderPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DmType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DmDocumentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DmVersionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatabaseTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EntityAttributes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DmRepository" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentAttributes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentEntityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CategoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DownloadStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CategoryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileContents" type="{http://xmlns.oracle.com/adf/svc/types/}base64Binary-DataHandler" minOccurs="0"/>
 *         &lt;element name="DocumentURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttachedDocumentsDFF" type="{http://xmlns.oracle.com/apps/flex/fnd/applcore/attachments/model/}AttachedDocumentsDFF" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemAttachment", propOrder = {
    "attachedDocumentId",
    "documentId",
    "lastUpdateDate",
    "datatypeCode",
    "databaseDescription",
    "fileName",
    "usageType",
    "dmNode",
    "dmFolderPath",
    "dmType",
    "dmDocumentId",
    "dmVersionNumber",
    "databaseTitle",
    "attachment",
    "entityAttributes",
    "dmRepository",
    "documentAttributes",
    "documentEntityId",
    "categoryName",
    "status",
    "downloadStatus",
    "categoryId",
    "userName",
    "uri",
    "title",
    "description",
    "fileContents",
    "documentURL",
    "url",
    "attachedDocumentsDFF"
})
public class ItemAttachment {

    @XmlElement(name = "AttachedDocumentId")
    protected Long attachedDocumentId;
    @XmlElement(name = "DocumentId")
    protected Long documentId;
    @XmlElement(name = "LastUpdateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlElement(name = "DatatypeCode")
    protected String datatypeCode;
    @XmlElementRef(name = "DatabaseDescription", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> databaseDescription;
    @XmlElementRef(name = "FileName", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fileName;
    @XmlElementRef(name = "UsageType", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> usageType;
    @XmlElementRef(name = "DmNode", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> dmNode;
    @XmlElementRef(name = "DmFolderPath", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dmFolderPath;
    @XmlElementRef(name = "DmType", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dmType;
    @XmlElementRef(name = "DmDocumentId", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dmDocumentId;
    @XmlElementRef(name = "DmVersionNumber", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dmVersionNumber;
    @XmlElementRef(name = "DatabaseTitle", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> databaseTitle;
    @XmlElementRef(name = "Attachment", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> attachment;
    @XmlElementRef(name = "EntityAttributes", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> entityAttributes;
    @XmlElementRef(name = "DmRepository", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dmRepository;
    @XmlElementRef(name = "DocumentAttributes", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentAttributes;
    @XmlElementRef(name = "DocumentEntityId", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> documentEntityId;
    @XmlElementRef(name = "CategoryName", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> categoryName;
    @XmlElementRef(name = "Status", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElement(name = "DownloadStatus")
    protected String downloadStatus;
    @XmlElement(name = "CategoryId")
    protected Long categoryId;
    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElementRef(name = "Uri", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uri;
    @XmlElementRef(name = "Title", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> title;
    @XmlElementRef(name = "Description", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    @XmlElementRef(name = "FileContents", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> fileContents;
    @XmlElementRef(name = "DocumentURL", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentURL;
    @XmlElementRef(name = "URL", namespace = "http://xmlns.oracle.com/apps/scm/productModel/items/itemServiceV2/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> url;
    @XmlElement(name = "AttachedDocumentsDFF")
    protected AttachedDocumentsDFF attachedDocumentsDFF;

    /**
     * Gets the value of the attachedDocumentId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttachedDocumentId() {
        return attachedDocumentId;
    }

    /**
     * Sets the value of the attachedDocumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttachedDocumentId(Long value) {
        this.attachedDocumentId = value;
    }

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocumentId(Long value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the datatypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatatypeCode() {
        return datatypeCode;
    }

    /**
     * Sets the value of the datatypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatatypeCode(String value) {
        this.datatypeCode = value;
    }

    /**
     * Gets the value of the databaseDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDatabaseDescription() {
        return databaseDescription;
    }

    /**
     * Sets the value of the databaseDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDatabaseDescription(JAXBElement<String> value) {
        this.databaseDescription = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileName(JAXBElement<String> value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the usageType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsageType() {
        return usageType;
    }

    /**
     * Sets the value of the usageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsageType(JAXBElement<String> value) {
        this.usageType = value;
    }

    /**
     * Gets the value of the dmNode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getDmNode() {
        return dmNode;
    }

    /**
     * Sets the value of the dmNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setDmNode(JAXBElement<Long> value) {
        this.dmNode = value;
    }

    /**
     * Gets the value of the dmFolderPath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDmFolderPath() {
        return dmFolderPath;
    }

    /**
     * Sets the value of the dmFolderPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDmFolderPath(JAXBElement<String> value) {
        this.dmFolderPath = value;
    }

    /**
     * Gets the value of the dmType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDmType() {
        return dmType;
    }

    /**
     * Sets the value of the dmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDmType(JAXBElement<String> value) {
        this.dmType = value;
    }

    /**
     * Gets the value of the dmDocumentId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDmDocumentId() {
        return dmDocumentId;
    }

    /**
     * Sets the value of the dmDocumentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDmDocumentId(JAXBElement<String> value) {
        this.dmDocumentId = value;
    }

    /**
     * Gets the value of the dmVersionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDmVersionNumber() {
        return dmVersionNumber;
    }

    /**
     * Sets the value of the dmVersionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDmVersionNumber(JAXBElement<String> value) {
        this.dmVersionNumber = value;
    }

    /**
     * Gets the value of the databaseTitle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDatabaseTitle() {
        return databaseTitle;
    }

    /**
     * Sets the value of the databaseTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDatabaseTitle(JAXBElement<String> value) {
        this.databaseTitle = value;
    }

    /**
     * Gets the value of the attachment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAttachment() {
        return attachment;
    }

    /**
     * Sets the value of the attachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAttachment(JAXBElement<String> value) {
        this.attachment = value;
    }

    /**
     * Gets the value of the entityAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEntityAttributes() {
        return entityAttributes;
    }

    /**
     * Sets the value of the entityAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEntityAttributes(JAXBElement<String> value) {
        this.entityAttributes = value;
    }

    /**
     * Gets the value of the dmRepository property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDmRepository() {
        return dmRepository;
    }

    /**
     * Sets the value of the dmRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDmRepository(JAXBElement<String> value) {
        this.dmRepository = value;
    }

    /**
     * Gets the value of the documentAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentAttributes() {
        return documentAttributes;
    }

    /**
     * Sets the value of the documentAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentAttributes(JAXBElement<String> value) {
        this.documentAttributes = value;
    }

    /**
     * Gets the value of the documentEntityId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getDocumentEntityId() {
        return documentEntityId;
    }

    /**
     * Sets the value of the documentEntityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setDocumentEntityId(JAXBElement<Long> value) {
        this.documentEntityId = value;
    }

    /**
     * Gets the value of the categoryName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCategoryName(JAXBElement<String> value) {
        this.categoryName = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Gets the value of the downloadStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadStatus() {
        return downloadStatus;
    }

    /**
     * Sets the value of the downloadStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadStatus(String value) {
        this.downloadStatus = value;
    }

    /**
     * Gets the value of the categoryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCategoryId(Long value) {
        this.categoryId = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUri(JAXBElement<String> value) {
        this.uri = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTitle(JAXBElement<String> value) {
        this.title = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = value;
    }

    /**
     * Gets the value of the fileContents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getFileContents() {
        return fileContents;
    }

    /**
     * Sets the value of the fileContents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setFileContents(JAXBElement<byte[]> value) {
        this.fileContents = value;
    }

    /**
     * Gets the value of the documentURL property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentURL() {
        return documentURL;
    }

    /**
     * Sets the value of the documentURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentURL(JAXBElement<String> value) {
        this.documentURL = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setURL(JAXBElement<String> value) {
        this.url = value;
    }

    /**
     * Gets the value of the attachedDocumentsDFF property.
     * 
     * @return
     *     possible object is
     *     {@link AttachedDocumentsDFF }
     *     
     */
    public AttachedDocumentsDFF getAttachedDocumentsDFF() {
        return attachedDocumentsDFF;
    }

    /**
     * Sets the value of the attachedDocumentsDFF property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachedDocumentsDFF }
     *     
     */
    public void setAttachedDocumentsDFF(AttachedDocumentsDFF value) {
        this.attachedDocumentsDFF = value;
    }

}
