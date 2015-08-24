/**
 * ReportDetailExt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class ReportDetailExt  implements java.io.Serializable {
    private String email;

    private int sentFlag;

    private int subSentFlag;

    private java.util.Calendar eventDate;

    private java.util.Calendar addDate;

    private java.util.Calendar sentDate;

    private String UA;

    private String platform;

    private String browserType;

    private String link;

    private String title;

    private String IP;

    private String templateName;

    public ReportDetailExt() {
    }

    public ReportDetailExt(
           String email,
           int sentFlag,
           int subSentFlag,
           java.util.Calendar eventDate,
           java.util.Calendar addDate,
           java.util.Calendar sentDate,
           String UA,
           String platform,
           String browserType,
           String link,
           String title,
           String IP,
           String templateName) {
           this.email = email;
           this.sentFlag = sentFlag;
           this.subSentFlag = subSentFlag;
           this.eventDate = eventDate;
           this.addDate = addDate;
           this.sentDate = sentDate;
           this.UA = UA;
           this.platform = platform;
           this.browserType = browserType;
           this.link = link;
           this.title = title;
           this.IP = IP;
           this.templateName = templateName;
    }


    /**
     * Gets the email value for this ReportDetailExt.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ReportDetailExt.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the sentFlag value for this ReportDetailExt.
     * 
     * @return sentFlag
     */
    public int getSentFlag() {
        return sentFlag;
    }


    /**
     * Sets the sentFlag value for this ReportDetailExt.
     * 
     * @param sentFlag
     */
    public void setSentFlag(int sentFlag) {
        this.sentFlag = sentFlag;
    }


    /**
     * Gets the subSentFlag value for this ReportDetailExt.
     * 
     * @return subSentFlag
     */
    public int getSubSentFlag() {
        return subSentFlag;
    }


    /**
     * Sets the subSentFlag value for this ReportDetailExt.
     * 
     * @param subSentFlag
     */
    public void setSubSentFlag(int subSentFlag) {
        this.subSentFlag = subSentFlag;
    }


    /**
     * Gets the eventDate value for this ReportDetailExt.
     * 
     * @return eventDate
     */
    public java.util.Calendar getEventDate() {
        return eventDate;
    }


    /**
     * Sets the eventDate value for this ReportDetailExt.
     * 
     * @param eventDate
     */
    public void setEventDate(java.util.Calendar eventDate) {
        this.eventDate = eventDate;
    }


    /**
     * Gets the addDate value for this ReportDetailExt.
     * 
     * @return addDate
     */
    public java.util.Calendar getAddDate() {
        return addDate;
    }


    /**
     * Sets the addDate value for this ReportDetailExt.
     * 
     * @param addDate
     */
    public void setAddDate(java.util.Calendar addDate) {
        this.addDate = addDate;
    }


    /**
     * Gets the sentDate value for this ReportDetailExt.
     * 
     * @return sentDate
     */
    public java.util.Calendar getSentDate() {
        return sentDate;
    }


    /**
     * Sets the sentDate value for this ReportDetailExt.
     * 
     * @param sentDate
     */
    public void setSentDate(java.util.Calendar sentDate) {
        this.sentDate = sentDate;
    }


    /**
     * Gets the UA value for this ReportDetailExt.
     * 
     * @return UA
     */
    public String getUA() {
        return UA;
    }


    /**
     * Sets the UA value for this ReportDetailExt.
     * 
     * @param UA
     */
    public void setUA(String UA) {
        this.UA = UA;
    }


    /**
     * Gets the platform value for this ReportDetailExt.
     * 
     * @return platform
     */
    public String getPlatform() {
        return platform;
    }


    /**
     * Sets the platform value for this ReportDetailExt.
     * 
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }


    /**
     * Gets the browserType value for this ReportDetailExt.
     * 
     * @return browserType
     */
    public String getBrowserType() {
        return browserType;
    }


    /**
     * Sets the browserType value for this ReportDetailExt.
     * 
     * @param browserType
     */
    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }


    /**
     * Gets the link value for this ReportDetailExt.
     * 
     * @return link
     */
    public String getLink() {
        return link;
    }


    /**
     * Sets the link value for this ReportDetailExt.
     * 
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }


    /**
     * Gets the title value for this ReportDetailExt.
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this ReportDetailExt.
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Gets the IP value for this ReportDetailExt.
     * 
     * @return IP
     */
    public String getIP() {
        return IP;
    }


    /**
     * Sets the IP value for this ReportDetailExt.
     * 
     * @param IP
     */
    public void setIP(String IP) {
        this.IP = IP;
    }


    /**
     * Gets the templateName value for this ReportDetailExt.
     * 
     * @return templateName
     */
    public String getTemplateName() {
        return templateName;
    }


    /**
     * Sets the templateName value for this ReportDetailExt.
     * 
     * @param templateName
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ReportDetailExt)) return false;
        ReportDetailExt other = (ReportDetailExt) obj;
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
            this.sentFlag == other.getSentFlag() &&
            this.subSentFlag == other.getSubSentFlag() &&
            ((this.eventDate==null && other.getEventDate()==null) || 
             (this.eventDate!=null &&
              this.eventDate.equals(other.getEventDate()))) &&
            ((this.addDate==null && other.getAddDate()==null) || 
             (this.addDate!=null &&
              this.addDate.equals(other.getAddDate()))) &&
            ((this.sentDate==null && other.getSentDate()==null) || 
             (this.sentDate!=null &&
              this.sentDate.equals(other.getSentDate()))) &&
            ((this.UA==null && other.getUA()==null) || 
             (this.UA!=null &&
              this.UA.equals(other.getUA()))) &&
            ((this.platform==null && other.getPlatform()==null) || 
             (this.platform!=null &&
              this.platform.equals(other.getPlatform()))) &&
            ((this.browserType==null && other.getBrowserType()==null) || 
             (this.browserType!=null &&
              this.browserType.equals(other.getBrowserType()))) &&
            ((this.link==null && other.getLink()==null) || 
             (this.link!=null &&
              this.link.equals(other.getLink()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.IP==null && other.getIP()==null) || 
             (this.IP!=null &&
              this.IP.equals(other.getIP()))) &&
            ((this.templateName==null && other.getTemplateName()==null) || 
             (this.templateName!=null &&
              this.templateName.equals(other.getTemplateName())));
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
        _hashCode += getSentFlag();
        _hashCode += getSubSentFlag();
        if (getEventDate() != null) {
            _hashCode += getEventDate().hashCode();
        }
        if (getAddDate() != null) {
            _hashCode += getAddDate().hashCode();
        }
        if (getSentDate() != null) {
            _hashCode += getSentDate().hashCode();
        }
        if (getUA() != null) {
            _hashCode += getUA().hashCode();
        }
        if (getPlatform() != null) {
            _hashCode += getPlatform().hashCode();
        }
        if (getBrowserType() != null) {
            _hashCode += getBrowserType().hashCode();
        }
        if (getLink() != null) {
            _hashCode += getLink().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getIP() != null) {
            _hashCode += getIP().hashCode();
        }
        if (getTemplateName() != null) {
            _hashCode += getTemplateName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportDetailExt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ReportDetailExt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subSentFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SubSentFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EventDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AddDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "UA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("platform");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Platform"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("browserType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "BrowserType"));
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
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Title"));
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
        elemField.setFieldName("templateName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateName"));
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
