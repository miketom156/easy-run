/**
 * SMTPBulkReport.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class SMTPBulkReport  implements java.io.Serializable {
    private String category;

    private String campaign;

    private java.util.Calendar countDateTime;

    private int processCount;

    private int successCount;

    private int openCount;

    private int clickCount;

    private int clickTimes;

    private int hardBounce;

    private int softBounce;

    private int unsubscribeCount;

    public SMTPBulkReport() {
    }

    public SMTPBulkReport(
           String category,
           String campaign,
           java.util.Calendar countDateTime,
           int processCount,
           int successCount,
           int openCount,
           int clickCount,
           int clickTimes,
           int hardBounce,
           int softBounce,
           int unsubscribeCount) {
           this.category = category;
           this.campaign = campaign;
           this.countDateTime = countDateTime;
           this.processCount = processCount;
           this.successCount = successCount;
           this.openCount = openCount;
           this.clickCount = clickCount;
           this.clickTimes = clickTimes;
           this.hardBounce = hardBounce;
           this.softBounce = softBounce;
           this.unsubscribeCount = unsubscribeCount;
    }


    /**
     * Gets the category value for this SMTPBulkReport.
     * 
     * @return category
     */
    public String getCategory() {
        return category;
    }


    /**
     * Sets the category value for this SMTPBulkReport.
     * 
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }


    /**
     * Gets the campaign value for this SMTPBulkReport.
     * 
     * @return campaign
     */
    public String getCampaign() {
        return campaign;
    }


    /**
     * Sets the campaign value for this SMTPBulkReport.
     * 
     * @param campaign
     */
    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }


    /**
     * Gets the countDateTime value for this SMTPBulkReport.
     * 
     * @return countDateTime
     */
    public java.util.Calendar getCountDateTime() {
        return countDateTime;
    }


    /**
     * Sets the countDateTime value for this SMTPBulkReport.
     * 
     * @param countDateTime
     */
    public void setCountDateTime(java.util.Calendar countDateTime) {
        this.countDateTime = countDateTime;
    }


    /**
     * Gets the processCount value for this SMTPBulkReport.
     * 
     * @return processCount
     */
    public int getProcessCount() {
        return processCount;
    }


    /**
     * Sets the processCount value for this SMTPBulkReport.
     * 
     * @param processCount
     */
    public void setProcessCount(int processCount) {
        this.processCount = processCount;
    }


    /**
     * Gets the successCount value for this SMTPBulkReport.
     * 
     * @return successCount
     */
    public int getSuccessCount() {
        return successCount;
    }


    /**
     * Sets the successCount value for this SMTPBulkReport.
     * 
     * @param successCount
     */
    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }


    /**
     * Gets the openCount value for this SMTPBulkReport.
     * 
     * @return openCount
     */
    public int getOpenCount() {
        return openCount;
    }


    /**
     * Sets the openCount value for this SMTPBulkReport.
     * 
     * @param openCount
     */
    public void setOpenCount(int openCount) {
        this.openCount = openCount;
    }


    /**
     * Gets the clickCount value for this SMTPBulkReport.
     * 
     * @return clickCount
     */
    public int getClickCount() {
        return clickCount;
    }


    /**
     * Sets the clickCount value for this SMTPBulkReport.
     * 
     * @param clickCount
     */
    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }


    /**
     * Gets the clickTimes value for this SMTPBulkReport.
     * 
     * @return clickTimes
     */
    public int getClickTimes() {
        return clickTimes;
    }


    /**
     * Sets the clickTimes value for this SMTPBulkReport.
     * 
     * @param clickTimes
     */
    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }


    /**
     * Gets the hardBounce value for this SMTPBulkReport.
     * 
     * @return hardBounce
     */
    public int getHardBounce() {
        return hardBounce;
    }


    /**
     * Sets the hardBounce value for this SMTPBulkReport.
     * 
     * @param hardBounce
     */
    public void setHardBounce(int hardBounce) {
        this.hardBounce = hardBounce;
    }


    /**
     * Gets the softBounce value for this SMTPBulkReport.
     * 
     * @return softBounce
     */
    public int getSoftBounce() {
        return softBounce;
    }


    /**
     * Sets the softBounce value for this SMTPBulkReport.
     * 
     * @param softBounce
     */
    public void setSoftBounce(int softBounce) {
        this.softBounce = softBounce;
    }


    /**
     * Gets the unsubscribeCount value for this SMTPBulkReport.
     * 
     * @return unsubscribeCount
     */
    public int getUnsubscribeCount() {
        return unsubscribeCount;
    }


    /**
     * Sets the unsubscribeCount value for this SMTPBulkReport.
     * 
     * @param unsubscribeCount
     */
    public void setUnsubscribeCount(int unsubscribeCount) {
        this.unsubscribeCount = unsubscribeCount;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SMTPBulkReport)) return false;
        SMTPBulkReport other = (SMTPBulkReport) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            ((this.campaign==null && other.getCampaign()==null) || 
             (this.campaign!=null &&
              this.campaign.equals(other.getCampaign()))) &&
            ((this.countDateTime==null && other.getCountDateTime()==null) || 
             (this.countDateTime!=null &&
              this.countDateTime.equals(other.getCountDateTime()))) &&
            this.processCount == other.getProcessCount() &&
            this.successCount == other.getSuccessCount() &&
            this.openCount == other.getOpenCount() &&
            this.clickCount == other.getClickCount() &&
            this.clickTimes == other.getClickTimes() &&
            this.hardBounce == other.getHardBounce() &&
            this.softBounce == other.getSoftBounce() &&
            this.unsubscribeCount == other.getUnsubscribeCount();
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
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        if (getCampaign() != null) {
            _hashCode += getCampaign().hashCode();
        }
        if (getCountDateTime() != null) {
            _hashCode += getCountDateTime().hashCode();
        }
        _hashCode += getProcessCount();
        _hashCode += getSuccessCount();
        _hashCode += getOpenCount();
        _hashCode += getClickCount();
        _hashCode += getClickTimes();
        _hashCode += getHardBounce();
        _hashCode += getSoftBounce();
        _hashCode += getUnsubscribeCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMTPBulkReport.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPBulkReport"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaign");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Campaign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CountDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ProcessCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("successCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SuccessCount"));
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
        elemField.setFieldName("clickCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ClickCount"));
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
        elemField.setFieldName("hardBounce");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "HardBounce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("softBounce");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SoftBounce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unsubscribeCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UnsubscribeCount"));
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
