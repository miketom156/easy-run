/**
 * SMTPReportDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class SMTPReportDetail  implements java.io.Serializable {
    private String email;

    private java.util.Calendar sentDateTime;

    private String category;

    private String campaign;

    private String uniqueMsgID;

    private String IP;

    private String region;

    private String link;

    private String reason;

    private short status;

    public SMTPReportDetail() {
    }

    public SMTPReportDetail(
           String email,
           java.util.Calendar sentDateTime,
           String category,
           String campaign,
           String uniqueMsgID,
           String IP,
           String region,
           String link,
           String reason,
           short status) {
           this.email = email;
           this.sentDateTime = sentDateTime;
           this.category = category;
           this.campaign = campaign;
           this.uniqueMsgID = uniqueMsgID;
           this.IP = IP;
           this.region = region;
           this.link = link;
           this.reason = reason;
           this.status = status;
    }


    /**
     * Gets the email value for this SMTPReportDetail.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this SMTPReportDetail.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the sentDateTime value for this SMTPReportDetail.
     * 
     * @return sentDateTime
     */
    public java.util.Calendar getSentDateTime() {
        return sentDateTime;
    }


    /**
     * Sets the sentDateTime value for this SMTPReportDetail.
     * 
     * @param sentDateTime
     */
    public void setSentDateTime(java.util.Calendar sentDateTime) {
        this.sentDateTime = sentDateTime;
    }


    /**
     * Gets the category value for this SMTPReportDetail.
     * 
     * @return category
     */
    public String getCategory() {
        return category;
    }


    /**
     * Sets the category value for this SMTPReportDetail.
     * 
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }


    /**
     * Gets the campaign value for this SMTPReportDetail.
     * 
     * @return campaign
     */
    public String getCampaign() {
        return campaign;
    }


    /**
     * Sets the campaign value for this SMTPReportDetail.
     * 
     * @param campaign
     */
    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }


    /**
     * Gets the uniqueMsgID value for this SMTPReportDetail.
     * 
     * @return uniqueMsgID
     */
    public String getUniqueMsgID() {
        return uniqueMsgID;
    }


    /**
     * Sets the uniqueMsgID value for this SMTPReportDetail.
     * 
     * @param uniqueMsgID
     */
    public void setUniqueMsgID(String uniqueMsgID) {
        this.uniqueMsgID = uniqueMsgID;
    }


    /**
     * Gets the IP value for this SMTPReportDetail.
     * 
     * @return IP
     */
    public String getIP() {
        return IP;
    }


    /**
     * Sets the IP value for this SMTPReportDetail.
     * 
     * @param IP
     */
    public void setIP(String IP) {
        this.IP = IP;
    }


    /**
     * Gets the region value for this SMTPReportDetail.
     * 
     * @return region
     */
    public String getRegion() {
        return region;
    }


    /**
     * Sets the region value for this SMTPReportDetail.
     * 
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }


    /**
     * Gets the link value for this SMTPReportDetail.
     * 
     * @return link
     */
    public String getLink() {
        return link;
    }


    /**
     * Sets the link value for this SMTPReportDetail.
     * 
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }


    /**
     * Gets the reason value for this SMTPReportDetail.
     * 
     * @return reason
     */
    public String getReason() {
        return reason;
    }


    /**
     * Sets the reason value for this SMTPReportDetail.
     * 
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }


    /**
     * Gets the status value for this SMTPReportDetail.
     * 
     * @return status
     */
    public short getStatus() {
        return status;
    }


    /**
     * Sets the status value for this SMTPReportDetail.
     * 
     * @param status
     */
    public void setStatus(short status) {
        this.status = status;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SMTPReportDetail)) return false;
        SMTPReportDetail other = (SMTPReportDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.sentDateTime==null && other.getSentDateTime()==null) || 
             (this.sentDateTime!=null &&
              this.sentDateTime.equals(other.getSentDateTime()))) &&
            ((this.category==null && other.getCategory()==null) || 
             (this.category!=null &&
              this.category.equals(other.getCategory()))) &&
            ((this.campaign==null && other.getCampaign()==null) || 
             (this.campaign!=null &&
              this.campaign.equals(other.getCampaign()))) &&
            ((this.uniqueMsgID==null && other.getUniqueMsgID()==null) || 
             (this.uniqueMsgID!=null &&
              this.uniqueMsgID.equals(other.getUniqueMsgID()))) &&
            ((this.IP==null && other.getIP()==null) || 
             (this.IP!=null &&
              this.IP.equals(other.getIP()))) &&
            ((this.region==null && other.getRegion()==null) || 
             (this.region!=null &&
              this.region.equals(other.getRegion()))) &&
            ((this.link==null && other.getLink()==null) || 
             (this.link!=null &&
              this.link.equals(other.getLink()))) &&
            ((this.reason==null && other.getReason()==null) || 
             (this.reason!=null &&
              this.reason.equals(other.getReason()))) &&
            this.status == other.getStatus();
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getSentDateTime() != null) {
            _hashCode += getSentDateTime().hashCode();
        }
        if (getCategory() != null) {
            _hashCode += getCategory().hashCode();
        }
        if (getCampaign() != null) {
            _hashCode += getCampaign().hashCode();
        }
        if (getUniqueMsgID() != null) {
            _hashCode += getUniqueMsgID().hashCode();
        }
        if (getIP() != null) {
            _hashCode += getIP().hashCode();
        }
        if (getRegion() != null) {
            _hashCode += getRegion().hashCode();
        }
        if (getLink() != null) {
            _hashCode += getLink().hashCode();
        }
        if (getReason() != null) {
            _hashCode += getReason().hashCode();
        }
        _hashCode += getStatus();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMTPReportDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SMTPReportDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Email"));
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
        elemField.setFieldName("uniqueMsgID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UniqueMsgID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "IP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("region");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Region"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("link");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Link"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Reason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
