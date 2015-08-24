/**
 * EaseyeMessageSingleReceiverDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class EaseyeMessageSingleReceiverDTO  implements java.io.Serializable {
    private String receiverEmail;

    private String[] fieldsValue;

    public EaseyeMessageSingleReceiverDTO() {
    }

    public EaseyeMessageSingleReceiverDTO(
           String receiverEmail,
           String[] fieldsValue) {
           this.receiverEmail = receiverEmail;
           this.fieldsValue = fieldsValue;
    }


    /**
     * Gets the receiverEmail value for this EaseyeMessageSingleReceiverDTO.
     * 
     * @return receiverEmail
     */
    public String getReceiverEmail() {
        return receiverEmail;
    }


    /**
     * Sets the receiverEmail value for this EaseyeMessageSingleReceiverDTO.
     * 
     * @param receiverEmail
     */
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }


    /**
     * Gets the fieldsValue value for this EaseyeMessageSingleReceiverDTO.
     * 
     * @return fieldsValue
     */
    public String[] getFieldsValue() {
        return fieldsValue;
    }


    /**
     * Sets the fieldsValue value for this EaseyeMessageSingleReceiverDTO.
     * 
     * @param fieldsValue
     */
    public void setFieldsValue(String[] fieldsValue) {
        this.fieldsValue = fieldsValue;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EaseyeMessageSingleReceiverDTO)) return false;
        EaseyeMessageSingleReceiverDTO other = (EaseyeMessageSingleReceiverDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.receiverEmail==null && other.getReceiverEmail()==null) || 
             (this.receiverEmail!=null &&
              this.receiverEmail.equals(other.getReceiverEmail()))) &&
            ((this.fieldsValue==null && other.getFieldsValue()==null) || 
             (this.fieldsValue!=null &&
              java.util.Arrays.equals(this.fieldsValue, other.getFieldsValue())));
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
        if (getReceiverEmail() != null) {
            _hashCode += getReceiverEmail().hashCode();
        }
        if (getFieldsValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFieldsValue());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getFieldsValue(), i);
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
        new org.apache.axis.description.TypeDesc(EaseyeMessageSingleReceiverDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageSingleReceiverDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiverEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReceiverEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fieldsValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "FieldsValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "string"));
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
