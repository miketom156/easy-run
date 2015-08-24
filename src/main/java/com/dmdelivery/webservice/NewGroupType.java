/**
 * NewGroupType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype represents a recipient group. Used when creating
 * a new group.
 */
public class NewGroupType  implements java.io.Serializable {
    /* The name of the group. */
    private java.lang.String name;

    /* Whether or not the group is a test group. */
    private boolean is_test;

    /* Optional remarks for the group. */
    private java.lang.String remarks;

    public NewGroupType() {
    }

    public NewGroupType(
           java.lang.String name,
           boolean is_test,
           java.lang.String remarks) {
           this.name = name;
           this.is_test = is_test;
           this.remarks = remarks;
    }


    /**
     * Gets the name value for this NewGroupType.
     * 
     * @return name   * The name of the group.
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this NewGroupType.
     * 
     * @param name   * The name of the group.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the is_test value for this NewGroupType.
     * 
     * @return is_test   * Whether or not the group is a test group.
     */
    public boolean isIs_test() {
        return is_test;
    }


    /**
     * Sets the is_test value for this NewGroupType.
     * 
     * @param is_test   * Whether or not the group is a test group.
     */
    public void setIs_test(boolean is_test) {
        this.is_test = is_test;
    }


    /**
     * Gets the remarks value for this NewGroupType.
     * 
     * @return remarks   * Optional remarks for the group.
     */
    public java.lang.String getRemarks() {
        return remarks;
    }


    /**
     * Sets the remarks value for this NewGroupType.
     * 
     * @param remarks   * Optional remarks for the group.
     */
    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NewGroupType)) return false;
        NewGroupType other = (NewGroupType) obj;
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
            this.is_test == other.isIs_test() &&
            ((this.remarks==null && other.getRemarks()==null) || 
             (this.remarks!=null &&
              this.remarks.equals(other.getRemarks())));
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
        _hashCode += (isIs_test() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRemarks() != null) {
            _hashCode += getRemarks().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NewGroupType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "NewGroupType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_test");
        elemField.setXmlName(new javax.xml.namespace.QName("", "is_test"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remarks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remarks"));
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