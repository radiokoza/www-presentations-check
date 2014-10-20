//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.19 at 10:40:20 PM CEST 
//


package org.w3._2005._07.css_validator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CSSValidationResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CSSValidationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="checkedby" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="csslevel" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="validity" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="result" type="{http://www.w3.org/2005/07/css-validator}Result"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.w3.org/2003/05/soap-envelope}encodingStyle"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author radio.koza
 * @version $Id: $Id
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSSValidationResponse", propOrder = {
    "uri",
    "checkedby",
    "csslevel",
    "date",
    "validity",
    "result"
})
public class CSSValidationResponse {

    @XmlElement(required = true)
    protected String uri;
    @XmlElement(required = true)
    protected String checkedby;
    @XmlElement(required = true)
    protected String csslevel;
    @XmlElement(required = true)
    protected String date;
    protected boolean validity;
    @XmlElement(required = true)
    protected Result result;
    @XmlAttribute(name = "encodingStyle", namespace = "http://www.w3.org/2003/05/soap-envelope")
    @XmlSchemaType(name = "anyURI")
    protected String encodingStyle;

    /**
     * Gets the value of the uri property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the checkedby property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCheckedby() {
        return checkedby;
    }

    /**
     * Sets the value of the checkedby property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setCheckedby(String value) {
        this.checkedby = value;
    }

    /**
     * Gets the value of the csslevel property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCsslevel() {
        return csslevel;
    }

    /**
     * Sets the value of the csslevel property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setCsslevel(String value) {
        this.csslevel = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the validity property.
     *
     * @return a boolean.
     */
    public boolean isValidity() {
        return validity;
    }

    /**
     * Sets the value of the validity property.
     *
     * @param value a boolean.
     */
    public void setValidity(boolean value) {
        this.validity = value;
    }

    /**
     * Gets the value of the result property.
     *
     * @return a {@link org.w3._2005._07.css_validator.Result} object.
     */
    public Result getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     *
     * @param value
     *     allowed object is
     *     {@link org.w3._2005._07.css_validator.Result}
     */
    public void setResult(Result value) {
        this.result = value;
    }

    /**
     * Gets the value of the encodingStyle property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEncodingStyle() {
        return encodingStyle;
    }

    /**
     * Sets the value of the encodingStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setEncodingStyle(String value) {
        this.encodingStyle = value;
    }

}
