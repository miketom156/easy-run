/**
 * MailSenderStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailSenderStatus  implements java.io.Serializable {
    private String senderEmail;

    private int ifOwnedByPlatform;

    private int ifActive;

    public MailSenderStatus() {
    }

    public MailSenderStatus(
           String senderEmail,
           int ifOwnedByPlatform,
           int ifActive) {
           this.senderEmail = senderEmail;
           this.ifOwnedByPlatform = ifOwnedByPlatform;
           this.ifActive = ifActive;
    }


    /**
     * Gets the senderEmail value for this MailSenderStatus.
     * 
     * @return senderEmail
     */
    public String getSenderEmail() {
        return senderEmail;
    }


    /**
     * Sets the senderEmail value for this MailSenderStatus.
     * 
     * @param senderEmail
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }


    /**
     * Gets the ifOwnedByPlatform value for this MailSenderStatus.
     * 
     * @return ifOwnedByPlatform
     */
    public int getIfOwnedByPlatform() {
        return ifOwnedByPlatform;
    }


    /**
     * Sets the ifOwnedByPlatform value for this MailSenderStatus.
     * 
     * @param ifOwnedByPlatform
     */
    public void setIfOwnedByPlatform(int ifOwnedByPlatform) {
        this.ifOwnedByPlatform = ifOwnedByPlatform;
    }


    /**
     * Gets the ifActive value for this MailSenderStatus.
     * 
     * @return ifActive
     */
    public int getIfActive() {
        return ifActive;
    }


    /**
     * Sets the ifActive value for this MailSenderStatus.
     * 
     * @param ifActive
     */
    public void setIfActive(int ifActive) {
        this.ifActive = ifActive;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MailSenderStatus)) return false;
        MailSenderStatus other = (MailSenderStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.senderEmail==null && other.getSenderEmail()==null) || 
             (this.senderEmail!=null &&
              this.senderEmail.equals(other.getSenderEmail()))) &&
            this.ifOwnedByPlatform == other.getIfOwnedByPlatform() &&
            this.ifActive == other.getIfActive();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSenderEmail() != null) {
            _hashCode += getSenderEmail().hashCode();
        }
        _hashCode += getIfOwnedByPlatform();
        _hashCode += getIfActive();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailSenderStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailSenderStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SenderEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ifOwnedByPlatform");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "IfOwnedByPlatform"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ifActive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "IfActive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
