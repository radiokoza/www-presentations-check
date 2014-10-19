//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.19 at 08:32:17 PM CEST 
//


package org.w3._2005._10.markup_validator;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarkupValidationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MarkupValidationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="debug" type="{http://www.w3.org/2005/10/markup-validator}Debug" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="checkedby" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="doctype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="charset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="validity" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="errors" type="{http://www.w3.org/2005/10/markup-validator}ValidationErrors" minOccurs="0"/>
 *         &lt;element name="warnings" type="{http://www.w3.org/2005/10/markup-validator}ValidationWarnings" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.w3.org/2003/05/soap-envelope}encodingStyle"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarkupValidationResponse", propOrder = {
    "debug",
    "uri",
    "checkedby",
    "doctype",
    "charset",
    "validity",
    "errors",
    "warnings"
})
public class MarkupValidationResponse {

    protected List<Debug> debug;
    @XmlElement(required = true)
    protected String uri;
    @XmlElement(required = true)
    protected String checkedby;
    @XmlElement(required = true)
    protected String doctype;
    @XmlElement(required = true)
    protected String charset;
    protected boolean validity;
    protected ValidationErrors errors;
    protected ValidationWarnings warnings;
    @XmlAttribute(name = "encodingStyle", namespace = "http://www.w3.org/2003/05/soap-envelope")
    @XmlSchemaType(name = "anyURI")
    protected String encodingStyle;

    /**
     * Gets the value of the debug property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the debug property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDebug().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Debug }
     * 
     * 
     */
    public List<Debug> getDebug() {
        if (debug == null) {
            debug = new ArrayList<Debug>();
        }
        return this.debug;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the checkedby property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckedby() {
        return checkedby;
    }

    /**
     * Sets the value of the checkedby property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckedby(String value) {
        this.checkedby = value;
    }

    /**
     * Gets the value of the doctype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctype() {
        return doctype;
    }

    /**
     * Sets the value of the doctype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctype(String value) {
        this.doctype = value;
    }

    /**
     * Gets the value of the charset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Sets the value of the charset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharset(String value) {
        this.charset = value;
    }

    /**
     * Gets the value of the validity property.
     * 
     */
    public boolean isValidity() {
        return validity;
    }

    /**
     * Sets the value of the validity property.
     * 
     */
    public void setValidity(boolean value) {
        this.validity = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationErrors }
     *     
     */
    public ValidationErrors getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationErrors }
     *     
     */
    public void setErrors(ValidationErrors value) {
        this.errors = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationWarnings }
     *     
     */
    public ValidationWarnings getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationWarnings }
     *     
     */
    public void setWarnings(ValidationWarnings value) {
        this.warnings = value;
    }

    /**
     * Gets the value of the encodingStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncodingStyle() {
        return encodingStyle;
    }

    /**
     * Sets the value of the encodingStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncodingStyle(String value) {
        this.encodingStyle = value;
    }

}
