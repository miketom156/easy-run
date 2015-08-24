/**
 * Hist_TransMailBounce.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class Hist_TransMailBounce  implements java.io.Serializable {
    private int id;

    private String email;

    private java.util.Calendar modifiedDate;

    private String sentAddress;

    private int status;

    public Hist_TransMailBounce() {
    }

    public Hist_TransMailBounce(
           int id,
           String email,
           java.util.Calendar modifiedDate,
           String sentAddress,
           int status) {
           this.id = id;
           this.email = email;
           this.modifiedDate = modifiedDate;
           this.sentAddress = sentAddress;
           this.status = status;
    }


    /**
     * Gets the id value for this Hist_TransMailBounce.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Hist_TransMailBounce.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the email value for this Hist_TransMailBounce.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Hist_TransMailBounce.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the modifiedDate value for this Hist_TransMailBounce.
     * 
     * @return modifiedDate
     */
    public java.util.Calendar getModifiedDate() {
        return modifiedDate;
    }


    /**
     * Sets the modifiedDate value for this Hist_TransMailBounce.
     * 
     * @param modifiedDate
     */
    public void setModifiedDate(java.util.Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    /**
     * Gets the sentAddress value for this Hist_TransMailBounce.
     * 
     * @return sentAddress
     */
    public String getSentAddress() {
        return sentAddress;
    }


    /**
     * Sets the sentAddress value for this Hist_TransMailBounce.
     * 
     * @param sentAddress
     */
    public void setSentAddress(String sentAddress) {
        this.sentAddress = sentAddress;
    }


    /**
     * Gets the status value for this Hist_TransMailBounce.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Hist_TransMailBounce.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Hist_TransMailBounce)) return false;
        Hist_TransMailBounce other = (Hist_TransMailBounce) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.modifiedDate==null && other.getModifiedDate()==null) || 
             (this.modifiedDate!=null &&
              this.modifiedDate.equals(other.getModifiedDate()))) &&
            ((this.sentAddress==null && other.getSentAddress()==null) || 
             (this.sentAddress!=null &&
              this.sentAddress.equals(other.getSentAddress()))) &&
            this.status == other.getStatus();
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
        _hashCode += getId();
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getModifiedDate() != null) {
            _hashCode += getModifiedDate().hashCode();
        }
        if (getSentAddress() != null) {
            _hashCode += getSentAddress().hashCode();
        }
        _hashCode += getStatus();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hist_TransMailBounce.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Hist_TransMailBounce"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifiedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ModifiedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Status"));
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
