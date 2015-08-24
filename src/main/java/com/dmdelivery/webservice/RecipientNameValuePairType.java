/**
 * RecipientNameValuePairType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype represents a name/value pair, a combination of a
 * DMdelivery field name and field value. When adding a recipient, fields
 * not known to DMdelivery will be ignored and empty required fields
 * will fail the request.
 */
public class RecipientNameValuePairType  implements java.io.Serializable {
    /* The DMdelivery database field name */
    private java.lang.String name;

    /* The value for the DMdelivery field. Depending on the field
     * type, the string might be converted to a date or an integer. If the
     * value is longer than the maximum length in the database, the value
     * will be truncated. */
    private java.lang.String value;

    public RecipientNameValuePairType() {
    }

    public RecipientNameValuePairType(
           java.lang.String name,
           java.lang.String value) {
           this.name = name;
           this.value = value;
    }


    /**
     * Gets the name value for this RecipientNameValuePairType.
     * 
     * @return name   * The DMdelivery database field name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this RecipientNameValuePairType.
     * 
     * @param name   * The DMdelivery database field name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the value value for this RecipientNameValuePairType.
     * 
     * @return value   * The value for the DMdelivery field. Depending on the field
     * type, the string might be converted to a date or an integer. If the
     * value is longer than the maximum length in the database, the value
     * will be truncated.
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this RecipientNameValuePairType.
     * 
     * @param value   * The value for the DMdelivery field. Depending on the field
     * type, the string might be converted to a date or an integer. If the
     * value is longer than the maximum length in the database, the value
     * will be truncated.
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RecipientNameValuePairType)) return false;
        RecipientNameValuePairType other = (RecipientNameValuePairType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RecipientNameValuePairType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientNameValuePairType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
