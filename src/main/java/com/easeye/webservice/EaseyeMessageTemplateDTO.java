/**
 * EaseyeMessageTemplateDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class EaseyeMessageTemplateDTO  implements java.io.Serializable {
    private String templateName;

    private String subject;

    private String body;

    private boolean hasAD;

    private boolean hasSysBody;

    private String attachmentUrl;

    private String trackLink;

    private String isBodyHtml;

    private String attachmentGUID;

    public EaseyeMessageTemplateDTO() {
    }

    public EaseyeMessageTemplateDTO(
           String templateName,
           String subject,
           String body,
           boolean hasAD,
           boolean hasSysBody,
           String attachmentUrl,
           String trackLink,
           String isBodyHtml,
           String attachmentGUID) {
           this.templateName = templateName;
           this.subject = subject;
           this.body = body;
           this.hasAD = hasAD;
           this.hasSysBody = hasSysBody;
           this.attachmentUrl = attachmentUrl;
           this.trackLink = trackLink;
           this.isBodyHtml = isBodyHtml;
           this.attachmentGUID = attachmentGUID;
    }


    /**
     * Gets the templateName value for this EaseyeMessageTemplateDTO.
     * 
     * @return templateName
     */
    public String getTemplateName() {
        return templateName;
    }


    /**
     * Sets the templateName value for this EaseyeMessageTemplateDTO.
     * 
     * @param templateName
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    /**
     * Gets the subject value for this EaseyeMessageTemplateDTO.
     * 
     * @return subject
     */
    public String getSubject() {
        return subject;
    }


    /**
     * Sets the subject value for this EaseyeMessageTemplateDTO.
     * 
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }


    /**
     * Gets the body value for this EaseyeMessageTemplateDTO.
     * 
     * @return body
     */
    public String getBody() {
        return body;
    }


    /**
     * Sets the body value for this EaseyeMessageTemplateDTO.
     * 
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }


    /**
     * Gets the hasAD value for this EaseyeMessageTemplateDTO.
     * 
     * @return hasAD
     */
    public boolean isHasAD() {
        return hasAD;
    }


    /**
     * Sets the hasAD value for this EaseyeMessageTemplateDTO.
     * 
     * @param hasAD
     */
    public void setHasAD(boolean hasAD) {
        this.hasAD = hasAD;
    }


    /**
     * Gets the hasSysBody value for this EaseyeMessageTemplateDTO.
     * 
     * @return hasSysBody
     */
    public boolean isHasSysBody() {
        return hasSysBody;
    }


    /**
     * Sets the hasSysBody value for this EaseyeMessageTemplateDTO.
     * 
     * @param hasSysBody
     */
    public void setHasSysBody(boolean hasSysBody) {
        this.hasSysBody = hasSysBody;
    }


    /**
     * Gets the attachmentUrl value for this EaseyeMessageTemplateDTO.
     * 
     * @return attachmentUrl
     */
    public String getAttachmentUrl() {
        return attachmentUrl;
    }


    /**
     * Sets the attachmentUrl value for this EaseyeMessageTemplateDTO.
     * 
     * @param attachmentUrl
     */
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }


    /**
     * Gets the trackLink value for this EaseyeMessageTemplateDTO.
     * 
     * @return trackLink
     */
    public String getTrackLink() {
        return trackLink;
    }


    /**
     * Sets the trackLink value for this EaseyeMessageTemplateDTO.
     * 
     * @param trackLink
     */
    public void setTrackLink(String trackLink) {
        this.trackLink = trackLink;
    }


    /**
     * Gets the isBodyHtml value for this EaseyeMessageTemplateDTO.
     * 
     * @return isBodyHtml
     */
    public String getIsBodyHtml() {
        return isBodyHtml;
    }


    /**
     * Sets the isBodyHtml value for this EaseyeMessageTemplateDTO.
     * 
     * @param isBodyHtml
     */
    public void setIsBodyHtml(String isBodyHtml) {
        this.isBodyHtml = isBodyHtml;
    }


    /**
     * Gets the attachmentGUID value for this EaseyeMessageTemplateDTO.
     * 
     * @return attachmentGUID
     */
    public String getAttachmentGUID() {
        return attachmentGUID;
    }


    /**
     * Sets the attachmentGUID value for this EaseyeMessageTemplateDTO.
     * 
     * @param attachmentGUID
     */
    public void setAttachmentGUID(String attachmentGUID) {
        this.attachmentGUID = attachmentGUID;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof EaseyeMessageTemplateDTO)) return false;
        EaseyeMessageTemplateDTO other = (EaseyeMessageTemplateDTO) obj;
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
            ((this.subject==null && other.getSubject()==null) || 
             (this.subject!=null &&
              this.subject.equals(other.getSubject()))) &&
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody()))) &&
            this.hasAD == other.isHasAD() &&
            this.hasSysBody == other.isHasSysBody() &&
            ((this.attachmentUrl==null && other.getAttachmentUrl()==null) || 
             (this.attachmentUrl!=null &&
              this.attachmentUrl.equals(other.getAttachmentUrl()))) &&
            ((this.trackLink==null && other.getTrackLink()==null) || 
             (this.trackLink!=null &&
              this.trackLink.equals(other.getTrackLink()))) &&
            ((this.isBodyHtml==null && other.getIsBodyHtml()==null) || 
             (this.isBodyHtml!=null &&
              this.isBodyHtml.equals(other.getIsBodyHtml()))) &&
            ((this.attachmentGUID==null && other.getAttachmentGUID()==null) || 
             (this.attachmentGUID!=null &&
              this.attachmentGUID.equals(other.getAttachmentGUID())));
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
        if (getSubject() != null) {
            _hashCode += getSubject().hashCode();
        }
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        _hashCode += (isHasAD() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasSysBody() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getAttachmentUrl() != null) {
            _hashCode += getAttachmentUrl().hashCode();
        }
        if (getTrackLink() != null) {
            _hashCode += getTrackLink().hashCode();
        }
        if (getIsBodyHtml() != null) {
            _hashCode += getIsBodyHtml().hashCode();
        }
        if (getAttachmentGUID() != null) {
            _hashCode += getAttachmentGUID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EaseyeMessageTemplateDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "EaseyeMessageTemplateDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("templateName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TemplateName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subject");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Subject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "Body"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasAD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "HasAD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasSysBody");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "HasSysBody"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachmentUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trackLink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "TrackLink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isBodyHtml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "IsBodyHtml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachmentGUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "AttachmentGUID"));
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
