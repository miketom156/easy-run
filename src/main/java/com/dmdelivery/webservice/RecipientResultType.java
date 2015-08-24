/**
 * RecipientResultType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This generic datatype is used as a return-value when adding multiple
 * recipients.
 */
public class RecipientResultType  implements java.io.Serializable {
    private com.dmdelivery.webservice.RecipientNameValuePairType[] fields;

    private java.lang.String DMDmessage;

    public RecipientResultType() {
    }

    public RecipientResultType(
           com.dmdelivery.webservice.RecipientNameValuePairType[] fields,
           java.lang.String DMDmessage) {
           this.fields = fields;
           this.DMDmessage = DMDmessage;
    }


    /**
     * Gets the fields value for this RecipientResultType.
     * 
     * @return fields
     */
    public com.dmdelivery.webservice.RecipientNameValuePairType[] getFields() {
        return fields;
    }


    /**
     * Sets the fields value for this RecipientResultType.
     * 
     * @param fields
     */
    public void setFields(com.dmdelivery.webservice.RecipientNameValuePairType[] fields) {
        this.fields = fields;
    }

    public com.dmdelivery.webservice.RecipientNameValuePairType getFields(int i) {
        return this.fields[i];
    }

    public void setFields(int i, com.dmdelivery.webservice.RecipientNameValuePairType _value) {
        this.fields[i] = _value;
    }


    /**
     * Gets the DMDmessage value for this RecipientResultType.
     * 
     * @return DMDmessage
     */
    public java.lang.String getDMDmessage() {
        return DMDmessage;
    }


    /**
     * Sets the DMDmessage value for this RecipientResultType.
     * 
     * @param DMDmessage
     */
    public void setDMDmessage(java.lang.String DMDmessage) {
        this.DMDmessage = DMDmessage;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RecipientResultType)) return false;
        RecipientResultType other = (RecipientResultType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fields==null && other.getFields()==null) || 
             (this.fields!=null &&
              java.util.Arrays.equals(this.fields, other.getFields()))) &&
            ((this.DMDmessage==null && other.getDMDmessage()==null) || 
             (this.DMDmessage!=null &&
              this.DMDmessage.equals(other.getDMDmessage())));
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
        if (getFields() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFields());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFields(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDMDmessage() != null) {
            _hashCode += getDMDmessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RecipientResultType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientResultType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fields");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fields"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientNameValuePairType"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DMDmessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DMDmessage"));
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
