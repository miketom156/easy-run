/**
 * UpdateProjectDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class UpdateProjectDTO  implements java.io.Serializable {
    private int mailProjectId;

    private String mailProjectName;

    private String internalNote;

    public UpdateProjectDTO() {
    }

    public UpdateProjectDTO(
           int mailProjectId,
           String mailProjectName,
           String internalNote) {
           this.mailProjectId = mailProjectId;
           this.mailProjectName = mailProjectName;
           this.internalNote = internalNote;
    }


    /**
     * Gets the mailProjectId value for this UpdateProjectDTO.
     * 
     * @return mailProjectId
     */
    public int getMailProjectId() {
        return mailProjectId;
    }


    /**
     * Sets the mailProjectId value for this UpdateProjectDTO.
     * 
     * @param mailProjectId
     */
    public void setMailProjectId(int mailProjectId) {
        this.mailProjectId = mailProjectId;
    }


    /**
     * Gets the mailProjectName value for this UpdateProjectDTO.
     * 
     * @return mailProjectName
     */
    public String getMailProjectName() {
        return mailProjectName;
    }


    /**
     * Sets the mailProjectName value for this UpdateProjectDTO.
     * 
     * @param mailProjectName
     */
    public void setMailProjectName(String mailProjectName) {
        this.mailProjectName = mailProjectName;
    }


    /**
     * Gets the internalNote value for this UpdateProjectDTO.
     * 
     * @return internalNote
     */
    public String getInternalNote() {
        return internalNote;
    }


    /**
     * Sets the internalNote value for this UpdateProjectDTO.
     * 
     * @param internalNote
     */
    public void setInternalNote(String internalNote) {
        this.internalNote = internalNote;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UpdateProjectDTO)) return false;
        UpdateProjectDTO other = (UpdateProjectDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.mailProjectId == other.getMailProjectId() &&
            ((this.mailProjectName==null && other.getMailProjectName()==null) || 
             (this.mailProjectName!=null &&
              this.mailProjectName.equals(other.getMailProjectName()))) &&
            ((this.internalNote==null && other.getInternalNote()==null) || 
             (this.internalNote!=null &&
              this.internalNote.equals(other.getInternalNote())));
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
        _hashCode += getMailProjectId();
        if (getMailProjectName() != null) {
            _hashCode += getMailProjectName().hashCode();
        }
        if (getInternalNote() != null) {
            _hashCode += getInternalNote().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateProjectDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateProjectDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailProjectId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailProjectId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailProjectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailProjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internalNote");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "InternalNote"));
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
