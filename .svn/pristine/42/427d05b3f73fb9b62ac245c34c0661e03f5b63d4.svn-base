/**
 * MailingResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype represents a single Mailing Response record, for
 * example an open or click.
 */
public class MailingResponseType  implements java.io.Serializable {
    /* The database value for the requested field of the recipient. */
    private java.lang.String field;

    /* The type of response (click or open). */
    private com.dmdelivery.webservice.MailingResponseTypeType type;

    /* The date/time this response was generated. */
    private java.lang.Object log_date;

    public MailingResponseType() {
    }

    public MailingResponseType(
           java.lang.String field,
           com.dmdelivery.webservice.MailingResponseTypeType type,
           java.lang.Object log_date) {
           this.field = field;
           this.type = type;
           this.log_date = log_date;
    }


    /**
     * Gets the field value for this MailingResponseType.
     * 
     * @return field   * The database value for the requested field of the recipient.
     */
    public java.lang.String getField() {
        return field;
    }


    /**
     * Sets the field value for this MailingResponseType.
     * 
     * @param field   * The database value for the requested field of the recipient.
     */
    public void setField(java.lang.String field) {
        this.field = field;
    }


    /**
     * Gets the type value for this MailingResponseType.
     * 
     * @return type   * The type of response (click or open).
     */
    public com.dmdelivery.webservice.MailingResponseTypeType getType() {
        return type;
    }


    /**
     * Sets the type value for this MailingResponseType.
     * 
     * @param type   * The type of response (click or open).
     */
    public void setType(com.dmdelivery.webservice.MailingResponseTypeType type) {
        this.type = type;
    }


    /**
     * Gets the log_date value for this MailingResponseType.
     * 
     * @return log_date   * The date/time this response was generated.
     */
    public java.lang.Object getLog_date() {
        return log_date;
    }


    /**
     * Sets the log_date value for this MailingResponseType.
     * 
     * @param log_date   * The date/time this response was generated.
     */
    public void setLog_date(java.lang.Object log_date) {
        this.log_date = log_date;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MailingResponseType)) return false;
        MailingResponseType other = (MailingResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              this.field.equals(other.getField()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.log_date==null && other.getLog_date()==null) || 
             (this.log_date!=null &&
              this.log_date.equals(other.getLog_date())));
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
        if (getField() != null) {
            _hashCode += getField().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getLog_date() != null) {
            _hashCode += getLog_date().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailingResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "MailingResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("field");
        elemField.setXmlName(new javax.xml.namespace.QName("", "field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">MailingResponseType>type"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("log_date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "log_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
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
