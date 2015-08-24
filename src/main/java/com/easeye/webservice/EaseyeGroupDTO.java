/**
 * EaseyeGroupDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class EaseyeGroupDTO  implements java.io.Serializable {
    private String groupName;

    private int importOption;

    private String repulsionGroupName;

    public EaseyeGroupDTO() {
    }

    public EaseyeGroupDTO(
           String groupName,
           int importOption,
           String repulsionGroupName) {
           this.groupName = groupName;
           this.importOption = importOption;
           this.repulsionGroupName = repulsionGroupName;
    }


    /**
     * Gets the groupName value for this EaseyeGroupDTO.
     * 
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this EaseyeGroupDTO.
     * 
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the importOption value for this EaseyeGroupDTO.
     * 
     * @return importOption
     */
    public int getImportOption() {
        return importOption;
    }


    /**
     * Sets the importOption value for this EaseyeGroupDTO.
     * 
     * @param importOption
     */
    public void setImportOption(int importOption) {
        this.importOption = importOption;
    }


    /**
     * Gets the repulsionGroupName value for this EaseyeGroupDTO.
     * 
     * @return repulsionGroupName
     */
    public String getRepulsionGroupName() {
        return repulsionGroupName;
    }


    /**
     * Sets the repulsionGroupName value for this EaseyeGroupDTO.
     * 
     * @param repulsionGroupName
     */
    public void setRepulsionGroupName(String repulsionGroupName) {
        this.repulsionGroupName = repulsionGroupName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EaseyeGroupDTO)) return false;
        EaseyeGroupDTO other = (EaseyeGroupDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.groupName==null && other.getGroupName()==null) || 
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            this.importOption == other.getImportOption() &&
            ((this.repulsionGroupName==null && other.getRepulsionGroupName()==null) || 
             (this.repulsionGroupName!=null &&
              this.repulsionGroupName.equals(other.getRepulsionGroupName())));
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
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        _hashCode += getImportOption();
        if (getRepulsionGroupName() != null) {
            _hashCode += getRepulsionGroupName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EaseyeGroupDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeGroupDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importOption");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ImportOption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repulsionGroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "RepulsionGroupName"));
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
