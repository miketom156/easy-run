/**
 * CustomProject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class CustomProject  implements java.io.Serializable {
    private String mailProjectName;

    private String internalNote;

    public CustomProject() {
    }

    public CustomProject(
           String mailProjectName,
           String internalNote) {
           this.mailProjectName = mailProjectName;
           this.internalNote = internalNote;
    }


    /**
     * Gets the mailProjectName value for this CustomProject.
     * 
     * @return mailProjectName
     */
    public String getMailProjectName() {
        return mailProjectName;
    }


    /**
     * Sets the mailProjectName value for this CustomProject.
     * 
     * @param mailProjectName
     */
    public void setMailProjectName(String mailProjectName) {
        this.mailProjectName = mailProjectName;
    }


    /**
     * Gets the internalNote value for this CustomProject.
     * 
     * @return internalNote
     */
    public String getInternalNote() {
        return internalNote;
    }


    /**
     * Sets the internalNote value for this CustomProject.
     * 
     * @param internalNote
     */
    public void setInternalNote(String internalNote) {
        this.internalNote = internalNote;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof CustomProject)) return false;
        CustomProject other = (CustomProject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
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
        new org.apache.axis.description.TypeDesc(CustomProject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomProject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
