/**
 * EaseyeMessageCustomReceiverDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class EaseyeMessageCustomReceiverDTO  implements java.io.Serializable {
    private String[] fieldsName;

    private com.easeye.webservice.EaseyeMessageSingleReceiverDTO[] customReceivers;

    public EaseyeMessageCustomReceiverDTO() {
    }

    public EaseyeMessageCustomReceiverDTO(
           String[] fieldsName,
          com.easeye.webservice.EaseyeMessageSingleReceiverDTO[] customReceivers) {
           this.fieldsName = fieldsName;
           this.customReceivers = customReceivers;
    }


    /**
     * Gets the fieldsName value for this EaseyeMessageCustomReceiverDTO.
     * 
     * @return fieldsName
     */
    public String[] getFieldsName() {
        return fieldsName;
    }


    /**
     * Sets the fieldsName value for this EaseyeMessageCustomReceiverDTO.
     * 
     * @param fieldsName
     */
    public void setFieldsName(String[] fieldsName) {
        this.fieldsName = fieldsName;
    }


    /**
     * Gets the customReceivers value for this EaseyeMessageCustomReceiverDTO.
     * 
     * @return customReceivers
     */
    public com.easeye.webservice.EaseyeMessageSingleReceiverDTO[] getCustomReceivers() {
        return customReceivers;
    }


    /**
     * Sets the customReceivers value for this EaseyeMessageCustomReceiverDTO.
     * 
     * @param customReceivers
     */
    public void setCustomReceivers(EaseyeMessageSingleReceiverDTO[] customReceivers) {
        this.customReceivers = customReceivers;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EaseyeMessageCustomReceiverDTO)) return false;
        EaseyeMessageCustomReceiverDTO other = (EaseyeMessageCustomReceiverDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fieldsName==null && other.getFieldsName()==null) || 
             (this.fieldsName!=null &&
              java.util.Arrays.equals(this.fieldsName, other.getFieldsName()))) &&
            ((this.customReceivers==null && other.getCustomReceivers()==null) || 
             (this.customReceivers!=null &&
              java.util.Arrays.equals(this.customReceivers, other.getCustomReceivers())));
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
        if (getFieldsName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFieldsName());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getFieldsName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomReceivers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomReceivers());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCustomReceivers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EaseyeMessageCustomReceiverDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageCustomReceiverDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "FieldsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customReceivers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomReceivers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageSingleReceiverDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageSingleReceiverDTO"));
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
