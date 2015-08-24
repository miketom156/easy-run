/**
 * ContactInfoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class ContactInfoDTO  implements java.io.Serializable {
    private String email;

    private String status;

    private java.util.Calendar status_change_time;

    public ContactInfoDTO() {
    }

    public ContactInfoDTO(
           String email,
           String status,
           java.util.Calendar status_change_time) {
           this.email = email;
           this.status = status;
           this.status_change_time = status_change_time;
    }


    /**
     * Gets the email value for this ContactInfoDTO.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ContactInfoDTO.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the status value for this ContactInfoDTO.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ContactInfoDTO.
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Gets the status_change_time value for this ContactInfoDTO.
     * 
     * @return status_change_time
     */
    public java.util.Calendar getStatus_change_time() {
        return status_change_time;
    }


    /**
     * Sets the status_change_time value for this ContactInfoDTO.
     * 
     * @param status_change_time
     */
    public void setStatus_change_time(java.util.Calendar status_change_time) {
        this.status_change_time = status_change_time;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ContactInfoDTO)) return false;
        ContactInfoDTO other = (ContactInfoDTO) obj;
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
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.status_change_time==null && other.getStatus_change_time()==null) || 
             (this.status_change_time!=null &&
              this.status_change_time.equals(other.getStatus_change_time())));
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
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatus_change_time() != null) {
            _hashCode += getStatus_change_time().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContactInfoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactInfoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status_change_time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Status_change_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
