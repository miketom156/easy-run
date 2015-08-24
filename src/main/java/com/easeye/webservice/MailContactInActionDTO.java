/**
 * MailContactInActionDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.easeye.webservice;

public class MailContactInActionDTO  implements java.io.Serializable {
    private int sentFlag;

    private String email;

    private java.util.Calendar actDateTime;

    private String IP;

    private String actDescription;

    private String sentMailListName;

    private java.util.Calendar sentMailListDateTime;

    public MailContactInActionDTO() {
    }

    public MailContactInActionDTO(
           int sentFlag,
           String email,
           java.util.Calendar actDateTime,
           String IP,
           String actDescription,
           String sentMailListName,
           java.util.Calendar sentMailListDateTime) {
           this.sentFlag = sentFlag;
           this.email = email;
           this.actDateTime = actDateTime;
           this.IP = IP;
           this.actDescription = actDescription;
           this.sentMailListName = sentMailListName;
           this.sentMailListDateTime = sentMailListDateTime;
    }


    /**
     * Gets the sentFlag value for this MailContactInActionDTO.
     * 
     * @return sentFlag
     */
    public int getSentFlag() {
        return sentFlag;
    }


    /**
     * Sets the sentFlag value for this MailContactInActionDTO.
     * 
     * @param sentFlag
     */
    public void setSentFlag(int sentFlag) {
        this.sentFlag = sentFlag;
    }


    /**
     * Gets the email value for this MailContactInActionDTO.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this MailContactInActionDTO.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the actDateTime value for this MailContactInActionDTO.
     * 
     * @return actDateTime
     */
    public java.util.Calendar getActDateTime() {
        return actDateTime;
    }


    /**
     * Sets the actDateTime value for this MailContactInActionDTO.
     * 
     * @param actDateTime
     */
    public void setActDateTime(java.util.Calendar actDateTime) {
        this.actDateTime = actDateTime;
    }


    /**
     * Gets the IP value for this MailContactInActionDTO.
     * 
     * @return IP
     */
    public String getIP() {
        return IP;
    }


    /**
     * Sets the IP value for this MailContactInActionDTO.
     * 
     * @param IP
     */
    public void setIP(String IP) {
        this.IP = IP;
    }


    /**
     * Gets the actDescription value for this MailContactInActionDTO.
     * 
     * @return actDescription
     */
    public String getActDescription() {
        return actDescription;
    }


    /**
     * Sets the actDescription value for this MailContactInActionDTO.
     * 
     * @param actDescription
     */
    public void setActDescription(String actDescription) {
        this.actDescription = actDescription;
    }


    /**
     * Gets the sentMailListName value for this MailContactInActionDTO.
     * 
     * @return sentMailListName
     */
    public String getSentMailListName() {
        return sentMailListName;
    }


    /**
     * Sets the sentMailListName value for this MailContactInActionDTO.
     * 
     * @param sentMailListName
     */
    public void setSentMailListName(String sentMailListName) {
        this.sentMailListName = sentMailListName;
    }


    /**
     * Gets the sentMailListDateTime value for this MailContactInActionDTO.
     * 
     * @return sentMailListDateTime
     */
    public java.util.Calendar getSentMailListDateTime() {
        return sentMailListDateTime;
    }


    /**
     * Sets the sentMailListDateTime value for this MailContactInActionDTO.
     * 
     * @param sentMailListDateTime
     */
    public void setSentMailListDateTime(java.util.Calendar sentMailListDateTime) {
        this.sentMailListDateTime = sentMailListDateTime;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof MailContactInActionDTO)) return false;
        MailContactInActionDTO other = (MailContactInActionDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.sentFlag == other.getSentFlag() &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.actDateTime==null && other.getActDateTime()==null) || 
             (this.actDateTime!=null &&
              this.actDateTime.equals(other.getActDateTime()))) &&
            ((this.IP==null && other.getIP()==null) || 
             (this.IP!=null &&
              this.IP.equals(other.getIP()))) &&
            ((this.actDescription==null && other.getActDescription()==null) || 
             (this.actDescription!=null &&
              this.actDescription.equals(other.getActDescription()))) &&
            ((this.sentMailListName==null && other.getSentMailListName()==null) || 
             (this.sentMailListName!=null &&
              this.sentMailListName.equals(other.getSentMailListName()))) &&
            ((this.sentMailListDateTime==null && other.getSentMailListDateTime()==null) || 
             (this.sentMailListDateTime!=null &&
              this.sentMailListDateTime.equals(other.getSentMailListDateTime())));
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
        _hashCode += getSentFlag();
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getActDateTime() != null) {
            _hashCode += getActDateTime().hashCode();
        }
        if (getIP() != null) {
            _hashCode += getIP().hashCode();
        }
        if (getActDescription() != null) {
            _hashCode += getActDescription().hashCode();
        }
        if (getSentMailListName() != null) {
            _hashCode += getSentMailListName().hashCode();
        }
        if (getSentMailListDateTime() != null) {
            _hashCode += getSentMailListDateTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailContactInActionDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "MailContactInActionDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("actDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ActDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("actDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "ActDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentMailListName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentMailListName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sentMailListDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://192.168.0.43/MailWebService/MailWebService.asmx", "SentMailListDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
