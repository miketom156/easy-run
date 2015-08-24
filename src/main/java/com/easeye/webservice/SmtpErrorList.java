/**
 * SmtpErrorList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class SmtpErrorList  implements java.io.Serializable {
    private String email;

    private int smtpSentResult;

    private java.util.Calendar sentDateTime;

    private String uniqueMsgID;

    public SmtpErrorList() {
    }

    public SmtpErrorList(
           String email,
           int smtpSentResult,
           java.util.Calendar sentDateTime,
           String uniqueMsgID) {
           this.email = email;
           this.smtpSentResult = smtpSentResult;
           this.sentDateTime = sentDateTime;
           this.uniqueMsgID = uniqueMsgID;
    }


    /**
     * Gets the email value for this SmtpErrorList.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this SmtpErrorList.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the smtpSentResult value for this SmtpErrorList.
     * 
     * @return smtpSentResult
     */
    public int getSmtpSentResult() {
        return smtpSentResult;
    }


    /**
     * Sets the smtpSentResult value for this SmtpErrorList.
     * 
     * @param smtpSentResult
     */
    public void setSmtpSentResult(int smtpSentResult) {
        this.smtpSentResult = smtpSentResult;
    }


    /**
     * Gets the sentDateTime value for this SmtpErrorList.
     * 
     * @return sentDateTime
     */
    public java.util.Calendar getSentDateTime() {
        return sentDateTime;
    }


    /**
     * Sets the sentDateTime value for this SmtpErrorList.
     * 
     * @param sentDateTime
     */
    public void setSentDateTime(java.util.Calendar sentDateTime) {
        this.sentDateTime = sentDateTime;
    }


    /**
     * Gets the uniqueMsgID value for this SmtpErrorList.
     * 
     * @return uniqueMsgID
     */
    public String getUniqueMsgID() {
        return uniqueMsgID;
    }


    /**
     * Sets the uniqueMsgID value for this SmtpErrorList.
     * 
     * @param uniqueMsgID
     */
    public void setUniqueMsgID(String uniqueMsgID) {
        this.uniqueMsgID = uniqueMsgID;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SmtpErrorList)) return false;
        SmtpErrorList other = (SmtpErrorList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.smtpSentResult == other.getSmtpSentResult() &&
            ((this.sentDateTime==null && other.getSentDateTime()==null) || 
             (this.sentDateTime!=null &&
              this.sentDateTime.equals(other.getSentDateTime()))) &&
            ((this.uniqueMsgID==null && other.getUniqueMsgID()==null) || 
             (this.uniqueMsgID!=null &&
              this.uniqueMsgID.equals(other.getUniqueMsgID())));
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += getSmtpSentResult();
        if (getSentDateTime() != null) {
            _hashCode += getSentDateTime().hashCode();
        }
        if (getUniqueMsgID() != null) {
            _hashCode += getUniqueMsgID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SmtpErrorList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpErrorList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smtpSentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SmtpSentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uniqueMsgID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UniqueMsgID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
