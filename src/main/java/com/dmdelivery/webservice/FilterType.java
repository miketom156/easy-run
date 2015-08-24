/**
 * FilterType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype represents a filter. It consists of an ID and a name.
 */
public class FilterType  implements java.io.Serializable {
    private int filter_id;

    private java.lang.String filter_name;

    public FilterType() {
    }

    public FilterType(
           int filter_id,
           java.lang.String filter_name) {
           this.filter_id = filter_id;
           this.filter_name = filter_name;
    }


    /**
     * Gets the filter_id value for this FilterType.
     * 
     * @return filter_id
     */
    public int getFilter_id() {
        return filter_id;
    }


    /**
     * Sets the filter_id value for this FilterType.
     * 
     * @param filter_id
     */
    public void setFilter_id(int filter_id) {
        this.filter_id = filter_id;
    }


    /**
     * Gets the filter_name value for this FilterType.
     * 
     * @return filter_name
     */
    public java.lang.String getFilter_name() {
        return filter_name;
    }


    /**
     * Sets the filter_name value for this FilterType.
     * 
     * @param filter_name
     */
    public void setFilter_name(java.lang.String filter_name) {
        this.filter_name = filter_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FilterType)) return false;
        FilterType other = (FilterType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.filter_id == other.getFilter_id() &&
            ((this.filter_name==null && other.getFilter_name()==null) || 
             (this.filter_name!=null &&
              this.filter_name.equals(other.getFilter_name())));
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
        _hashCode += getFilter_id();
        if (getFilter_name() != null) {
            _hashCode += getFilter_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FilterType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "FilterType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_name"));
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
