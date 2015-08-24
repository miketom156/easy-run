/**
 * SenderAddressType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype represents a sender address.
 */
public class SenderAddressType  implements java.io.Serializable {
    /* The database ID of the sender address. */
    private int id;

    /* The from address used by DMdelivery. */
    private java.lang.String dmdelivery_address;

    /* The forward email address. */
    private java.lang.String forward_address;

    /* The (optional) alias. */
    private java.lang.String alias_address;

    public SenderAddressType() {
    }

    public SenderAddressType(
           int id,
           java.lang.String dmdelivery_address,
           java.lang.String forward_address,
           java.lang.String alias_address) {
           this.id = id;
           this.dmdelivery_address = dmdelivery_address;
           this.forward_address = forward_address;
           this.alias_address = alias_address;
    }


    /**
     * Gets the id value for this SenderAddressType.
     * 
     * @return id   * The database ID of the sender address.
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this SenderAddressType.
     * 
     * @param id   * The database ID of the sender address.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the dmdelivery_address value for this SenderAddressType.
     * 
     * @return dmdelivery_address   * The from address used by DMdelivery.
     */
    public java.lang.String getDmdelivery_address() {
        return dmdelivery_address;
    }


    /**
     * Sets the dmdelivery_address value for this SenderAddressType.
     * 
     * @param dmdelivery_address   * The from address used by DMdelivery.
     */
    public void setDmdelivery_address(java.lang.String dmdelivery_address) {
        this.dmdelivery_address = dmdelivery_address;
    }


    /**
     * Gets the forward_address value for this SenderAddressType.
     * 
     * @return forward_address   * The forward email address.
     */
    public java.lang.String getForward_address() {
        return forward_address;
    }


    /**
     * Sets the forward_address value for this SenderAddressType.
     * 
     * @param forward_address   * The forward email address.
     */
    public void setForward_address(java.lang.String forward_address) {
        this.forward_address = forward_address;
    }


    /**
     * Gets the alias_address value for this SenderAddressType.
     * 
     * @return alias_address   * The (optional) alias.
     */
    public java.lang.String getAlias_address() {
        return alias_address;
    }


    /**
     * Sets the alias_address value for this SenderAddressType.
     * 
     * @param alias_address   * The (optional) alias.
     */
    public void setAlias_address(java.lang.String alias_address) {
        this.alias_address = alias_address;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SenderAddressType)) return false;
        SenderAddressType other = (SenderAddressType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.id == other.getId() &&
            ((this.dmdelivery_address==null && other.getDmdelivery_address()==null) || 
             (this.dmdelivery_address!=null &&
              this.dmdelivery_address.equals(other.getDmdelivery_address()))) &&
            ((this.forward_address==null && other.getForward_address()==null) || 
             (this.forward_address!=null &&
              this.forward_address.equals(other.getForward_address()))) &&
            ((this.alias_address==null && other.getAlias_address()==null) || 
             (this.alias_address!=null &&
              this.alias_address.equals(other.getAlias_address())));
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
        _hashCode += getId();
        if (getDmdelivery_address() != null) {
            _hashCode += getDmdelivery_address().hashCode();
        }
        if (getForward_address() != null) {
            _hashCode += getForward_address().hashCode();
        }
        if (getAlias_address() != null) {
            _hashCode += getAlias_address().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SenderAddressType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "SenderAddressType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dmdelivery_address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dmdelivery_address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forward_address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forward_address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alias_address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "alias_address"));
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
