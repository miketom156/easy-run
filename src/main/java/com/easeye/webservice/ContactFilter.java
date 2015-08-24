/**
 * ContactFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class ContactFilter  implements java.io.Serializable {
    private String groupName;

    private String email;

    private String status;

    private java.util.Calendar beginTime;

    private java.util.Calendar endTime;

    private String sort_field;

    private String sort_dir;

    public ContactFilter() {
    }

    public ContactFilter(
           String groupName,
           String email,
           String status,
           java.util.Calendar beginTime,
           java.util.Calendar endTime,
           String sort_field,
           String sort_dir) {
           this.groupName = groupName;
           this.email = email;
           this.status = status;
           this.beginTime = beginTime;
           this.endTime = endTime;
           this.sort_field = sort_field;
           this.sort_dir = sort_dir;
    }


    /**
     * Gets the groupName value for this ContactFilter.
     * 
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this ContactFilter.
     * 
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the email value for this ContactFilter.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ContactFilter.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the status value for this ContactFilter.
     * 
     * @return status
     */
    public String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ContactFilter.
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Gets the beginTime value for this ContactFilter.
     * 
     * @return beginTime
     */
    public java.util.Calendar getBeginTime() {
        return beginTime;
    }


    /**
     * Sets the beginTime value for this ContactFilter.
     * 
     * @param beginTime
     */
    public void setBeginTime(java.util.Calendar beginTime) {
        this.beginTime = beginTime;
    }


    /**
     * Gets the endTime value for this ContactFilter.
     * 
     * @return endTime
     */
    public java.util.Calendar getEndTime() {
        return endTime;
    }


    /**
     * Sets the endTime value for this ContactFilter.
     * 
     * @param endTime
     */
    public void setEndTime(java.util.Calendar endTime) {
        this.endTime = endTime;
    }


    /**
     * Gets the sort_field value for this ContactFilter.
     * 
     * @return sort_field
     */
    public String getSort_field() {
        return sort_field;
    }


    /**
     * Sets the sort_field value for this ContactFilter.
     * 
     * @param sort_field
     */
    public void setSort_field(String sort_field) {
        this.sort_field = sort_field;
    }


    /**
     * Gets the sort_dir value for this ContactFilter.
     * 
     * @return sort_dir
     */
    public String getSort_dir() {
        return sort_dir;
    }


    /**
     * Sets the sort_dir value for this ContactFilter.
     * 
     * @param sort_dir
     */
    public void setSort_dir(String sort_dir) {
        this.sort_dir = sort_dir;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ContactFilter)) return false;
        ContactFilter other = (ContactFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.groupName==null && other.getGroupName()==null) || 
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.beginTime==null && other.getBeginTime()==null) || 
             (this.beginTime!=null &&
              this.beginTime.equals(other.getBeginTime()))) &&
            ((this.endTime==null && other.getEndTime()==null) || 
             (this.endTime!=null &&
              this.endTime.equals(other.getEndTime()))) &&
            ((this.sort_field==null && other.getSort_field()==null) || 
             (this.sort_field!=null &&
              this.sort_field.equals(other.getSort_field()))) &&
            ((this.sort_dir==null && other.getSort_dir()==null) || 
             (this.sort_dir!=null &&
              this.sort_dir.equals(other.getSort_dir())));
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
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getBeginTime() != null) {
            _hashCode += getBeginTime().hashCode();
        }
        if (getEndTime() != null) {
            _hashCode += getEndTime().hashCode();
        }
        if (getSort_field() != null) {
            _hashCode += getSort_field().hashCode();
        }
        if (getSort_dir() != null) {
            _hashCode += getSort_dir().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContactFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "GroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beginTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "BeginTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EndTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sort_field");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Sort_field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sort_dir");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Sort_dir"));
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
