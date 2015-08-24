/**
 * EaseyeAttachmentReturnDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class EaseyeAttachmentReturnDTO  implements java.io.Serializable {
    private int attachmentId;

    private String attachmentName;

    private java.util.Calendar modifiedDate;

    public EaseyeAttachmentReturnDTO() {
    }

    public EaseyeAttachmentReturnDTO(
           int attachmentId,
           String attachmentName,
           java.util.Calendar modifiedDate) {
           this.attachmentId = attachmentId;
           this.attachmentName = attachmentName;
           this.modifiedDate = modifiedDate;
    }


    /**
     * Gets the attachmentId value for this EaseyeAttachmentReturnDTO.
     * 
     * @return attachmentId
     */
    public int getAttachmentId() {
        return attachmentId;
    }


    /**
     * Sets the attachmentId value for this EaseyeAttachmentReturnDTO.
     * 
     * @param attachmentId
     */
    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }


    /**
     * Gets the attachmentName value for this EaseyeAttachmentReturnDTO.
     * 
     * @return attachmentName
     */
    public String getAttachmentName() {
        return attachmentName;
    }


    /**
     * Sets the attachmentName value for this EaseyeAttachmentReturnDTO.
     * 
     * @param attachmentName
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }


    /**
     * Gets the modifiedDate value for this EaseyeAttachmentReturnDTO.
     * 
     * @return modifiedDate
     */
    public java.util.Calendar getModifiedDate() {
        return modifiedDate;
    }


    /**
     * Sets the modifiedDate value for this EaseyeAttachmentReturnDTO.
     * 
     * @param modifiedDate
     */
    public void setModifiedDate(java.util.Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EaseyeAttachmentReturnDTO)) return false;
        EaseyeAttachmentReturnDTO other = (EaseyeAttachmentReturnDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.attachmentId == other.getAttachmentId() &&
            ((this.attachmentName==null && other.getAttachmentName()==null) || 
             (this.attachmentName!=null &&
              this.attachmentName.equals(other.getAttachmentName()))) &&
            ((this.modifiedDate==null && other.getModifiedDate()==null) || 
             (this.modifiedDate!=null &&
              this.modifiedDate.equals(other.getModifiedDate())));
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
        _hashCode += getAttachmentId();
        if (getAttachmentName() != null) {
            _hashCode += getAttachmentName().hashCode();
        }
        if (getModifiedDate() != null) {
            _hashCode += getModifiedDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EaseyeAttachmentReturnDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeAttachmentReturnDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachmentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachmentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentName"));
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
