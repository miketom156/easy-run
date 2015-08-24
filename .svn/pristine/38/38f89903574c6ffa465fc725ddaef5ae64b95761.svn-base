/**
 * UpdateContactGroupDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class UpdateContactGroupDTO  implements java.io.Serializable {
    private int groupId;

    private String groupName;

    private String shortDescription;

    public UpdateContactGroupDTO() {
    }

    public UpdateContactGroupDTO(
           int groupId,
           String groupName,
           String shortDescription) {
           this.groupId = groupId;
           this.groupName = groupName;
           this.shortDescription = shortDescription;
    }


    /**
     * Gets the groupId value for this UpdateContactGroupDTO.
     * 
     * @return groupId
     */
    public int getGroupId() {
        return groupId;
    }


    /**
     * Sets the groupId value for this UpdateContactGroupDTO.
     * 
     * @param groupId
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


    /**
     * Gets the groupName value for this UpdateContactGroupDTO.
     * 
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this UpdateContactGroupDTO.
     * 
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the shortDescription value for this UpdateContactGroupDTO.
     * 
     * @return shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }


    /**
     * Sets the shortDescription value for this UpdateContactGroupDTO.
     * 
     * @param shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UpdateContactGroupDTO)) return false;
        UpdateContactGroupDTO other = (UpdateContactGroupDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.groupId == other.getGroupId() &&
            ((this.groupName==null && other.getGroupName()==null) || 
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            ((this.shortDescription==null && other.getShortDescription()==null) || 
             (this.shortDescription!=null &&
              this.shortDescription.equals(other.getShortDescription())));
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
        _hashCode += getGroupId();
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        if (getShortDescription() != null) {
            _hashCode += getShortDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateContactGroupDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UpdateContactGroupDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ShortDescription"));
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
