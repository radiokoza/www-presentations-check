//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.19 at 10:40:13 PM CEST 
//


package org.w3._2005._10.markup_validator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidationWarnings complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ValidationWarnings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="warningcount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="warninglist" type="{http://www.w3.org/2005/10/markup-validator}WarningList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author radio.koza
 * @version $Id: $Id
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidationWarnings", propOrder = {
    "warningcount",
    "warninglist"
})
public class ValidationWarnings {

    /**
     *
     */
    protected int warningcount;

    /**
     *
     */
    @XmlElement(required = true)
    protected WarningList warninglist;

    /**
     * Gets the value of the warningcount property.
     *
     * @return a int.
     */
    public int getWarningcount() {
        return warningcount;
    }

    /**
     * Sets the value of the warningcount property.
     *
     * @param value a int.
     */
    public void setWarningcount(int value) {
        this.warningcount = value;
    }

    /**
     * Gets the value of the warninglist property.
     *
     * @return a {@link org.w3._2005._10.markup_validator.WarningList} object.
     */
    public WarningList getWarninglist() {
        return warninglist;
    }

    /**
     * Sets the value of the warninglist property.
     *
     * @param value
     *     allowed object is
     *     {@link org.w3._2005._10.markup_validator.WarningList}
     */
    public void setWarninglist(WarningList value) {
        this.warninglist = value;
    }

}
