//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.19 at 10:40:20 PM CEST 
//


package org.w3._2003._05.soap_envelope;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpgradeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UpgradeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SupportedEnvelope" type="{http://www.w3.org/2003/05/soap-envelope}SupportedEnvType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "UpgradeType", propOrder = {
    "supportedEnvelope"
})
public class UpgradeType {

    /**
     *
     */
    @XmlElement(name = "SupportedEnvelope", required = true)
    protected List<SupportedEnvType> supportedEnvelope;

    /**
     * Gets the value of the supportedEnvelope property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedEnvelope property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedEnvelope().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link org.w3._2003._05.soap_envelope.SupportedEnvType}
     *
     * @return a {@link java.util.List} object.
     */
    public List<SupportedEnvType> getSupportedEnvelope() {
        if (supportedEnvelope == null) {
            supportedEnvelope = new ArrayList<SupportedEnvType>();
        }
        return this.supportedEnvelope;
    }

}
