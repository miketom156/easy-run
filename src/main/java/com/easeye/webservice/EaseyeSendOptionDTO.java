/**
 * EaseyeSendOptionDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class EaseyeSendOptionDTO  implements java.io.Serializable {
    private String mailProjectName;

    private String mailListName;

    private String senderName;

    private String senderEmail;

    private String replyTo;

    private boolean isActive;

    private String scheduleSendTime;

    private String isSendOnce;

    private String customDomain;

    private String trackOpen;

    private String topicName;

    private String contactLiveNew;

    private String expirationDate;

    public EaseyeSendOptionDTO() {
    }

    public EaseyeSendOptionDTO(
           String mailProjectName,
           String mailListName,
           String senderName,
           String senderEmail,
           String replyTo,
           boolean isActive,
           String scheduleSendTime,
           String isSendOnce,
           String customDomain,
           String trackOpen,
           String topicName,
           String contactLiveNew,
           String expirationDate) {
           this.mailProjectName = mailProjectName;
           this.mailListName = mailListName;
           this.senderName = senderName;
           this.senderEmail = senderEmail;
           this.replyTo = replyTo;
           this.isActive = isActive;
           this.scheduleSendTime = scheduleSendTime;
           this.isSendOnce = isSendOnce;
           this.customDomain = customDomain;
           this.trackOpen = trackOpen;
           this.topicName = topicName;
           this.contactLiveNew = contactLiveNew;
           this.expirationDate = expirationDate;
    }


    /**
     * Gets the mailProjectName value for this EaseyeSendOptionDTO.
     * 
     * @return mailProjectName
     */
    public String getMailProjectName() {
        return mailProjectName;
    }


    /**
     * Sets the mailProjectName value for this EaseyeSendOptionDTO.
     * 
     * @param mailProjectName
     */
    public void setMailProjectName(String mailProjectName) {
        this.mailProjectName = mailProjectName;
    }


    /**
     * Gets the mailListName value for this EaseyeSendOptionDTO.
     * 
     * @return mailListName
     */
    public String getMailListName() {
        return mailListName;
    }


    /**
     * Sets the mailListName value for this EaseyeSendOptionDTO.
     * 
     * @param mailListName
     */
    public void setMailListName(String mailListName) {
        this.mailListName = mailListName;
    }


    /**
     * Gets the senderName value for this EaseyeSendOptionDTO.
     * 
     * @return senderName
     */
    public String getSenderName() {
        return senderName;
    }


    /**
     * Sets the senderName value for this EaseyeSendOptionDTO.
     * 
     * @param senderName
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }


    /**
     * Gets the senderEmail value for this EaseyeSendOptionDTO.
     * 
     * @return senderEmail
     */
    public String getSenderEmail() {
        return senderEmail;
    }


    /**
     * Sets the senderEmail value for this EaseyeSendOptionDTO.
     * 
     * @param senderEmail
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }


    /**
     * Gets the replyTo value for this EaseyeSendOptionDTO.
     * 
     * @return replyTo
     */
    public String getReplyTo() {
        return replyTo;
    }


    /**
     * Sets the replyTo value for this EaseyeSendOptionDTO.
     * 
     * @param replyTo
     */
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }


    /**
     * Gets the isActive value for this EaseyeSendOptionDTO.
     * 
     * @return isActive
     */
    public boolean isIsActive() {
        return isActive;
    }


    /**
     * Sets the isActive value for this EaseyeSendOptionDTO.
     * 
     * @param isActive
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    /**
     * Gets the scheduleSendTime value for this EaseyeSendOptionDTO.
     * 
     * @return scheduleSendTime
     */
    public String getScheduleSendTime() {
        return scheduleSendTime;
    }


    /**
     * Sets the scheduleSendTime value for this EaseyeSendOptionDTO.
     * 
     * @param scheduleSendTime
     */
    public void setScheduleSendTime(String scheduleSendTime) {
        this.scheduleSendTime = scheduleSendTime;
    }


    /**
     * Gets the isSendOnce value for this EaseyeSendOptionDTO.
     * 
     * @return isSendOnce
     */
    public String getIsSendOnce() {
        return isSendOnce;
    }


    /**
     * Sets the isSendOnce value for this EaseyeSendOptionDTO.
     * 
     * @param isSendOnce
     */
    public void setIsSendOnce(String isSendOnce) {
        this.isSendOnce = isSendOnce;
    }


    /**
     * Gets the customDomain value for this EaseyeSendOptionDTO.
     * 
     * @return customDomain
     */
    public String getCustomDomain() {
        return customDomain;
    }


    /**
     * Sets the customDomain value for this EaseyeSendOptionDTO.
     * 
     * @param customDomain
     */
    public void setCustomDomain(String customDomain) {
        this.customDomain = customDomain;
    }


    /**
     * Gets the trackOpen value for this EaseyeSendOptionDTO.
     * 
     * @return trackOpen
     */
    public String getTrackOpen() {
        return trackOpen;
    }


    /**
     * Sets the trackOpen value for this EaseyeSendOptionDTO.
     * 
     * @param trackOpen
     */
    public void setTrackOpen(String trackOpen) {
        this.trackOpen = trackOpen;
    }


    /**
     * Gets the topicName value for this EaseyeSendOptionDTO.
     * 
     * @return topicName
     */
    public String getTopicName() {
        return topicName;
    }


    /**
     * Sets the topicName value for this EaseyeSendOptionDTO.
     * 
     * @param topicName
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }


    /**
     * Gets the contactLiveNew value for this EaseyeSendOptionDTO.
     * 
     * @return contactLiveNew
     */
    public String getContactLiveNew() {
        return contactLiveNew;
    }


    /**
     * Sets the contactLiveNew value for this EaseyeSendOptionDTO.
     * 
     * @param contactLiveNew
     */
    public void setContactLiveNew(String contactLiveNew) {
        this.contactLiveNew = contactLiveNew;
    }


    /**
     * Gets the expirationDate value for this EaseyeSendOptionDTO.
     * 
     * @return expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }


    /**
     * Sets the expirationDate value for this EaseyeSendOptionDTO.
     * 
     * @param expirationDate
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EaseyeSendOptionDTO)) return false;
        EaseyeSendOptionDTO other = (EaseyeSendOptionDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mailProjectName==null && other.getMailProjectName()==null) || 
             (this.mailProjectName!=null &&
              this.mailProjectName.equals(other.getMailProjectName()))) &&
            ((this.mailListName==null && other.getMailListName()==null) || 
             (this.mailListName!=null &&
              this.mailListName.equals(other.getMailListName()))) &&
            ((this.senderName==null && other.getSenderName()==null) || 
             (this.senderName!=null &&
              this.senderName.equals(other.getSenderName()))) &&
            ((this.senderEmail==null && other.getSenderEmail()==null) || 
             (this.senderEmail!=null &&
              this.senderEmail.equals(other.getSenderEmail()))) &&
            ((this.replyTo==null && other.getReplyTo()==null) || 
             (this.replyTo!=null &&
              this.replyTo.equals(other.getReplyTo()))) &&
            this.isActive == other.isIsActive() &&
            ((this.scheduleSendTime==null && other.getScheduleSendTime()==null) || 
             (this.scheduleSendTime!=null &&
              this.scheduleSendTime.equals(other.getScheduleSendTime()))) &&
            ((this.isSendOnce==null && other.getIsSendOnce()==null) || 
             (this.isSendOnce!=null &&
              this.isSendOnce.equals(other.getIsSendOnce()))) &&
            ((this.customDomain==null && other.getCustomDomain()==null) || 
             (this.customDomain!=null &&
              this.customDomain.equals(other.getCustomDomain()))) &&
            ((this.trackOpen==null && other.getTrackOpen()==null) || 
             (this.trackOpen!=null &&
              this.trackOpen.equals(other.getTrackOpen()))) &&
            ((this.topicName==null && other.getTopicName()==null) || 
             (this.topicName!=null &&
              this.topicName.equals(other.getTopicName()))) &&
            ((this.contactLiveNew==null && other.getContactLiveNew()==null) || 
             (this.contactLiveNew!=null &&
              this.contactLiveNew.equals(other.getContactLiveNew()))) &&
            ((this.expirationDate==null && other.getExpirationDate()==null) || 
             (this.expirationDate!=null &&
              this.expirationDate.equals(other.getExpirationDate())));
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
        if (getMailProjectName() != null) {
            _hashCode += getMailProjectName().hashCode();
        }
        if (getMailListName() != null) {
            _hashCode += getMailListName().hashCode();
        }
        if (getSenderName() != null) {
            _hashCode += getSenderName().hashCode();
        }
        if (getSenderEmail() != null) {
            _hashCode += getSenderEmail().hashCode();
        }
        if (getReplyTo() != null) {
            _hashCode += getReplyTo().hashCode();
        }
        _hashCode += (isIsActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getScheduleSendTime() != null) {
            _hashCode += getScheduleSendTime().hashCode();
        }
        if (getIsSendOnce() != null) {
            _hashCode += getIsSendOnce().hashCode();
        }
        if (getCustomDomain() != null) {
            _hashCode += getCustomDomain().hashCode();
        }
        if (getTrackOpen() != null) {
            _hashCode += getTrackOpen().hashCode();
        }
        if (getTopicName() != null) {
            _hashCode += getTopicName().hashCode();
        }
        if (getContactLiveNew() != null) {
            _hashCode += getContactLiveNew().hashCode();
        }
        if (getExpirationDate() != null) {
            _hashCode += getExpirationDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EaseyeSendOptionDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeSendOptionDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailProjectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailProjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailListName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailListName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SenderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SenderEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replyTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReplyTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isActive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "IsActive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleSendTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ScheduleSendTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSendOnce");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "IsSendOnce"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customDomain");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "CustomDomain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackOpen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TrackOpen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("topicName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TopicName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactLiveNew");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ContactLiveNew"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expirationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ExpirationDate"));
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
