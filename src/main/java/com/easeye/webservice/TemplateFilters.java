/**
 * TemplateFilters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class TemplateFilters  implements java.io.Serializable {
    private String templateName;

    private java.util.Calendar beginTime;

    private java.util.Calendar endTime;

    private String sort_field;

    private String sort_dir;

    public TemplateFilters() {
    }

    public TemplateFilters(
           String templateName,
           java.util.Calendar beginTime,
           java.util.Calendar endTime,
           String sort_field,
           String sort_dir) {
           this.templateName = templateName;
           this.beginTime = beginTime;
           this.endTime = endTime;
           this.sort_field = sort_field;
           this.sort_dir = sort_dir;
    }


    /**
     * Gets the templateName value for this TemplateFilters.
     * 
     * @return templateName
     */
    public String getTemplateName() {
        return templateName;
    }


    /**
     * Sets the templateName value for this TemplateFilters.
     * 
     * @param templateName
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    /**
     * Gets the beginTime value for this TemplateFilters.
     * 
     * @return beginTime
     */
    public java.util.Calendar getBeginTime() {
        return beginTime;
    }


    /**
     * Sets the beginTime value for this TemplateFilters.
     * 
     * @param beginTime
     */
    public void setBeginTime(java.util.Calendar beginTime) {
        this.beginTime = beginTime;
    }


    /**
     * Gets the endTime value for this TemplateFilters.
     * 
     * @return endTime
     */
    public java.util.Calendar getEndTime() {
        return endTime;
    }


    /**
     * Sets the endTime value for this TemplateFilters.
     * 
     * @param endTime
     */
    public void setEndTime(java.util.Calendar endTime) {
        this.endTime = endTime;
    }


    /**
     * Gets the sort_field value for this TemplateFilters.
     * 
     * @return sort_field
     */
    public String getSort_field() {
        return sort_field;
    }


    /**
     * Sets the sort_field value for this TemplateFilters.
     * 
     * @param sort_field
     */
    public void setSort_field(String sort_field) {
        this.sort_field = sort_field;
    }


    /**
     * Gets the sort_dir value for this TemplateFilters.
     * 
     * @return sort_dir
     */
    public String getSort_dir() {
        return sort_dir;
    }


    /**
     * Sets the sort_dir value for this TemplateFilters.
     * 
     * @param sort_dir
     */
    public void setSort_dir(String sort_dir) {
        this.sort_dir = sort_dir;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof TemplateFilters)) return false;
        TemplateFilters other = (TemplateFilters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.templateName==null && other.getTemplateName()==null) || 
             (this.templateName!=null &&
              this.templateName.equals(other.getTemplateName()))) &&
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
        if (getTemplateName() != null) {
            _hashCode += getTemplateName().hashCode();
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
        new org.apache.axis.description.TypeDesc(TemplateFilters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateFilters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beginTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "BeginTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EndTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
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
