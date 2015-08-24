/**
 * RecordResultType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype is used as a return value for adding a new record
 * (for example: group or recipient) to DMdelivery.
 */
public class RecordResultType  implements java.io.Serializable {
    /* Either 'OK' (record added successfully), 'DUPLICATE' (duplicate
     * record) or 'ERROR' (an error occured). */
    private com.dmdelivery.webservice.RecordResultTypeStatus status;

    /* Only available when status = 'ERROR'. Contains the error message. */
    private java.lang.String statusMsg;

    /* Only available when status = 'OK' or 'DUPLICATE'. Contains
     * the database ID for the record. */
    private java.lang.Integer id;

    public RecordResultType() {
    }

    public RecordResultType(
           com.dmdelivery.webservice.RecordResultTypeStatus status,
           java.lang.String statusMsg,
           java.lang.Integer id) {
           this.status = status;
           this.statusMsg = statusMsg;
           this.id = id;
    }


    /**
     * Gets the status value for this RecordResultType.
     * 
     * @return status   * Either 'OK' (record added successfully), 'DUPLICATE' (duplicate
     * record) or 'ERROR' (an error occured).
     */
    public com.dmdelivery.webservice.RecordResultTypeStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this RecordResultType.
     * 
     * @param status   * Either 'OK' (record added successfully), 'DUPLICATE' (duplicate
     * record) or 'ERROR' (an error occured).
     */
    public void setStatus(com.dmdelivery.webservice.RecordResultTypeStatus status) {
        this.status = status;
    }


    /**
     * Gets the statusMsg value for this RecordResultType.
     * 
     * @return statusMsg   * Only available when status = 'ERROR'. Contains the error message.
     */
    public java.lang.String getStatusMsg() {
        return statusMsg;
    }


    /**
     * Sets the statusMsg value for this RecordResultType.
     * 
     * @param statusMsg   * Only available when status = 'ERROR'. Contains the error message.
     */
    public void setStatusMsg(java.lang.String statusMsg) {
        this.statusMsg = statusMsg;
    }


    /**
     * Gets the id value for this RecordResultType.
     * 
     * @return id   * Only available when status = 'OK' or 'DUPLICATE'. Contains
     * the database ID for the record.
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this RecordResultType.
     * 
     * @param id   * Only available when status = 'OK' or 'DUPLICATE'. Contains
     * the database ID for the record.
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RecordResultType)) return false;
        RecordResultType other = (RecordResultType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.statusMsg==null && other.getStatusMsg()==null) || 
             (this.statusMsg!=null &&
              this.statusMsg.equals(other.getStatusMsg()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId())));
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
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatusMsg() != null) {
            _hashCode += getStatusMsg().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RecordResultType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecordResultType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">RecordResultType>status"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
