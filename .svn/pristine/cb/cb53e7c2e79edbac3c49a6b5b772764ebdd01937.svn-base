/**
 * AddRecipientsResultType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmdelivery.webservice;


/**
 * This datatype is used as a return value for adding multiple new
 * recipients to DMdelivery.
 */
public class AddRecipientsResultType  implements java.io.Serializable {
    /* Either 'OK' (*all* recipients added successfully), 'DUPLICATE'
     * (1 or more duplicate recipients) or 'ERROR' (an error occured). */
    private com.dmdelivery.webservice.AddRecipientsResultTypeStatus status;

    /* Only available when status == 'ERROR'. Contains the error message. */
    private java.lang.String statusMsg;

    /* Only available when adding one or more recipients failed. Contains
     * the recipient-records that failed. */
    private com.dmdelivery.webservice.RecipientResultType[] errors;

    /* Only available when adding one or more recipients caused a
     * duplicate. Contains the recipient-records that are duplicate. */
    private com.dmdelivery.webservice.RecipientResultType[] duplicates;

    /* Contains the successfully inserted recipient-records, including
     * the ID that DMdelivery assigned to them. */
    private com.dmdelivery.webservice.RecipientType[] successful;

    public AddRecipientsResultType() {
    }

    public AddRecipientsResultType(
           com.dmdelivery.webservice.AddRecipientsResultTypeStatus status,
           java.lang.String statusMsg,
           com.dmdelivery.webservice.RecipientResultType[] errors,
           com.dmdelivery.webservice.RecipientResultType[] duplicates,
           com.dmdelivery.webservice.RecipientType[] successful) {
           this.status = status;
           this.statusMsg = statusMsg;
           this.errors = errors;
           this.duplicates = duplicates;
           this.successful = successful;
    }


    /**
     * Gets the status value for this AddRecipientsResultType.
     * 
     * @return status   * Either 'OK' (*all* recipients added successfully), 'DUPLICATE'
     * (1 or more duplicate recipients) or 'ERROR' (an error occured).
     */
    public com.dmdelivery.webservice.AddRecipientsResultTypeStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this AddRecipientsResultType.
     * 
     * @param status   * Either 'OK' (*all* recipients added successfully), 'DUPLICATE'
     * (1 or more duplicate recipients) or 'ERROR' (an error occured).
     */
    public void setStatus(com.dmdelivery.webservice.AddRecipientsResultTypeStatus status) {
        this.status = status;
    }


    /**
     * Gets the statusMsg value for this AddRecipientsResultType.
     * 
     * @return statusMsg   * Only available when status == 'ERROR'. Contains the error message.
     */
    public java.lang.String getStatusMsg() {
        return statusMsg;
    }


    /**
     * Sets the statusMsg value for this AddRecipientsResultType.
     * 
     * @param statusMsg   * Only available when status == 'ERROR'. Contains the error message.
     */
    public void setStatusMsg(java.lang.String statusMsg) {
        this.statusMsg = statusMsg;
    }


    /**
     * Gets the errors value for this AddRecipientsResultType.
     * 
     * @return errors   * Only available when adding one or more recipients failed. Contains
     * the recipient-records that failed.
     */
    public com.dmdelivery.webservice.RecipientResultType[] getErrors() {
        return errors;
    }


    /**
     * Sets the errors value for this AddRecipientsResultType.
     * 
     * @param errors   * Only available when adding one or more recipients failed. Contains
     * the recipient-records that failed.
     */
    public void setErrors(com.dmdelivery.webservice.RecipientResultType[] errors) {
        this.errors = errors;
    }


    /**
     * Gets the duplicates value for this AddRecipientsResultType.
     * 
     * @return duplicates   * Only available when adding one or more recipients caused a
     * duplicate. Contains the recipient-records that are duplicate.
     */
    public com.dmdelivery.webservice.RecipientResultType[] getDuplicates() {
        return duplicates;
    }


    /**
     * Sets the duplicates value for this AddRecipientsResultType.
     * 
     * @param duplicates   * Only available when adding one or more recipients caused a
     * duplicate. Contains the recipient-records that are duplicate.
     */
    public void setDuplicates(com.dmdelivery.webservice.RecipientResultType[] duplicates) {
        this.duplicates = duplicates;
    }


    /**
     * Gets the successful value for this AddRecipientsResultType.
     * 
     * @return successful   * Contains the successfully inserted recipient-records, including
     * the ID that DMdelivery assigned to them.
     */
    public com.dmdelivery.webservice.RecipientType[] getSuccessful() {
        return successful;
    }


    /**
     * Sets the successful value for this AddRecipientsResultType.
     * 
     * @param successful   * Contains the successfully inserted recipient-records, including
     * the ID that DMdelivery assigned to them.
     */
    public void setSuccessful(com.dmdelivery.webservice.RecipientType[] successful) {
        this.successful = successful;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddRecipientsResultType)) return false;
        AddRecipientsResultType other = (AddRecipientsResultType) obj;
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
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              java.util.Arrays.equals(this.errors, other.getErrors()))) &&
            ((this.duplicates==null && other.getDuplicates()==null) || 
             (this.duplicates!=null &&
              java.util.Arrays.equals(this.duplicates, other.getDuplicates()))) &&
            ((this.successful==null && other.getSuccessful()==null) || 
             (this.successful!=null &&
              java.util.Arrays.equals(this.successful, other.getSuccessful())));
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
        if (getErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDuplicates() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDuplicates());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDuplicates(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSuccessful() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSuccessful());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSuccessful(), i);
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
        new org.apache.axis.description.TypeDesc(AddRecipientsResultType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "addRecipientsResultType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", ">addRecipientsResultType>status"));
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
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientResultType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "recipient"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duplicates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duplicates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientResultType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "recipient"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("successful");
        elemField.setXmlName(new javax.xml.namespace.QName("", "successful"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dmdelivery.com/webservice/", "RecipientType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "recipients"));
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
