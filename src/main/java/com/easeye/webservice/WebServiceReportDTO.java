/**
 * WebServiceReportDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class WebServiceReportDTO  implements java.io.Serializable {
    private String templateName;

    private java.util.Calendar sentDateTime;

    private int sentCount;

    private int openCount;

    private int optCount;

    private int clickTimes;

    private int hardBounceCount;

    private int softBounceCount;

    private int successCount;

    public WebServiceReportDTO() {
    }

    public WebServiceReportDTO(
           String templateName,
           java.util.Calendar sentDateTime,
           int sentCount,
           int openCount,
           int optCount,
           int clickTimes,
           int hardBounceCount,
           int softBounceCount,
           int successCount) {
           this.templateName = templateName;
           this.sentDateTime = sentDateTime;
           this.sentCount = sentCount;
           this.openCount = openCount;
           this.optCount = optCount;
           this.clickTimes = clickTimes;
           this.hardBounceCount = hardBounceCount;
           this.softBounceCount = softBounceCount;
           this.successCount = successCount;
    }


    /**
     * Gets the templateName value for this WebServiceReportDTO.
     * 
     * @return templateName
     */
    public String getTemplateName() {
        return templateName;
    }


    /**
     * Sets the templateName value for this WebServiceReportDTO.
     * 
     * @param templateName
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    /**
     * Gets the sentDateTime value for this WebServiceReportDTO.
     * 
     * @return sentDateTime
     */
    public java.util.Calendar getSentDateTime() {
        return sentDateTime;
    }


    /**
     * Sets the sentDateTime value for this WebServiceReportDTO.
     * 
     * @param sentDateTime
     */
    public void setSentDateTime(java.util.Calendar sentDateTime) {
        this.sentDateTime = sentDateTime;
    }


    /**
     * Gets the sentCount value for this WebServiceReportDTO.
     * 
     * @return sentCount
     */
    public int getSentCount() {
        return sentCount;
    }


    /**
     * Sets the sentCount value for this WebServiceReportDTO.
     * 
     * @param sentCount
     */
    public void setSentCount(int sentCount) {
        this.sentCount = sentCount;
    }


    /**
     * Gets the openCount value for this WebServiceReportDTO.
     * 
     * @return openCount
     */
    public int getOpenCount() {
        return openCount;
    }


    /**
     * Sets the openCount value for this WebServiceReportDTO.
     * 
     * @param openCount
     */
    public void setOpenCount(int openCount) {
        this.openCount = openCount;
    }


    /**
     * Gets the optCount value for this WebServiceReportDTO.
     * 
     * @return optCount
     */
    public int getOptCount() {
        return optCount;
    }


    /**
     * Sets the optCount value for this WebServiceReportDTO.
     * 
     * @param optCount
     */
    public void setOptCount(int optCount) {
        this.optCount = optCount;
    }


    /**
     * Gets the clickTimes value for this WebServiceReportDTO.
     * 
     * @return clickTimes
     */
    public int getClickTimes() {
        return clickTimes;
    }


    /**
     * Sets the clickTimes value for this WebServiceReportDTO.
     * 
     * @param clickTimes
     */
    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }


    /**
     * Gets the hardBounceCount value for this WebServiceReportDTO.
     * 
     * @return hardBounceCount
     */
    public int getHardBounceCount() {
        return hardBounceCount;
    }


    /**
     * Sets the hardBounceCount value for this WebServiceReportDTO.
     * 
     * @param hardBounceCount
     */
    public void setHardBounceCount(int hardBounceCount) {
        this.hardBounceCount = hardBounceCount;
    }


    /**
     * Gets the softBounceCount value for this WebServiceReportDTO.
     * 
     * @return softBounceCount
     */
    public int getSoftBounceCount() {
        return softBounceCount;
    }


    /**
     * Sets the softBounceCount value for this WebServiceReportDTO.
     * 
     * @param softBounceCount
     */
    public void setSoftBounceCount(int softBounceCount) {
        this.softBounceCount = softBounceCount;
    }


    /**
     * Gets the successCount value for this WebServiceReportDTO.
     * 
     * @return successCount
     */
    public int getSuccessCount() {
        return successCount;
    }


    /**
     * Sets the successCount value for this WebServiceReportDTO.
     * 
     * @param successCount
     */
    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof WebServiceReportDTO)) return false;
        WebServiceReportDTO other = (WebServiceReportDTO) obj;
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
            ((this.sentDateTime==null && other.getSentDateTime()==null) || 
             (this.sentDateTime!=null &&
              this.sentDateTime.equals(other.getSentDateTime()))) &&
            this.sentCount == other.getSentCount() &&
            this.openCount == other.getOpenCount() &&
            this.optCount == other.getOptCount() &&
            this.clickTimes == other.getClickTimes() &&
            this.hardBounceCount == other.getHardBounceCount() &&
            this.softBounceCount == other.getSoftBounceCount() &&
            this.successCount == other.getSuccessCount();
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
        if (getSentDateTime() != null) {
            _hashCode += getSentDateTime().hashCode();
        }
        _hashCode += getSentCount();
        _hashCode += getOpenCount();
        _hashCode += getOptCount();
        _hashCode += getClickTimes();
        _hashCode += getHardBounceCount();
        _hashCode += getSoftBounceCount();
        _hashCode += getSuccessCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebServiceReportDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "WebServiceReportDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "OpenCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("optCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "OptCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clickTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ClickTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hardBounceCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "HardBounceCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softBounceCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SoftBounceCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("successCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SuccessCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
